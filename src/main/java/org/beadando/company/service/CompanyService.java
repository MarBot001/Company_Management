package org.beadando.company.service;

import org.beadando.company.model.Company;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CompanyService {

    private final List<Company> companies = new ArrayList<>();

    public List<Company> findAll() {
        return companies;
    }

    public Company add(Company company) {
        company.setId(UUID.randomUUID().toString());
        companies.add(company);
        return company;
    }

    public Company findById(String id) {
        return companies.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public boolean delete(String id) {
        return companies.removeIf(c -> c.getId().equals(id));
    }
}
