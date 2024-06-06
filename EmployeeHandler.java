import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EmployeeHandler {
  public void handleEmployees() {
    // Employee dataset
    List<Employee> employees = Arrays.asList(
        new Employee("Richard Hendricks", 28, "CEO", 500000),
        new Employee("Jared Dunn", 25, "CTO", 80000),
        new Employee("Gilfoyle", 40, "Systems Architect", 90000),
        new Employee("Danesh", 32, "Java Team", 60000),
        new Employee("Monica", 45, "HR", 40000));

    // Function to concatenate the name and department
    Function<Employee, String> nameAndDepartmentFunction = emp -> emp.getName() + ": " + emp.getDepartment();

    // Generate a new collection with concatenated strings using streams
    List<String> nameAndDepartmentList = employees.stream()
        .map(nameAndDepartmentFunction)
        .collect(Collectors.toList());

    System.out.println("Name and Department List: " + nameAndDepartmentList);

    // Calculate the average salary of all employees using stream's built-in
    // functions
    double averageSalary = employees.stream()
        .mapToDouble(Employee::getSalary)
        .average()
        .orElse(0.0);

    System.out.println("Average Salary: " + averageSalary);

    // Filter employees by age threshold and generate a new list
    int ageThreshold = 30;
    List<Employee> filteredEmployees = employees.stream()
        .filter(emp -> emp.getAge() > ageThreshold)
        .collect(Collectors.toList());

    System.out.println("Filtered Employees: " + filteredEmployees.stream()
        .map(emp -> emp.getName() + "(" + emp.getAge() + ")")
        .collect(Collectors.joining(", ")));
  }
}
