package kma.topic8.springrestsample.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor(staticName = "of")
public class LoginResponseDto {

    private final String login;
    private final String message;

}
