package se.joafre.workplace;

import se.joafre.workplace.model.Department;
import se.joafre.workplace.model.Employee;
import se.joafre.workplace.model.ParkingSpot;
import se.joafre.workplace.repository.EmployeeRepository;

import java.util.List;

/**
 * Created by joanne on 10/12/15.
 */
public class Main {

    public static void main(String[] args) {

        EmployeeRepository employeeRepo = new EmployeeRepository();

        Department superpeople = new Department("superpeople");
        Department wonderpeople = new Department("wonderpeople");

        employeeRepo.addDepartment(wonderpeople);
        employeeRepo.addDepartment(superpeople);

        ParkingSpot parkingSpot = new ParkingSpot(1L, "2A");
        Employee e = new Employee("one", "two", "three", parkingSpot);

        employeeRepo.addEmployee(e);

        e.getDepartments().add(superpeople);
        e.getDepartments().add(wonderpeople);

        employeeRepo.mergeEmployee(e);

        for (Department department : employeeRepo.getEmployeeById(1L).getDepartments()) {
            System.out.println(department.getName());
        }


    }
}
