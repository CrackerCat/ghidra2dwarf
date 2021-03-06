package libdwarf;
import com.ochafik.lang.jnaerator.runtime.Structure;
import com.sun.jna.Callback;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import java.util.Arrays;
import java.util.List;
/**
 * The functions we need to access object data from libdwarf are declared here.<br>
 * In these function pointer declarations<br>
 * 'void *obj' is intended to be a pointer (the object field in<br>
 * Dwarf_Obj_Access_Interface_s)<br>
 * that hides the library-specific and object-specific data that makes<br>
 * it possible to handle multiple object formats and multiple libraries.<br>
 * It's not required that one handles multiple such in a single libdwarf<br>
 * archive/shared-library (but not ruled out either).<br>
 * See  dwarf_elf_object_access_internals_t and dwarf_elf_access.c<br>
 * for an example.<br>
 * <i>native declaration : line 672</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class Dwarf_Obj_Access_Methods_s extends Structure<Dwarf_Obj_Access_Methods_s, Dwarf_Obj_Access_Methods_s.ByValue, Dwarf_Obj_Access_Methods_s.ByReference > {
	/**
	 * get_section_info<br>
	 * Get address, size, and name info about a section.<br>
	 * Parameters<br>
	 * section_index - Zero-based index.<br>
	 * return_section - Pointer to a structure in which section info<br>
	 * will be placed.   Caller must provide a valid pointer to a<br>
	 * structure area.  The structure's contents will be overwritten<br>
	 * by the call to get_section_info.<br>
	 * error - A pointer to an integer in which an error code may be stored.<br>
	 * Return<br>
	 * DW_DLV_OK - Everything ok.<br>
	 * DW_DLV_ERROR - Error occurred. Use 'error' to determine the<br>
	 * libdwarf defined error.<br>
	 * DW_DLV_NO_ENTRY - No such section.<br>
	 * C type : get_section_info_callback*
	 */
	public Dwarf_Obj_Access_Methods_s.get_section_info_callback get_section_info;
	/**
	 * get_byte_order<br>
	 * Get whether the object file represented by this interface is big-endian<br>
	 * (DW_OBJECT_MSB) or little endian (DW_OBJECT_LSB).<br>
	 * Parameters<br>
	 * obj - Equivalent to 'this' in OO languages.<br>
	 * Return<br>
	 * Endianness of object. Cannot fail.<br>
	 * C type : get_byte_order_callback*
	 */
	public Dwarf_Obj_Access_Methods_s.get_byte_order_callback get_byte_order;
	/**
	 * get_length_size<br>
	 * Get the size of a length field in the underlying object file.<br>
	 * libdwarf currently supports * 4 and 8 byte sizes, but may<br>
	 * support larger in the future.<br>
	 * Perhaps the return type should be an enumeration?<br>
	 * Parameters<br>
	 * obj - Equivalent to 'this' in OO languages.<br>
	 * Return<br>
	 * Size of length. Cannot fail.<br>
	 * C type : get_length_size_callback*
	 */
	public Dwarf_Obj_Access_Methods_s.get_length_size_callback get_length_size;
	/**
	 * get_pointer_size<br>
	 * Get the size of a pointer field in the underlying object file.<br>
	 * libdwarf currently supports  4 and 8 byte sizes.<br>
	 * Perhaps the return type should be an enumeration?<br>
	 * Return<br>
	 * Size of pointer. Cannot fail.<br>
	 * C type : get_pointer_size_callback*
	 */
	public Dwarf_Obj_Access_Methods_s.get_pointer_size_callback get_pointer_size;
	/**
	 * get_section_count<br>
	 * Get the number of sections in the object file.<br>
	 * Parameters<br>
	 * Return<br>
	 * Number of sections<br>
	 * C type : get_section_count_callback*
	 */
	public Dwarf_Obj_Access_Methods_s.get_section_count_callback get_section_count;
	/**
	 * load_section<br>
	 * Get a pointer to an array of bytes that represent the section.<br>
	 * Parameters<br>
	 * section_index - Zero-based index.<br>
	 * return_data - The address of a pointer to which the section data block<br>
	 * will be assigned.<br>
	 * error - Pointer to an integer for returning libdwarf-defined<br>
	 * error numbers.<br>
	 * Return<br>
	 * DW_DLV_OK - No error.<br>
	 * DW_DLV_ERROR - Error. Use 'error' to indicate a libdwarf-defined<br>
	 * error number.<br>
	 * DW_DLV_NO_ENTRY - No such section.<br>
	 * C type : load_section_callback*
	 */
	public Dwarf_Obj_Access_Methods_s.load_section_callback load_section;
	/**
	 * relocate_a_section<br>
	 * If relocations are not supported leave this pointer NULL.<br>
	 * Get a pointer to an array of bytes that represent the section.<br>
	 * Parameters<br>
	 * section_index - Zero-based index of the section to be relocated.<br>
	 * error - Pointer to an integer for returning libdwarf-defined<br>
	 * error numbers.<br>
	 * Return<br>
	 * DW_DLV_OK - No error.<br>
	 * DW_DLV_ERROR - Error. Use 'error' to indicate a libdwarf-defined<br>
	 * error number.<br>
	 * DW_DLV_NO_ENTRY - No such section.<br>
	 * C type : relocate_a_section_callback*
	 */
	public Dwarf_Obj_Access_Methods_s.relocate_a_section_callback relocate_a_section;
	public interface get_section_info_callback extends Callback {
		int apply(Pointer obj, short section_index, Dwarf_Obj_Access_Section_s return_section, IntByReference error);
	};
	public interface get_byte_order_callback extends Callback {
		int apply(Pointer obj);
	};
	public interface get_length_size_callback extends Callback {
		byte apply(Pointer obj);
	};
	public interface get_pointer_size_callback extends Callback {
		byte apply(Pointer obj);
	};
	public interface get_section_count_callback extends Callback {
		long apply(Pointer obj);
	};
	public interface load_section_callback extends Callback {
		int apply(Pointer obj, short section_index, PointerByReference return_data, IntByReference error);
	};
	public interface relocate_a_section_callback extends Callback {
		int apply(Pointer obj, short section_index, Pointer dbg, IntByReference error);
	};
	public Dwarf_Obj_Access_Methods_s() {
		super();
	}
	protected List<? > getFieldOrder() {
		return Arrays.asList("get_section_info", "get_byte_order", "get_length_size", "get_pointer_size", "get_section_count", "load_section", "relocate_a_section");
	}
	/**
	 * @param get_section_info get_section_info<br>
	 * Get address, size, and name info about a section.<br>
	 * Parameters<br>
	 * section_index - Zero-based index.<br>
	 * return_section - Pointer to a structure in which section info<br>
	 * will be placed.   Caller must provide a valid pointer to a<br>
	 * structure area.  The structure's contents will be overwritten<br>
	 * by the call to get_section_info.<br>
	 * error - A pointer to an integer in which an error code may be stored.<br>
	 * Return<br>
	 * DW_DLV_OK - Everything ok.<br>
	 * DW_DLV_ERROR - Error occurred. Use 'error' to determine the<br>
	 * libdwarf defined error.<br>
	 * DW_DLV_NO_ENTRY - No such section.<br>
	 * C type : get_section_info_callback*<br>
	 * @param get_byte_order get_byte_order<br>
	 * Get whether the object file represented by this interface is big-endian<br>
	 * (DW_OBJECT_MSB) or little endian (DW_OBJECT_LSB).<br>
	 * Parameters<br>
	 * obj - Equivalent to 'this' in OO languages.<br>
	 * Return<br>
	 * Endianness of object. Cannot fail.<br>
	 * C type : get_byte_order_callback*<br>
	 * @param get_length_size get_length_size<br>
	 * Get the size of a length field in the underlying object file.<br>
	 * libdwarf currently supports * 4 and 8 byte sizes, but may<br>
	 * support larger in the future.<br>
	 * Perhaps the return type should be an enumeration?<br>
	 * Parameters<br>
	 * obj - Equivalent to 'this' in OO languages.<br>
	 * Return<br>
	 * Size of length. Cannot fail.<br>
	 * C type : get_length_size_callback*<br>
	 * @param get_pointer_size get_pointer_size<br>
	 * Get the size of a pointer field in the underlying object file.<br>
	 * libdwarf currently supports  4 and 8 byte sizes.<br>
	 * Perhaps the return type should be an enumeration?<br>
	 * Return<br>
	 * Size of pointer. Cannot fail.<br>
	 * C type : get_pointer_size_callback*<br>
	 * @param get_section_count get_section_count<br>
	 * Get the number of sections in the object file.<br>
	 * Parameters<br>
	 * Return<br>
	 * Number of sections<br>
	 * C type : get_section_count_callback*<br>
	 * @param load_section load_section<br>
	 * Get a pointer to an array of bytes that represent the section.<br>
	 * Parameters<br>
	 * section_index - Zero-based index.<br>
	 * return_data - The address of a pointer to which the section data block<br>
	 * will be assigned.<br>
	 * error - Pointer to an integer for returning libdwarf-defined<br>
	 * error numbers.<br>
	 * Return<br>
	 * DW_DLV_OK - No error.<br>
	 * DW_DLV_ERROR - Error. Use 'error' to indicate a libdwarf-defined<br>
	 * error number.<br>
	 * DW_DLV_NO_ENTRY - No such section.<br>
	 * C type : load_section_callback*<br>
	 * @param relocate_a_section relocate_a_section<br>
	 * If relocations are not supported leave this pointer NULL.<br>
	 * Get a pointer to an array of bytes that represent the section.<br>
	 * Parameters<br>
	 * section_index - Zero-based index of the section to be relocated.<br>
	 * error - Pointer to an integer for returning libdwarf-defined<br>
	 * error numbers.<br>
	 * Return<br>
	 * DW_DLV_OK - No error.<br>
	 * DW_DLV_ERROR - Error. Use 'error' to indicate a libdwarf-defined<br>
	 * error number.<br>
	 * DW_DLV_NO_ENTRY - No such section.<br>
	 * C type : relocate_a_section_callback*
	 */
	public Dwarf_Obj_Access_Methods_s(Dwarf_Obj_Access_Methods_s.get_section_info_callback get_section_info, Dwarf_Obj_Access_Methods_s.get_byte_order_callback get_byte_order, Dwarf_Obj_Access_Methods_s.get_length_size_callback get_length_size, Dwarf_Obj_Access_Methods_s.get_pointer_size_callback get_pointer_size, Dwarf_Obj_Access_Methods_s.get_section_count_callback get_section_count, Dwarf_Obj_Access_Methods_s.load_section_callback load_section, Dwarf_Obj_Access_Methods_s.relocate_a_section_callback relocate_a_section) {
		super();
		this.get_section_info = get_section_info;
		this.get_byte_order = get_byte_order;
		this.get_length_size = get_length_size;
		this.get_pointer_size = get_pointer_size;
		this.get_section_count = get_section_count;
		this.load_section = load_section;
		this.relocate_a_section = relocate_a_section;
	}
	protected ByReference newByReference() { return new ByReference(); }
	protected ByValue newByValue() { return new ByValue(); }
	protected Dwarf_Obj_Access_Methods_s newInstance() { return new Dwarf_Obj_Access_Methods_s(); }
	public static Dwarf_Obj_Access_Methods_s[] newArray(int arrayLength) {
		return Structure.newArray(Dwarf_Obj_Access_Methods_s.class, arrayLength);
	}
	public static class ByReference extends Dwarf_Obj_Access_Methods_s implements Structure.ByReference {
		
	};
	public static class ByValue extends Dwarf_Obj_Access_Methods_s implements Structure.ByValue {
		
	};
}
