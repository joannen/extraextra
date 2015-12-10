package se.joafre.worplace.model;

import javax.persistence.*;

/**
 * Created by joanne on 10/12/15.
 */
@Entity
public class Employee {

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String employeeNumber;
    @ManyToOne
    private Department department;
    @Embedded
    private ParkingSpot parkingSpot;

    protected Employee (){}

    public Employee(String firstName, String lastName, String employeeNumber, Department department, ParkingSpot parkingSpot) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeNumber = employeeNumber;
        this.department = department;
        this.parkingSpot = parkingSpot;
    }

    public Long getId() {
        return id;
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

    public Department getDepartment() {
        return department;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }
}
