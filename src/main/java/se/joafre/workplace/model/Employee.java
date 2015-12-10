package se.joafre.workplace.model;

import javax.persistence.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by joanne on 10/12/15.
 */
@Entity
public class Employee {

    @Id
    @GeneratedValue
    private Long employeeId;

    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String employeeNumber;

    @ManyToMany
    private Collection<Department> departments;

    @Embedded
    private ParkingSpot parkingSpot;

    protected Employee (){}

    public Employee(String firstName, String lastName, String employeeNumber, ParkingSpot parkingSpot) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeNumber = employeeNumber;
        this.parkingSpot = parkingSpot;
        this.departments = new ArrayList<>();
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public Collection<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Collection<Department> departments) {
        this.departments = departments;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }
}


