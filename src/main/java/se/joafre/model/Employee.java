package se.joafre.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Employee {

    @Id
    @GeneratedValue
    private Long employee_id;

    @Column(nullable = false)
    private String firstName;

    @ManyToMany(cascade = CascadeType.ALL)
    private Collection<Department> departments = new HashSet<>();

    @Embedded
    private ParkingSpace parkingSpace;

    protected Employee() {}

    public Employee(String firstName, ParkingSpace parkingSpace) {
        this.firstName = firstName;
        this.parkingSpace = parkingSpace;
    }

    public Long getEmployee_id() {
        return employee_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public ParkingSpace getParkingSpace() {
        return parkingSpace;
    }
    public Set<Department> getDepartments() {
        return new HashSet<>(departments);
    }

    public Employee addDepartment(Department department) {
        this.departments.add(department);
        return this;
    }
}
