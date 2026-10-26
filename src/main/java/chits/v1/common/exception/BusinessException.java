package chits.v1.common.exception;

import org.springframework.http.HttpStatus;

/**
 * Thrown by services for expected business failures (wrong password, inactive user, etc.).
 * The GlobalExceptionHandler turns it into an ApiResponse with the given HTTP status.
 */
public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final HttpStatus status;

	public BusinessException(String message, HttpStatus status) {
		super(message);
		this.status = status;
	}

	public HttpStatus getStatus() {
		return status;
	}
}
