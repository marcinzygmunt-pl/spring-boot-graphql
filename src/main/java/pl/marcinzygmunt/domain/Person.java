package pl.marcinzygmunt.domain;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Person {
    @Builder.Default
    private final UUID id = UUID.randomUUID();
    private String firstName;
    private String lastName;
    private LocalDateTime dateOfBirth;
    private String email;
}
