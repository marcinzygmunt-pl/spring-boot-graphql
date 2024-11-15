package pl.marcinzygmunt.application;

import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import pl.marcinzygmunt.domain.Company;
import pl.marcinzygmunt.repository.CompanyRepository;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CompanyController {


    private final CompanyRepository companyRepository;

    @QueryMapping
    public List<Company> companyList() {
        return companyRepository.getAll();
    }

    @QueryMapping
    public Company company(@Argument String name) {
        return companyRepository
                .getAll()
                .stream()
                .filter(c -> c.getName().contains(name))
                .findFirst()
                .orElseThrow();
    }

    @QueryMapping
    public int companyCount() {
        return companyRepository.getAll().size();
    }
}