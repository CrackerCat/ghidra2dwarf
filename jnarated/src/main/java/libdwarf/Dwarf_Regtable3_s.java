package libdwarf;
import com.ochafik.lang.jnaerator.runtime.Structure;
import java.util.Arrays;
import java.util.List;
/**
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class Dwarf_Regtable3_s extends Structure<Dwarf_Regtable3_s, Dwarf_Regtable3_s.ByValue, Dwarf_Regtable3_s.ByReference > {
	/** C type : Dwarf_Regtable_Entry3_s */
	public Dwarf_Regtable_Entry3_s rt3_cfa_rule;
	/** C type : Dwarf_Half */
	public short rt3_reg_table_size;
	/** C type : Dwarf_Regtable_Entry3_s* */
	public Dwarf_Regtable_Entry3_s.ByReference rt3_rules;
	public Dwarf_Regtable3_s() {
		super();
	}
	protected List<? > getFieldOrder() {
		return Arrays.asList("rt3_cfa_rule", "rt3_reg_table_size", "rt3_rules");
	}
	/**
	 * @param rt3_cfa_rule C type : Dwarf_Regtable_Entry3_s<br>
	 * @param rt3_reg_table_size C type : Dwarf_Half<br>
	 * @param rt3_rules C type : Dwarf_Regtable_Entry3_s*
	 */
	public Dwarf_Regtable3_s(Dwarf_Regtable_Entry3_s rt3_cfa_rule, short rt3_reg_table_size, Dwarf_Regtable_Entry3_s.ByReference rt3_rules) {
		super();
		this.rt3_cfa_rule = rt3_cfa_rule;
		this.rt3_reg_table_size = rt3_reg_table_size;
		this.rt3_rules = rt3_rules;
	}
	protected ByReference newByReference() { return new ByReference(); }
	protected ByValue newByValue() { return new ByValue(); }
	protected Dwarf_Regtable3_s newInstance() { return new Dwarf_Regtable3_s(); }
	public static Dwarf_Regtable3_s[] newArray(int arrayLength) {
		return Structure.newArray(Dwarf_Regtable3_s.class, arrayLength);
	}
	public static class ByReference extends Dwarf_Regtable3_s implements Structure.ByReference {
		
	};
	public static class ByValue extends Dwarf_Regtable3_s implements Structure.ByValue {
		
	};
}
