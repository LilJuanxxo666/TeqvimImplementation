package co.edu.uco.teqvim.crosscutting.exception;

public final class TeqvimBusinessException extends TeqvimException {

	private static final long serialVersionUID = -7962911031316744963L;

	private TeqvimBusinessException(final String technicalMessage, final String userMessage,
			final Throwable rootCause) {
		super(technicalMessage, userMessage, rootCause, ExceptionType.BUSINESS);
	}

	public static TeqvimBusinessException create(final String technicalMessage, final String userMessage,
			final Throwable rootCause) {
		return new TeqvimBusinessException(technicalMessage, userMessage, rootCause);
	}

	public static TeqvimBusinessException create(final String userMessage) {
		return new TeqvimBusinessException(userMessage, userMessage, new Exception());
	}

	public static TeqvimBusinessException create(final String technicalMessage, final String userMessage) {
		return new TeqvimBusinessException(technicalMessage, userMessage, new Exception());
	}

}
