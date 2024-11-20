package Homework.Stream;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee findEmplWithMinSalary(int department) {
        Optional<Employee> min = employeeService
                .getAllEmployees()
                .stream()
                .filter(e -> e.getDepartment() == department)
                .min(comparingInt(employee -> employee.getSalary()));

        return employeeService
                .getAllEmployees()
                .stream()
                .filter(e -> e.getDepartment() == department)
                .min(comparingInt(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException());
    }

    @Override
    public Employee findEmplWithMaxSalary(int department) {
        Optional<Employee> max = employeeService
                .getAllEmployees()
                .stream()
                .filter(e -> e.getDepartment() == department)
                .max(comparingInt(Employee::getSalary));

        return employeeService
                .getAllEmployees()
                .stream()
                .filter(e -> e.getDepartment() == department)
                .max(comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Map<Integer, List<Employee>> findEmplByDepart() {
        return employeeService
                .getAllEmployees()
                .stream()
                .sorted(comparing(Employee::getSurname).thenComparing(Employee::getName))
                .collect(groupingBy(Employee::getDepartment)); //получаем коллекцию
    }

    @Override
    public Collection<Employee> findEmplByDepart(int department) {
        return employeeService
                .getAllEmployees()
                .stream()
                .filter(e -> e.getDepartment() == department)
                .collect(toList());
    }
}
