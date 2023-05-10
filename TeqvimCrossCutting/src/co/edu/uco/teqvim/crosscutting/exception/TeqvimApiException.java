package co.edu.uco.teqvim.crosscutting.exception;

public final class TeqvimApiException extends TeqvimException {

	private static final long serialVersionUID = -8879552184059418572L;

	private TeqvimApiException(final String technicalMessage, final String userMessage, final Throwable rootCause) {
		super(technicalMessage, userMessage, rootCause, ExceptionType.API);
	}

	public static TeqvimApiException create(final String technicalMessage, final String userMessage,
			final Throwable rootCause) {
		return new TeqvimApiException(technicalMessage, userMessage, rootCause);
	}

	public static TeqvimApiException create(final String userMessage) {
		return new TeqvimApiException(userMessage, userMessage, new Exception());
	}

	public static TeqvimApiException create(final String technicalMessage, final String userMessage) {
		return new TeqvimApiException(technicalMessage, userMessage, new Exception());
	}

}
