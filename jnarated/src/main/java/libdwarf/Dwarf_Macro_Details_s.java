package libdwarf;
import com.ochafik.lang.jnaerator.runtime.Structure;
import com.sun.jna.Pointer;
import java.util.Arrays;
import java.util.List;
/**
 * consumer .debug_macinfo information interface.<br>
 * <i>native declaration : line 3320</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class Dwarf_Macro_Details_s extends Structure<Dwarf_Macro_Details_s, Dwarf_Macro_Details_s.ByValue, Dwarf_Macro_Details_s.ByReference > {
	/**
	 * offset, in the section,<br>
	 * of this macro info<br>
	 * C type : Dwarf_Off
	 */
	public long dmd_offset;
	/**
	 * the type, DW_MACINFO_define etc<br>
	 * C type : Dwarf_Small
	 */
	public byte dmd_type;
	/**
	 * the source line number where<br>
	 * applicable and vend_def number if<br>
	 * vendor_extension op<br>
	 * C type : Dwarf_Signed
	 */
	public long dmd_lineno;
	/**
	 * the source file index:<br>
	 * applies to define undef start_file<br>
	 * C type : Dwarf_Signed
	 */
	public long dmd_fileindex;
	/**
	 * macro name (with value for defineop)<br>
	 * string from vendor ext<br>
	 * C type : char*
	 */
	public Pointer dmd_macro;
	public Dwarf_Macro_Details_s() {
		super();
	}
	protected List<? > getFieldOrder() {
		return Arrays.asList("dmd_offset", "dmd_type", "dmd_lineno", "dmd_fileindex", "dmd_macro");
	}
	/**
	 * @param dmd_offset offset, in the section,<br>
	 * of this macro info<br>
	 * C type : Dwarf_Off<br>
	 * @param dmd_type the type, DW_MACINFO_define etc<br>
	 * C type : Dwarf_Small<br>
	 * @param dmd_lineno the source line number where<br>
	 * applicable and vend_def number if<br>
	 * vendor_extension op<br>
	 * C type : Dwarf_Signed<br>
	 * @param dmd_fileindex the source file index:<br>
	 * applies to define undef start_file<br>
	 * C type : Dwarf_Signed<br>
	 * @param dmd_macro macro name (with value for defineop)<br>
	 * string from vendor ext<br>
	 * C type : char*
	 */
	public Dwarf_Macro_Details_s(long dmd_offset, byte dmd_type, long dmd_lineno, long dmd_fileindex, Pointer dmd_macro) {
		super();
		this.dmd_offset = dmd_offset;
		this.dmd_type = dmd_type;
		this.dmd_lineno = dmd_lineno;
		this.dmd_fileindex = dmd_fileindex;
		this.dmd_macro = dmd_macro;
	}
	protected ByReference newByReference() { return new ByReference(); }
	protected ByValue newByValue() { return new ByValue(); }
	protected Dwarf_Macro_Details_s newInstance() { return new Dwarf_Macro_Details_s(); }
	public static Dwarf_Macro_Details_s[] newArray(int arrayLength) {
		return Structure.newArray(Dwarf_Macro_Details_s.class, arrayLength);
	}
	public static class ByReference extends Dwarf_Macro_Details_s implements Structure.ByReference {
		
	};
	public static class ByValue extends Dwarf_Macro_Details_s implements Structure.ByValue {
		
	};
}
