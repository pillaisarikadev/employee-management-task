
package com.example.employeemanagement.service.impl;

import com.example.employeemanagement.dto.DepartmentDTO;
import com.example.employeemanagement.dto.EmployeeDTO;
import com.example.employeemanagement.model.Department;
import com.example.employeemanagement.model.Employee;
import com.example.employeemanagement.repository.DepartmentRepository;
import com.example.employeemanagement.repository.EmployeeRepository;
import com.example.employeemanagement.service.EmployeeService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final DepartmentRepository deptRepo;
    private final EmployeeRepository empRepo;

    public EmployeeServiceImpl(DepartmentRepository deptRepo, EmployeeRepository empRepo) {
        this.deptRepo = deptRepo;
        this.empRepo = empRepo;
    }

    // a. Get all employees
    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return empRepo.findAll().stream()
                .map(e -> new EmployeeDTO(e.getId(), e.getName(), e.getEmail(), e.getPosition(), e.getSalary()))
                .collect(Collectors.toList());
    }

    // b. Get all departments
    @Override
    public List<DepartmentDTO> getAllDepartments() {
        return deptRepo.findAll().stream()
                .map(d -> new DepartmentDTO(
                        d.getId(), d.getName(), d.getLocation(),
                        d.getEmployees().stream()
                                .map(e -> new EmployeeDTO(e.getId(), e.getName(), e.getEmail(), e.getPosition(), e.getSalary()))
                                .collect(Collectors.toList())
                ))
                .collect(Collectors.toList());
    }

    // c. Get employees in a department
    @Override
    public List<EmployeeDTO> getEmployeesInDepartment(String deptId) {
        return empRepo.findByDepartmentId(deptId).stream()
                .map(e -> new EmployeeDTO(e.getId(), e.getName(), e.getEmail(), e.getPosition(), e.getSalary()))
                .collect(Collectors.toList());
    }

    // d. Add new employee in a department
    @Transactional
    @Override
    public EmployeeDTO addEmployeeToDepartment(String deptId, EmployeeDTO empDto) {
        Department dept = deptRepo.findById(deptId).orElseThrow(() -> new RuntimeException("Department not found"));
        Employee emp = new Employee(empDto.getId(), empDto.getName(), empDto.getEmail(), empDto.getPosition(), empDto.getSalary());
        emp.setDepartment(dept);
        Employee saved = empRepo.save(emp);
        return new EmployeeDTO(saved.getId(), saved.getName(), saved.getEmail(), saved.getPosition(), saved.getSalary());
    }

    // e. Delete employee in a department
    //@Transactional
    @Override
    public boolean deleteEmployeeFromDepartment(String deptId, String empId) {
        Optional<Employee> empOpt = empRepo.findById(empId);
        if (empOpt.isPresent() && empOpt.get().getDepartment().getId().equals(deptId)) {
            empRepo.delete(empOpt.get());
            return true;
        }
        return false;
    }
}