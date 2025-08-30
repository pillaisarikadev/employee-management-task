/*
package com.example.employeemanagement.service;

import com.example.employeemanagement.dto.DepartmentDTO;
import com.example.employeemanagement.dto.EmployeeDTO;
import com.example.employeemanagement.model.Department;
import com.example.employeemanagement.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    
    @Autowired
    private DepartmentRepository departmentRepository;
    
    public List<DepartmentDTO> getAllDepartments() {
        return departmentRepository.findAll().stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
    }
    
    @Transactional
    public DepartmentDTO createDepartment(DepartmentDTO departmentDTO) {
        Department department = new Department();
        department.setId(departmentDTO.getId());
        department.setName(departmentDTO.getName());
        department.setLocation(departmentDTO.getLocation());
        
        Department savedDepartment = departmentRepository.save(department);
        return convertToDTO(savedDepartment);
    }
    
    private DepartmentDTO convertToDTO(Department department) {
        DepartmentDTO dto = new DepartmentDTO();
        dto.setId(department.getId());
        dto.setName(department.getName());
        dto.setLocation(department.getLocation());
        
        List<EmployeeDTO> employeeDTOs = department.getEmployees().stream()
            .map(employee -> {
                EmployeeDTO empDTO = new EmployeeDTO();
                empDTO.setId(employee.getId());
                empDTO.setName(employee.getName());
                empDTO.setEmail(employee.getEmail());
                empDTO.setPosition(employee.getPosition());
                empDTO.setSalary(employee.getSalary());
                empDTO.setDepartmentId(department.getId());
                return empDTO;
            })
            .collect(Collectors.toList());
            
        dto.setEmployees(employeeDTOs);
        return dto;
    }
}
*/
