package co.edu.uco.teqvim.crosscutting.exception;

import co.edu.uco.teqvim.crosscutting.utils.UtilObject;
import co.edu.uco.teqvim.crosscutting.utils.UtilText;

public class TeqvimException extends RuntimeException {

	private static final long serialVersionUID = 6575335625711312099L;

	private ExceptionType type;
	private String userMessage;

	protected TeqvimException(String technicalMessage, String userMessage, Throwable rootCause, ExceptionType type) {
		super(technicalMessage, rootCause);
		setUserMessage(userMessage);
		setType(type);
	}

	private final String getTechnicalMessage() {
		return UtilText.getUtilText().getDefaultIfEmpty(getMessage(), getUserMessage());
	}

	public final Throwable getRootCause() {
		return UtilObject.getDefault(getCause(), new Exception());
	}

	public final ExceptionType getType() {
		return type;
	}

	private final void setType(final ExceptionType type) {
		this.type = UtilObject.getDefault(type, ExceptionType.GENERAL);
	}

	public final String getUserMessage() {
		return userMessage;
	}

	public final void setUserMessage(final String userMessage) {
		this.userMessage = UtilText.getUtilText().getDefault(userMessage);
	}

	public static final long getSerialversionuid() {
		return serialVersionUID;
	}

}
