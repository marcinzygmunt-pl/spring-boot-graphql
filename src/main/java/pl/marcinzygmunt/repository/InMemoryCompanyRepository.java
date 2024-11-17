package pl.marcinzygmunt.repository;

import org.springframework.stereotype.Repository;
import pl.marcinzygmunt.domain.Company;
import pl.marcinzygmunt.domain.CompanyTypeEnum;

import java.util.*;

@Repository
public class InMemoryCompanyRepository implements CompanyRepository{

    private final Map<UUID, Company> companyRepository = new HashMap<>();

    @Override
    public Optional<Company> findById(UUID companyId) {
        return Optional.of(companyRepository.get(companyId));
    }

    @Override
    public List<Company> getAll() {
        return companyRepository.values().stream().toList();
    }

    @Override
    public Company save(Company company) {
        companyRepository.put(company.getId(),company);
        return company;
    }

    @Override
    public void delete(UUID companyId) {
        companyRepository.remove(companyId);
    }
}
