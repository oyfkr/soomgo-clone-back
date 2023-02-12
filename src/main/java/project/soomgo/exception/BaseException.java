package project.soomgo.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@Getter
public class BaseException extends RuntimeException{

    private HttpStatus status;
    private String code;

    public BaseException(HttpStatus httpStatus, String code, String message) {
        super(message);
        this.status = httpStatus;
        this.code = code;
    }

    public static BaseException of(ErrorCode errorCode) {
        return new BaseException(errorCode.getHttpStatus(), errorCode.toString(), errorCode.getMessage());
    }
}
