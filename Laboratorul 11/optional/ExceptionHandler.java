package programareavansata.laboratorul11.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;

public class ExceptionHandler {
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public static String internalError(Exception ex, String request) {
        String message = "Error message: " + HttpStatus.INTERNAL_SERVER_ERROR.value() + new Date() + ex.getMessage() + request;
        return message;
    }
}
