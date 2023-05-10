package co.edu.uco.teqvim.crosscutting.exception;

public final class TeqvimDomainException extends TeqvimException {

	private static final long serialVersionUID = 1402540852238478596L;

	private TeqvimDomainException(final String technicalMessage, final String userMessage, final Throwable rootCause) {
		super(technicalMessage, userMessage, rootCause, ExceptionType.DATA);
	}
	
	public static TeqvimDomainException create(final String technicalMessage, final String userMessage, final Throwable rootCause) {
		return new TeqvimDomainException(technicalMessage, userMessage, rootCause);
	}
	
	public static TeqvimDomainException create(final String userMessage) {
		return new TeqvimDomainException(userMessage, userMessage, new Exception());
	}
	
	public static TeqvimDomainException create(final String technicalMessage, final String userMessage) {
		return new TeqvimDomainException(technicalMessage, userMessage, new Exception());
	}

}
