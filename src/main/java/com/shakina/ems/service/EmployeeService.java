package com.shakina.ems.service;

import com.shakina.ems.dto.EmployeeRequest;
import com.shakina.ems.entity.Employee;
import com.shakina.ems.exception.ResourceNotFoundException;
import com.shakina.ems.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class EmployeeService {
    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public Employee create(EmployeeRequest request) {
        if (repository.existsByEmailIgnoreCase(request.email())) {
            throw new IllegalArgumentException("An employee with this email already exists.");
        }
        Employee employee = new Employee(
                request.firstName().trim(), request.lastName().trim(),
                request.email().trim().toLowerCase(), request.department().trim(),
                request.jobTitle().trim(), request.salary());
        return repository.save(employee);
    }

    @Transactional(readOnly = true)
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Employee findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with ID: " + id));
    }

    public Employee update(Long id, EmployeeRequest request) {
        Employee employee = findById(id);
        if (!employee.getEmail().equalsIgnoreCase(request.email())
                && repository.existsByEmailIgnoreCase(request.email())) {
            throw new IllegalArgumentException("An employee with this email already exists.");
        }
        employee.setFirstName(request.firstName().trim());
        employee.setLastName(request.lastName().trim());
        employee.setEmail(request.email().trim().toLowerCase());
        employee.setDepartment(request.department().trim());
        employee.setJobTitle(request.jobTitle().trim());
        employee.setSalary(request.salary());
        return repository.save(employee);
    }

    public void delete(Long id) {
        repository.delete(findById(id));
    }

    @Transactional(readOnly = true)
    public List<Employee> search(String keyword) {
        return repository.search(keyword == null ? "" : keyword.trim());
    }
}
