package pl.marcinzygmunt.repository;

import org.springframework.stereotype.Repository;
import pl.marcinzygmunt.domain.Company;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CompanyRepository {
    Optional<Company> findById(UUID companyId);

    List<Company> getAll();

    Company save(Company company);

    void delete(UUID companyId);

}
