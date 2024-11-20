package Homework.Stream;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee findEmplWithMinSalary(int department);

    Employee findEmplWithMaxSalary(int department);

    Map<Integer, List<Employee>> findEmplByDepart();

    Collection<Employee> findEmplByDepart(int department);
}
