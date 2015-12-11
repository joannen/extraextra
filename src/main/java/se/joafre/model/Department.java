package se.joafre.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

@Entity
public class Department {

    @Id
    @GeneratedValue
    private Long department_id;

    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "departments")
    private Collection<Employee> employees;

    protected Department() {}

    public Department(String name) {
        this.name = name;
    }

    public Long getDepartment_id() {
        return department_id;
    }

    public String getName() {
        return name;
    }

    public Collection<Employee> getEmployees() {
        return new HashSet<>(employees);
    }
}
