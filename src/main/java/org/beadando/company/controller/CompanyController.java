package org.beadando.company.controller;

import org.beadando.company.model.Company;
import org.beadando.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public List<Company> getAll() {
        return companyService.findAll();
    }

    @PostMapping
    public Company add(@RequestBody Company company) {
        return companyService.add(company);
    }

    @GetMapping("/{id}")
    public Company getById(@PathVariable String id) {
        return companyService.findById(id);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable String id) {
        return companyService.delete(id);
    }
}
