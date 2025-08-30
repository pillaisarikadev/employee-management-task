package com.example.employeemanagement.controllers;


import com.example.employeemanagement.dto.DepartmentDTO;
import com.example.employeemanagement.dto.EmployeeDTO;
import com.example.employeemanagement.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeDepartmentController {

    private final EmployeeService service;

    public EmployeeDepartmentController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/employees")
    public List<EmployeeDTO> getAllEmployees() {
        return service.getAllEmployees();
    }

    @GetMapping("/departments")
    public List<DepartmentDTO> getAllDepartments() {
        return service.getAllDepartments();
    }

    @GetMapping("/departments/{deptId}/employees")
    public List<EmployeeDTO> getEmployeesInDepartment(@PathVariable String deptId) {
        return service.getEmployeesInDepartment(deptId);
    }

    @PostMapping("/departments/{deptId}/employees")
    public EmployeeDTO addEmployee(@PathVariable String deptId, @RequestBody EmployeeDTO emp) {
        return service.addEmployeeToDepartment(deptId, emp);
    }

    @DeleteMapping("/departments/{deptId}/employees/{empId}")
    public String deleteEmployee(@PathVariable String deptId, @PathVariable String empId) {
        boolean removed = service.deleteEmployeeFromDepartment(deptId, empId);
        return removed ? "Employee deleted successfully." : "Employee not found.";
    }
}