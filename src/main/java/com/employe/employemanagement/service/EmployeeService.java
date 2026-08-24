package com.employe.employemanagement.service;

import com.employe.employemanagement.entity.Employe;
import com.employe.employemanagement.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employe addEmployee(Employe employee) {
        return employeeRepository.save(employee);
    }

    public List<Employe> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employe> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employe updateEmployee(Long id, Employe employee) {

        Employe existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        existingEmployee.setName(employee.getName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setDepartment(employee.getDepartment());
        existingEmployee.setSalary(employee.getSalary());

        return employeeRepository.save(existingEmployee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}