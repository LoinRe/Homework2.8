package Homework.Stream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String showGreetings() {
        return "Добро пожаловать в список сотрудников";
    }

    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam("name") String name, @RequestParam("surname") String surname, @RequestParam("salary") int salary, @RequestParam("department") int department) {
        return employeeService.addEmployee(name, surname, salary, department);
    }

    @GetMapping("/delete")
    public Employee deleteEmployee(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        return employeeService.deleteEmployee(name, surname);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        return employeeService.findEmployee(name, surname);
    }

    @GetMapping("/all")
    public Collection<Employee> getAllEmployees() {
        return employeeService.getAllEmployees(); // Возвращаем список всех сотрудников
    }
}
