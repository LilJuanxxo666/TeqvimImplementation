package co.edu.uco.teqvim.crosscutting.exception;

public final class TeqvimDtoException extends TeqvimException {

	private static final long serialVersionUID = 7109898558320548677L;

	private TeqvimDtoException(final String technicalMessage, final String userMessage, final Throwable rootCause) {
		super(technicalMessage, userMessage, rootCause, ExceptionType.DTO);
	}

	public static TeqvimDtoException create(final String technicalMessage, final String userMessage,
			final Throwable rootCause) {
		return new TeqvimDtoException(technicalMessage, userMessage, rootCause);
	}

	public static TeqvimDtoException create(final String userMessage) {
		return new TeqvimDtoException(userMessage, userMessage, new Exception());
	}

	public static TeqvimDtoException create(final String technicalMessage, final String userMessage) {
		return new TeqvimDtoException(technicalMessage, userMessage, new Exception());
	}

}
