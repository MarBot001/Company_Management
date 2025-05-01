package org.beadando.company.controller;

import org.beadando.company.model.Company;
import org.beadando.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    @ResponseBody // csak ez maradhat REST-es
    public List<Company> getAll() {
        return companyService.findAll();
    }

    // 👇 HTML nézet visszaadása
    @GetMapping("/view")
    public String showCompanies(Model model) {
        model.addAttribute("companies", companyService.findAll());
        return "companies";
    }

    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("company", new Company());
        return "new-company";
    }

    @PostMapping
    public String saveCompany(@ModelAttribute Company company) {
        companyService.add(company);
        return "redirect:/companies/view";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Company getById(@PathVariable String id) {
        return companyService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public boolean delete(@PathVariable String id) {
        return companyService.delete(id);
    }
}
