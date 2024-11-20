package Homework.Stream;

import java.util.Collection;

public interface EmployeeService {
    Employee addEmployee(String name, String surname, int salary, int department);

    Employee deleteEmployee(String name, String surname);

    Employee findEmployee(String name, String surname);

    Collection<Employee> getAllEmployees();
}
