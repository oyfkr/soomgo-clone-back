package project.soomgo.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ErrorResponse {

    private BaseApiError baseApiError;

    public ErrorResponse(BaseApiError error) {
        this.baseApiError = error;
    }

    public static ErrorResponse of(BaseException baseException) {
        return new ErrorResponse(BaseApiError.of(baseException.getCode(), baseException.getMessage()));
    }

    @Getter
    public static class BaseApiError{

        protected String code;
        protected String message;

        public BaseApiError(String code, String message) {
            this.code = code;
            this.message = message;
        }

        public static BaseApiError of(String code, String message) {
            return new BaseApiError(code, message);
        }
    }
}
