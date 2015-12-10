package se.joafre.worplace;

import se.joafre.worplace.model.Department;
import se.joafre.worplace.model.Employee;
import se.joafre.worplace.model.ParkingSpot;
import se.joafre.worplace.repository.EmployeeRepository;

import java.util.List;

/**
 * Created by joanne on 10/12/15.
 */
public class Main {

    public static void main(String[] args) {

        EmployeeRepository employeeRepo = new EmployeeRepository();
        Department department = new Department("övermänniskor");
        ParkingSpot parkingSpot = new ParkingSpot(2L,"A");
        Employee employee = new Employee("kalle", "anka", "1", department, parkingSpot);
        employeeRepo.addEmployee(employee);
        List<Employee> övermänniskor = employeeRepo.getEmployeesByDepartment(department.getId());
        for (Employee employee1 : övermänniskor) {
            System.out.println(employee1.getFirstName());

        }

    }
}
