# Ghidra2Dwarf
# @author sen, meowmeowxw
# @category _NEW_
# @keybinding
# @menupath
# @toolbar

try:
    from ghidra_builtins import *
except:
    pass


from ghidra.app.decompiler import DecompInterface, DecompileOptions
from ghidra.app.util.bin.format.elf import ElfSymbolTable
from ghidra.app.decompiler.component import DecompilerUtils
from ghidra.program.database.data import PointerDB
from ghidra.program.model.data import Pointer, Structure, DefaultDataType, BuiltInDataType


from libdwarf import LibdwarfLibrary
from com.sun.jna.ptr import PointerByReference
from com.sun.jna import Memory
from java.nio import ByteBuffer

from sys import stderr


class Options:
    def __init__(self, use_dec=False, only_dec_nam_fun=False, att_deb_inf=False, verbose=False):
        self.use_decompiler = use_dec
        self.only_decompile_named_funcs = only_dec_nam_fun
        self.attach_debug_info = att_deb_inf
        self.verbose = verbose
        self.filepath = ""
        self.filename = ""
        self.dwarf_source_path = ""
        self.export_options = 0


def add_debug_info():
    dwarf_pro_set_default_string_form(dbg, DW_FORM_string, err)
    cu = dwarf_new_die(dbg, DW_TAG_compile_unit, None, None, None, None, err)
    print cu
    if options.use_decompiler:
        if dwarf_add_AT_name(cu, ext_c(curr.name), err) == None:
            stderr.write("dwarf_add_AT_name error")
        dir_index = dwarf_add_directory_decl(dbg, ext_dbg(curr.name), err)
        file_index = dwarf_add_file_decl(dbg, ext_c(curr.name), dir_index, 0, 0, err)
        dwarf_add_AT_comp_dir(cu, ext_dbg(curr.name), err)
    # memory = curr.getMemory()
    # Get sections
    # memory.getBlocks()

    # Get segments
    # memory.getLoadedAndInitializedAddressSet()

    # Get executable segments
    # list(memory.getExecuteSet().getAddressRanges())

    # However we can omit this step and directly decompile all functions

    linecount = 1
    for f in get_functions():
        if is_function_executable(f):
            add_function(cu, f, linecount, file_index)
        pass
        # results = ifc.decompileFunction(f, 0, ConsoleTaskMonitor())
        # print (results.getDecompiledFunction().getC())


def generate_decomp_interface():
    decompiler = DecompInterface()
    opts = DecompileOptions()
    opts.grabFromProgram(curr)
    decompiler.setOptions(opts)
    decompiler.toggleCCode(True)
    decompiler.toggleSyntaxTree(True)

    # - decompile -- The main decompiler action
    # - normalize -- Decompilation tuned for normalization
    # - jumptable -- Simplify just enough to recover a jump-table
    # - paramid   -- Simplify enough to recover function parameters
    # - register  -- Perform one analysis pass on registers, without stack variables
    # - firstpass -- Construct the initial raw syntax tree, with no simplification
    decompiler.setSimplificationStyle("decompile")
    decompiler.openProgram(curr)
    return decompiler


def get_decompiled_function(func):
    return decompiler.decompileFunction(func, 0, monitor)


def get_decompiled_variables(decomp):
    hf = decomp.highFunction
    for s in hf.localSymbolMap.symbols:
        hv = s.highVariable
        yield s.name, hv.dataType, s.PCAddress, hv.storage


def add_decompiler_func_info(cu, func_die, func, source_file_dwarfindex):
    # https://ghidra.re/ghidra_docs/api/ghidra/app/decompiler/DecompileResults.html
    # print func.allVariables
    decomp = get_decompiled_function(func)
    for name, datatype, addr, storage in get_decompiled_variables(decomp):
        pass
        # print name, datatype, addr, storage
        # add_variable(cu, name, datatype, addr, storage)

    cmarkup = decomp.CCodeMarkup
    # TODO: implement our own pretty printer?
    # https://github.com/NationalSecurityAgency/ghidra/blob/master/Ghidra/Features/Decompiler/src/main/java/ghidra/app/decompiler/PrettyPrinter.java
    lines = DecompilerUtils.toLines(cmarkup)
    for l in lines:
        # TODO: multiple lines might have the same lowest address
        addresses = [t.minAddress for t in l.allTokens if t.minAddress]
        lowest_addr = min(addresses) if addresses else None
        # print lowest_addr, l
        # https://nxmnpg.lemoda.net/3/dwarf_add_line_entry
        # dwarf_add_line_entry(dbg, source_file_dwarfindex,
        #     lowest_addr, l.lineNumber, 0, True, False, err)


def get_functions():
    fm = curr.functionManager
    funcs = fm.getFunctions(True)
    return funcs


def get_function_range(func):
    return (func.entryPoint, func.body.maxAddress)


def is_function_executable(func):
    f_start, f_end = get_function_range(func)
    # Check for functions inside executable segments
    for s in curr.memory.executeSet.addressRanges:
        if f_start.offset >= s.minAddress.offset and f_end.offset <= s.maxAddress.offset:
            return True
    return False


def add_function(cu, func, linecount, file_index):
    die = dwarf_new_die(dbg, DW_TAG_subprogram, cu, None, None, None, err)
    if die == None:
        stderr.write("dwarf_new_die error")
    loc_expr = dwarf_new_expr(dbg, err)
    if dwarf_add_expr_gen(loc_expr, DW_OP_call_frame_cfa, 0, 0, err) == DW_DLV_NOCOUNT:
        stderr.write("dwarf_add_expr_gen error")
    if dwarf_add_AT_location_expr(dbg, die, DW_AT_frame_base, loc_expr, err) == None:
        stderr.write("dwarf_add_AT_location_expr error")
    # TODO: Understand difference between c_name and mangled_name
    f_name = func.name
    if dwarf_add_AT_name(die, f_name, err) == None:
        stderr.write("dwarf_add_AT_name error")
    if dwarf_add_AT_string(dbg, die, DW_AT_linkage_name, f_name, err) == None:
        stderr.write("dwarf_add_AT_string error")

    # TODO: Check for multiple ranges
    f_start, f_end = get_function_range(func)
    if f_name == "main":
        add_decompiler_func_info(cu, die, func, 0)

    t = func.returnType
    print f_start, f_end, type(t), t.description, func.name
    add_type(cu, func.returnType)
    # add_type(cu, func.returnType.description)


def add_type(cu, t):
    if isinstance(t, Pointer):
        # print type(t), t
        return add_ptr_type(cu, t)
    elif isinstance(t, DefaultDataType):
        # TODO: an example of DefaultDataType is `undefined`
        return None
    elif isinstance(t, BuiltInDataType):
        # TODO: an example of BuiltInDataType is `int`
        return None
    elif isinstance(t, Structure):
        # print type(t), t
        return add_struct_type(cu, t)
    else:
        raise Exception(("ERR type:", type(t), t))
        return None


def add_ptr_type(cu, t):
    assert "pointer" in t.description
    die = dwarf_new_die(dbg, DW_TAG_compile_unit, cu, None, None, None, err)

    # TODO: Add without pointer
    # dwarf_add_AT_reference(dbg, die, DW_AT_type, )
    if dwarf_add_AT_unsigned_const(dbg, die, DW_AT_byte_size, 8, err) == None:
        stderr.write("dwarf_add_AT_unsigned_const error")
    return die


def add_struct_type(cu, struct):
    die = dwarf_new_die(dbg, DW_TAG_structure_type, cu, None, None, None, err)
    if dwarf_add_AT_name(die, struct.name, err) == None:
        stderr.write("dwarf_add_AT_name error")
    dwarf_add_AT_unsigned_const(dbg, die, DW_AT_byte_size, struct.length, err)
    for c in struct.components:
        # print c.dataType
        pass


ext_c = lambda s: s + ".c"
ext_dbg = lambda s: s + ".dbg"

l = LibdwarfLibrary.INSTANCE
curr = getCurrentProgram()
decompiler = generate_decomp_interface()
g = globals()
for i in LibdwarfLibrary.__dict__.keys():
    g[i] = getattr(l, i)

print DW_DLE_DWARF_INIT_DBG_NULL
print DW_DLE_HEX_STRING_ERROR

dbg = PointerByReference()
err = PointerByReference()
dwarf_producer_init(
    DW_DLC_WRITE
    | DW_DLC_SYMBOLIC_RELOCATIONS
    | DW_DLC_POINTER64
    | DW_DLC_OFFSET32
    | DW_DLC_TARGET_LITTLEENDIAN,
    lambda x: 0,
    None,
    None,
    None,
    "x86_64",
    "V2",
    None,
    dbg,
    err,
)
dbg = Dwarf_P_Debug(dbg.value)
options = Options(use_dec=True)
add_debug_info()

