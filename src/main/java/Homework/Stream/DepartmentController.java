package Homework.Stream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee getEmplMaxSalaryDepart(@RequestParam int department) {
        return departmentService.findEmplWithMaxSalary(department);
    }

    @GetMapping("/min-salary")
    public Employee getEmplMinSalaryDepart(@RequestParam int department) {
        return departmentService.findEmplWithMinSalary(department);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> findEmployees() {
        return departmentService.findEmplByDepart();
    }

    @GetMapping(path = "/all", params = {"department"})
    public Collection<Employee> findEmployees(@RequestParam int department) {
        return departmentService.findEmplByDepart(department);
    }
}
