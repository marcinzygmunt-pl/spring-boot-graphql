package pl.marcinzygmunt.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import pl.marcinzygmunt.domain.Company;
import pl.marcinzygmunt.domain.CompanyCreateInput;
import pl.marcinzygmunt.domain.CompanyTypeEnum;
import pl.marcinzygmunt.domain.CompanyUpdateInput;
import pl.marcinzygmunt.repository.CompanyRepository;

import java.util.List;
import java.util.UUID;

@Slf4j
@Controller
@RequiredArgsConstructor
public class QueryResolver {


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

    @MutationMapping
    public UUID create(@Argument CompanyCreateInput item) {
        log.info("Company Create");
        return companyRepository.save(createCompanyFromInput(item)).getId();
    }

    @MutationMapping
    public UUID update(@Argument CompanyUpdateInput item) {
        log.info("Company Update");
        return updateCompanyFromInput(item);
    }

    @MutationMapping
    public boolean delete(@Argument UUID companyId) {
        log.info("Company Delete");
        deleteCompany(companyId);
        return true;
    }

    private Company createCompanyFromInput(CompanyCreateInput input) {
        return Company.builder()
                .name(input.getName())
                .companyTypeEnum(CompanyTypeEnum.valueOf(input.getType()))
                .build();
    }

    private UUID updateCompanyFromInput(CompanyUpdateInput input) {
        var company = companyRepository.findById(input.getId()).orElseThrow(RuntimeException::new);
        company.setName(input.getName());
        company.setCompanyTypeEnum(CompanyTypeEnum.valueOf(input.getType()));
        return companyRepository.save(company).getId();
    }

    private void deleteCompany(UUID companyId) {
        companyRepository.delete(companyId);

    }


}