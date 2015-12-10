package se.joafre.workplace.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by joanne on 10/12/15.
 */
@Entity
public class Department {

    @Id
    @GeneratedValue
    private Long departmentId;

    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "departments")
    private Collection<Employee> employees;

    protected Department() {}

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public Long getDepartment_id() {
        return departmentId;
    }

    public String getName() {
        return name;
    }

    public Collection<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Collection<Employee> employees) {
        this.employees = employees;
    }
}
