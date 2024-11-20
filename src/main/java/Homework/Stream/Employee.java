package Homework.Stream;

public class Employee {
    private String name;
    private String surname;
    private int department; //отдел 1-5
    private int salary;

    public Employee(String name, String surname, int department, int salary) {
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.salary = salary;
    }

    public String getName() { //геттеры
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object other) {
        if (this.getClass() != other.getClass()) {
            return false;
        }
        Employee a2 = (Employee) other;
        return name.equals(a2.name) && surname.equals(a2.surname) && department == a2.department && salary == a2.salary;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(name, surname, department, salary);
    }

    @Override
    public String toString() {
        return surname + " " + name + " " + ", отдел: " + department + ", зарплата: " + salary;
    }
}
