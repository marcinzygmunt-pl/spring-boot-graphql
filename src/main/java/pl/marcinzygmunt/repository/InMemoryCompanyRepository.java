package pl.marcinzygmunt.repository;

import org.springframework.stereotype.Repository;
import pl.marcinzygmunt.domain.Company;
import pl.marcinzygmunt.domain.CompanyTypeEnum;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
public class InMemoryCompanyRepository implements CompanyRepository{

    private final Map<UUID, Company> companyRepository = new HashMap<>();

    @Override
    public Company findById(UUID companyId) {
        return companyRepository.get(companyId);
    }

    @Override
    public List<Company> getAll() {
        return companyRepository.values().stream().toList();
    }

    @Override
    public Company save(Company company) {
        return companyRepository.put(company.getId(),company);
    }

    @Override
    public void delete(Company company) {
        companyRepository.remove(company.getId());
    }
}
