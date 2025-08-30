package com.example.employeemanagement.service;

import com.example.employeemanagement.dto.DepartmentDTO;
import com.example.employeemanagement.dto.EmployeeDTO;
import com.example.employeemanagement.model.Department;
import com.example.employeemanagement.model.Employee;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;


public interface EmployeeService {


        List<EmployeeDTO> getAllEmployees();
        List<DepartmentDTO> getAllDepartments();
        List<EmployeeDTO> getEmployeesInDepartment(String deptId);
        EmployeeDTO addEmployeeToDepartment(String deptId, EmployeeDTO emp);
        boolean deleteEmployeeFromDepartment(String deptId, String empId);

}