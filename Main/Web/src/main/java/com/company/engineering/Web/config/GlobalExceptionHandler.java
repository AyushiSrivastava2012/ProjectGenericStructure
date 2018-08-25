package com.company.engineering.Web.config;

/**
 * author: B0096708	
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		String error = "Malformed JSON request. Please send correct json values!";
		logger.error(error+"************************************************************************");
		ex.printStackTrace();
		return buildResponseEntity(HttpStatus.BAD_REQUEST, error, ex);
	}


	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		String error = "TypeMismatchException.Please send correct type of values!";
		ex.printStackTrace();
		logger.error(error+"************************************************************************");
		return buildResponseEntity(HttpStatus.BAD_REQUEST, error, ex);
	}

	private ResponseEntity<Object> buildResponseEntity(HttpStatus status, String error, Throwable ex) {
		return new ResponseEntity<Object>(error, status);
	}


	@ExceptionHandler(MultipartException.class)
	public ResponseEntity<Object> handleError(MultipartException ex) {
		String error = "MultipartException: File size ";
		logger.error(error+"************************************************************************");
		ex.printStackTrace();
		return buildResponseEntity(HttpStatus.PAYLOAD_TOO_LARGE, "", ex);
		//return ResponseWrapper.getErrorResponse(ErrorCodes.ERROR553);
	}

//	@ExceptionHandler(SizeException.class)
//	public ResponseEntity<Object> handleErrorForWeblogic(SizeException e) {
//		String error = "internal server error";
//		logger.error(error+"************************************************************************");
//		e.printStackTrace();
//		return buildResponseEntity(new ApplicationException(HttpStatus.PAYLOAD_TOO_LARGE, ErrorCodes.ERROR553.getMessage(), e));
//	}


	// Catch Other Exception
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleControllerRootException(Throwable ex) {
		logger.error("handleControllerRootException************************************************************************"+ex.getStackTrace());
		ex.printStackTrace();
		return buildResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
	}
	
}