package kma.topic10.springerrors;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/page-with-error")
    public String pageWithError() throws IOException {
        throw new IOException();
    }

    @RequestMapping("/error-500")
    public String errorPage() {
        return "error-500";
    }

    @RequestMapping("/divide")
    public ResponseEntity<Integer> divide(
        @RequestParam("a") int a,
        @RequestParam("b") int b
    ) {
        return ResponseEntity.ok(a / b);
    }
}
