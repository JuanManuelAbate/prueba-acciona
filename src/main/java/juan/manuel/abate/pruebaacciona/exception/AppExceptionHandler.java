package juan.manuel.abate.pruebaacciona.exception;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler {

	@ExceptionHandler(value = { NoSuchElementException.class })
	public ResponseEntity<ApiError> handleInvalidInputException(NoSuchElementException ex) {
		return new ResponseEntity<ApiError>(ApiError.builder().error(ex.getMessage()).build(), HttpStatus.NOT_FOUND);
	}
}