package com.example.employeemanagement.dto;

public class EmployeeDTO {
    private String id;
    private String name;
    private String email;
    private String position;
    private double salary;
    public EmployeeDTO() {}
    public EmployeeDTO(String id, String name, String email, String position, double salary) {
        this.id = id; this.name = name; this.email = email; this.position = position; this.salary = salary;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    } public String getEmail() {
        return email;
    } public void setEmail(String email) { this.email = email; }
    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }
    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }
}
