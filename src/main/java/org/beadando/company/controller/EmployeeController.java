package org.beadando.company.controller;

import org.beadando.company.model.Employee;
import org.beadando.company.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAll() {
        return employeeService.findAll();
    }

    @PostMapping
    public Employee add(@RequestBody Employee employee) {
        return employeeService.add(employee);
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable String id) {
        return employeeService.findById(id);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable String id) {
        return employeeService.delete(id);
    }

    @GetMapping("/company/{companyId}")
    public List<Employee> getByCompany(@PathVariable String companyId) {
        return employeeService.findByCompanyId(companyId);
    }
}
