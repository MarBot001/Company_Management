package org.beadando.company.controller;

import org.beadando.company.model.Company;
import org.beadando.company.service.CompanyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/companies")
public class CompanyWebController {

    private final CompanyService companyService;

    public CompanyWebController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/view")
    public String listCompanies(Model model) {
        model.addAttribute("companies", companyService.findAll());
        return "companies";
    }

    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("company", new Company());
        return "new-company";
    }

    @PostMapping("/save")
    public String saveCompany(@ModelAttribute Company company) {
        companyService.add(company);
        return "redirect:/companies/view";
    }

    @PostMapping(value = "/{id}", params = "_method=delete")
    public String delete(@PathVariable Long id) {
        companyService.delete(id);
        return "redirect:/companies/view";
    }
}
