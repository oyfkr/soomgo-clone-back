package project.soomgo.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    protected ResponseEntity<Object> getException(BaseException ex) {

        ErrorResponse errorResponse = ErrorResponse.of(ex);

        return ResponseEntity.status(ex.getStatus()).body(errorResponse);
    }
}
