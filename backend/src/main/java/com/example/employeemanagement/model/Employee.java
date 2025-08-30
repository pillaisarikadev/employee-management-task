
package com.example.employeemanagement.model;

import jakarta.persistence.*;

@Entity
//@Table(name= "EmployeeData")
public class Employee {

    @Id
    private String id;
    private String name;
    private String email;
    private String position;
    private double salary;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public Employee() {}
    public Employee(String id, String name, String email, String position, double salary) {
        this.id = id; this.name = name; this.email = email; this.position = position; this.salary = salary;
    }

    // Getters/Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }
}