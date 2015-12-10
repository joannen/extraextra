package se.joafre.worplace.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by joanne on 10/12/15.
 */
@Entity
public class Department {

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String name;
    @OneToMany(mappedBy = "department")
    private Collection<Employee> employees;

    protected Department() {}

    public Department(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Collection<Employee> getEmployees() {
        return new HashSet<>(employees);
    }
}
