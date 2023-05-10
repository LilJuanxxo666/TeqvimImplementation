package co.edu.uco.teqvim.crosscutting.exception;

public final class TeqvimDataException extends TeqvimException {

	private static final long serialVersionUID = 1402540852238478596L;

	private TeqvimDataException(final String technicalMessage, final String userMessage, final Throwable rootCause) {
		super(technicalMessage, userMessage, rootCause, ExceptionType.DATA);
	}
	
	public static TeqvimDataException create(final String technicalMessage, final String userMessage, final Throwable rootCause) {
		return new TeqvimDataException(technicalMessage, userMessage, rootCause);
	}
	
	public static TeqvimDataException create(final String userMessage) {
		return new TeqvimDataException(userMessage, userMessage, new Exception());
	}
	
	public static TeqvimDataException create(final String technicalMessage, final String userMessage) {
		return new TeqvimDataException(technicalMessage, userMessage, new Exception());
	}

}
