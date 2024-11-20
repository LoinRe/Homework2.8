package Homework.Stream;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employees;

    public EmployeeServiceImpl() {
        employees = new HashMap<>();
        employees.put(getKey("Ivan", "Svetlov"), new Employee("Ivan", "Svetlov", 1, 500));
        employees.put(getKey("Oleg", "Akimov"), new Employee("Oleg", "Akimov", 1, 1100));
        employees.put(getKey("Igor", "Ivanov"), new Employee("Igor", "Ivanov", 2, 1000));
        employees.put(getKey("Olga", "Akimova"), new Employee("Olga", "Akimova", 3, 1200));
    }

    //ключ для мапы
    private String getKey(String name, String surname) {
        return (name + ":" + surname).toLowerCase();
    }

    @Override
    public Employee addEmployee(String name, String surname, int salary, int department) {
        Employee newEmployee = new Employee(name, surname, salary, department);  //создаем сотрудника
        if (employees.containsKey(getKey(name, surname))) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(getKey(name, surname), newEmployee);
        return newEmployee;
    }

    @Override
    public Employee deleteEmployee(String name, String surname) {
        if (!employees.containsKey(getKey(name, surname))) {
            throw new EmployeeNotFoundException();
        }
        return employees.remove(getKey(name, surname));
    }


    @Override
    public Employee findEmployee(String name, String surname) {
        if (!employees.containsKey(getKey(name, surname))) {
            throw new EmployeeNotFoundException();
        }
        return employees.get(getKey(name, surname));
    }

    @Override
    public Collection<Employee> getAllEmployees() {
        return Collections.unmodifiableCollection(employees.values()); // Возвращаем список всех сотрудников
    }
}
