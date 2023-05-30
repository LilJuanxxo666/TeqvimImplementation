package co.edu.uco.teqvim.crosscutting.utils;

public class UtilNumber{
	
	private static final UtilNumber INSTANCE = new UtilNumber();
	public static final Number ZERO = 0;
	
	private UtilNumber(){
		super();
	}
	public static final UtilNumber getUtilNumber() {
		return INSTANCE;
	}
	
	public final boolean isNull(final Number numero) {
		return UtilObject.isNull(numero);
	}
	
	public final Number getDefault(final Number number, final Number defaultValue) {	
		Number result = number;
		
		if(isNull(number)) {
			result = isNull(defaultValue) ? ZERO : defaultValue;
		}
		return result;
	}
	
	public final Number getDefault(final Number number) {
		return getDefault(number, ZERO);
	}
}
