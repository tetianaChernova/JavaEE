package kma.topic8.springrestsample;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kma.topic8.springrestsample.dto.UserDto;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MyRestController {

    private final Validator validator;

    @RequestMapping(value = "/user-handler", method = RequestMethod.POST)
    public ResponseEntity<UserDto> userHandler(
        @Valid @RequestBody final UserDto userDto
    ) {
        System.out.println("Accept userDto request");
        System.out.println(userDto);

        return ResponseEntity.ok(userDto);
    }

    @RequestMapping(value = "/user-handler-custom", method = RequestMethod.POST)
    public ResponseEntity<?> customExceptionHandler(
        @RequestBody final UserDto userDto
    ) {
        System.out.println("Accept userDto request with custom validation handling");
        System.out.println(userDto);

        final Set<ConstraintViolation<UserDto>> validationResult = validator.validate(userDto);
        final List<String> errors = validationResult.stream()
            .map(errorField -> "Field [" + errorField.getPropertyPath() + "] is invalid. Validation error: " + errorField.getMessage())
            .collect(Collectors.toList());

        if (!errors.isEmpty()) {
            System.out.println();
            return ResponseEntity.badRequest()
                .body(errors);
        }

        return ResponseEntity.ok(userDto);
    }

}
