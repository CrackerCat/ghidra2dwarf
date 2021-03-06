package libdwarf;
import com.ochafik.lang.jnaerator.runtime.Structure;
import java.util.Arrays;
import java.util.List;
/**
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class Dwarf_Ranges extends Structure<Dwarf_Ranges, Dwarf_Ranges.ByValue, Dwarf_Ranges.ByReference > {
	/** C type : Dwarf_Addr */
	public long dwr_addr1;
	/** C type : Dwarf_Addr */
	public long dwr_addr2;
	/**
	 * @see Dwarf_Ranges_Entry_Type<br>
	 * C type : Dwarf_Ranges_Entry_Type
	 */
	public int dwr_type;
	public Dwarf_Ranges() {
		super();
	}
	protected List<? > getFieldOrder() {
		return Arrays.asList("dwr_addr1", "dwr_addr2", "dwr_type");
	}
	/**
	 * @param dwr_addr1 C type : Dwarf_Addr<br>
	 * @param dwr_addr2 C type : Dwarf_Addr<br>
	 * @param dwr_type @see Dwarf_Ranges_Entry_Type<br>
	 * C type : Dwarf_Ranges_Entry_Type
	 */
	public Dwarf_Ranges(long dwr_addr1, long dwr_addr2, int dwr_type) {
		super();
		this.dwr_addr1 = dwr_addr1;
		this.dwr_addr2 = dwr_addr2;
		this.dwr_type = dwr_type;
	}
	protected ByReference newByReference() { return new ByReference(); }
	protected ByValue newByValue() { return new ByValue(); }
	protected Dwarf_Ranges newInstance() { return new Dwarf_Ranges(); }
	public static Dwarf_Ranges[] newArray(int arrayLength) {
		return Structure.newArray(Dwarf_Ranges.class, arrayLength);
	}
	public static class ByReference extends Dwarf_Ranges implements Structure.ByReference {
		
	};
	public static class ByValue extends Dwarf_Ranges implements Structure.ByValue {
		
	};
}
