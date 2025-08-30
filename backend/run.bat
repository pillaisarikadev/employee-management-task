@echo off
javac -cp "lib/*" -d target/classes src/main/java/com/example/employeemanagement/*.java src/main/java/com/example/employeemanagement/*/*.java
java -cp "lib/*;target/classes" com.example.employeemanagement.EmployeeManagementApplication
