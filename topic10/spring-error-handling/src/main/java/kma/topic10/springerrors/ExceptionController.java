package kma.topic10.springerrors;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(IOException.class)
    public String handle(final IOException ex) {
        ex.printStackTrace();
        return "error-500";
    }

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<Integer> handle(final ArithmeticException ex) {
        return ResponseEntity.badRequest()
            .body(-1);
    }

}
