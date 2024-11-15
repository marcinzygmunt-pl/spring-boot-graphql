package pl.marcinzygmunt.domain;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Branch {
    @Builder.Default
    private final UUID id = UUID.randomUUID();
    private String street;
    private String postCode;
    private String city;
}
