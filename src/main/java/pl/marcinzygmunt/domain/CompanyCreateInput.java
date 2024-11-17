package pl.marcinzygmunt.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class CompanyCreateInput {
    String name;
    String type;
}
