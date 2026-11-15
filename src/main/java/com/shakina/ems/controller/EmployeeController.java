package com.shakina.ems.controller;

import com.shakina.ems.dto.EmployeeRequest;
import com.shakina.ems.entity.Employee;
import com.shakina.ems.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee create(@Valid @RequestBody EmployeeRequest request) {
        return service.create(request);
    }

    @GetMapping
    public List<Employee> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable Long id, @Valid @RequestBody EmployeeRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/search")
    public List<Employee> search(@RequestParam String keyword) {
        return service.search(keyword);
    }
}
