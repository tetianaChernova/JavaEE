package kma.topic8.springrestsample;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kma.topic8.springrestsample.dto.LoginDto;
import kma.topic8.springrestsample.dto.LoginResponseDto;

@RestController
public class MyRestController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<LoginResponseDto> login(
        @RequestBody final LoginDto loginDto
    ) {
        System.out.println("Accept login request");
        System.out.println(loginDto);

        return ResponseEntity.ok(LoginResponseDto.of(loginDto.getLogin(), "success"));
    }

}
