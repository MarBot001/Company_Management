package org.beadando.company.controller;

import org.beadando.company.model.Employee;
import org.beadando.company.service.CompanyService;
import org.beadando.company.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmployeeWebController {

    private final EmployeeService employeeService;
    private final CompanyService companyService;

    @Autowired
    public EmployeeWebController(EmployeeService employeeService, CompanyService companyService) {
        this.employeeService = employeeService;
        this.companyService = companyService;
    }

    @GetMapping("/view")
    public String listEmployees(Model model) {
        model.addAttribute("employees", employeeService.findAll());
        return "employees";
    }

    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("companies", companyService.findAll());
        return "new-employee";
    }

    @PostMapping
    public String saveEmployee(@ModelAttribute Employee employee) {
        employeeService.add(employee);
        return "redirect:/employees/view";
    }

    @PostMapping(value = "/{id}", params = "_method=delete")
    public String delete(@PathVariable Long id) {
        employeeService.delete(id);
        return "redirect:/employees/view";
    }
}
