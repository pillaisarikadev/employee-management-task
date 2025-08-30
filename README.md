REST APIs

GET /employees – Get all employees across all departments.

GET /departments – Get all departments.

GET /departments/{deptId}/employees – Get all employees in a specific department.

POST /departments/{deptId}/employees – Add a new employee to a department.

DELETE /departments/{deptId}/employees/{empId} – Delete an employee from a department.

Database

Supports any database (e.g., MySQL, PostgreSQL, H2).

In-memory database (H2) can be used for simplicity.

Demonstrates DAO/Repository pattern.

Jasper Reports

Generates a PDF report showing employees in each department.

Each department is displayed on a separate page.

Architecture

Controller – Handles REST API endpoints.

Service – Contains business logic.

DTOs – Used for transferring data between layers.

Repository/DAO – Handles database operations.

Transaction Management – Ensures consistency in database operations.

Data Structures

Uses Map and List for in-memory data representation (if DB not used).

Sample JSON structure for departments and employees:
{
  "departments": [
    {
      "id": "dept01",
      "name": "Human Resources",
      "location": "Building A",
      "employees": [
        { "id": "emp001", "name": "Alice Smith", "email": "alice.smith@example.com", "position": "Recruiter", "salary": 60000 },
        { "id": "emp003", "name": "Charlie Brown", "email": "charlie.brown@example.com", "position": "HR Assistant", "salary": 40000 }
      ]
    },
    {
      "id": "dept02",
      "name": "Engineering",
      "location": "Building B",
      "employees": [
        { "id": "emp002", "name": "Bob Johnson", "email": "bob.johnson@example.com", "position": "Software Engineer", "salary": 80000 },
        { "id": "emp004", "name": "Diana Prince", "email": "diana.prince@example.com", "position": "System Architect", "salary": 90000 }
      ]
    }
  ]
}
