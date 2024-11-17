package pl.marcinzygmunt.domain;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Company {
    @Builder.Default
    private final UUID id = UUID.randomUUID();
    @Setter
    private String name;
    @Setter
    private CompanyTypeEnum companyTypeEnum;
    @Builder.Default
    private final List<Person> employees = new ArrayList<>();
    @Builder.Default
    private final List<Branch> branches = new ArrayList<>();

    private void addEmployee(Person person) {
        this.employees.add(person);
    }

    private void removeEmployee(Person person) {
        this.employees.add(person);
    }

    private void addBranch(Branch branch) {
        this.branches.add(branch);
    }

    private void removeBranch(Branch branch) {
        this.branches.add(branch);
    }

}
