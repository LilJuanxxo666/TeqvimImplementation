package co.edu.uco.teqvim.crosscutting.utils;

public class UtilNumber {

	private static final UtilNumber INSTANCE = new UtilNumber();
	public static final int ZERO_INT = 0;
	public static final double ZERO_DOUBLE = 0;

	private UtilNumber() {
		super();
	}

	public static final UtilNumber getUtilNumber() {
		return INSTANCE;
	}
}
