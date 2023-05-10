package co.edu.uco.teqvim.crosscutting.exception;

public final class TeqvimEntityException extends TeqvimException {

	private static final long serialVersionUID = 3712060771093674034L;

	private TeqvimEntityException(final String technicalMessage, final String userMessage, final Throwable rootCause) {
		super(technicalMessage, userMessage, rootCause, ExceptionType.ENTITY);
	}

	public static TeqvimEntityException create(final String technicalMessage, final String userMessage,
			final Throwable rootCause) {
		return new TeqvimEntityException(technicalMessage, userMessage, rootCause);
	}

	public static TeqvimEntityException create(final String userMessage) {
		return new TeqvimEntityException(userMessage, userMessage, new Exception());
	}

	public static TeqvimEntityException create(final String technicalMessage, final String userMessage) {
		return new TeqvimEntityException(technicalMessage, userMessage, new Exception());
	}

}
