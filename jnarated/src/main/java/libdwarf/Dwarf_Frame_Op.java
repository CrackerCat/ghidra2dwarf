package libdwarf;
import com.ochafik.lang.jnaerator.runtime.Structure;
import java.util.Arrays;
import java.util.List;
/**
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class Dwarf_Frame_Op extends Structure<Dwarf_Frame_Op, Dwarf_Frame_Op.ByValue, Dwarf_Frame_Op.ByReference > {
	/** C type : Dwarf_Small */
	public byte fp_base_op;
	/** C type : Dwarf_Small */
	public byte fp_extended_op;
	/** C type : Dwarf_Half */
	public short fp_register;
	/**
	 * Value may be signed, depends on op.<br>
	 * Any applicable data_alignment_factor has<br>
	 * not been applied, this is the  raw offset.<br>
	 * C type : Dwarf_Unsigned
	 */
	public long fp_offset;
	/** C type : Dwarf_Off */
	public long fp_instr_offset;
	public Dwarf_Frame_Op() {
		super();
	}
	protected List<? > getFieldOrder() {
		return Arrays.asList("fp_base_op", "fp_extended_op", "fp_register", "fp_offset", "fp_instr_offset");
	}
	/**
	 * @param fp_base_op C type : Dwarf_Small<br>
	 * @param fp_extended_op C type : Dwarf_Small<br>
	 * @param fp_register C type : Dwarf_Half<br>
	 * @param fp_offset Value may be signed, depends on op.<br>
	 * Any applicable data_alignment_factor has<br>
	 * not been applied, this is the  raw offset.<br>
	 * C type : Dwarf_Unsigned<br>
	 * @param fp_instr_offset C type : Dwarf_Off
	 */
	public Dwarf_Frame_Op(byte fp_base_op, byte fp_extended_op, short fp_register, long fp_offset, long fp_instr_offset) {
		super();
		this.fp_base_op = fp_base_op;
		this.fp_extended_op = fp_extended_op;
		this.fp_register = fp_register;
		this.fp_offset = fp_offset;
		this.fp_instr_offset = fp_instr_offset;
	}
	protected ByReference newByReference() { return new ByReference(); }
	protected ByValue newByValue() { return new ByValue(); }
	protected Dwarf_Frame_Op newInstance() { return new Dwarf_Frame_Op(); }
	public static Dwarf_Frame_Op[] newArray(int arrayLength) {
		return Structure.newArray(Dwarf_Frame_Op.class, arrayLength);
	}
	public static class ByReference extends Dwarf_Frame_Op implements Structure.ByReference {
		
	};
	public static class ByValue extends Dwarf_Frame_Op implements Structure.ByValue {
		
	};
}
