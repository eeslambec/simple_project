package uz.tiue.project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class JwtDto {
    private String accessToken;
    private final LocalDateTime timestamp = LocalDateTime.now();
}
