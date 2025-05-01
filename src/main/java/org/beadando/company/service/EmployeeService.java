package org.beadando.company.service;

import org.beadando.company.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    private final List<Employee> employees = new ArrayList<>();

    public List<Employee> findAll() {
        return employees;
    }

    public List<Employee> findByCompanyId(String companyId) {
        return employees.stream()
                .filter(e -> e.getCompanyId().equals(companyId))
                .toList();
    }

    public Employee add(Employee employee) {
        employee.setId(UUID.randomUUID().toString());
        employees.add(employee);
        return employee;
    }

    public Employee findById(String id) {
        return employees.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public boolean delete(String id) {
        return employees.removeIf(e -> e.getId().equals(id));
    }
}
