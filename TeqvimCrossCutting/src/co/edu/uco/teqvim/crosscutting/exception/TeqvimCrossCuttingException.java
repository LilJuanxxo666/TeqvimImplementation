package co.edu.uco.teqvim.crosscutting.exception;

public final class TeqvimCrossCuttingException extends TeqvimException {

	private static final long serialVersionUID = 5822160111761925476L;

	private TeqvimCrossCuttingException(final String technicalMessage, final String userMessage,
			final Throwable rootCause) {
		super(technicalMessage, userMessage, rootCause, ExceptionType.CROSSCUTTING);
	}

	public static TeqvimCrossCuttingException create(final String technicalMessage, final String userMessage,
			final Throwable rootCause) {
		return new TeqvimCrossCuttingException(technicalMessage, userMessage, rootCause);
	}

	public static TeqvimCrossCuttingException create(final String userMessage) {
		return new TeqvimCrossCuttingException(userMessage, userMessage, new Exception());
	}

	public static TeqvimCrossCuttingException create(final String technicalMessage, final String userMessage) {
		return new TeqvimCrossCuttingException(technicalMessage, userMessage, new Exception());
	}

}
