package kma.topic8.springrestsample;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kma.topic8.springrestsample.dto.User;

@Controller
public class MyController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
