package se.joafre.workplace.repository;

import se.joafre.workplace.model.Department;
import se.joafre.workplace.model.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by joanne on 10/12/15.
 */
public class EmployeeRepository {

    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersistenceUnit");

    private EntityManager manager;

    public void addEmployee(Employee employee){
        manager = factory.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(employee);
        manager.getTransaction().commit();
        manager.close();
    }

    public Employee getEmployeeById(Long id){
        manager = factory.createEntityManager();
        manager.getTransaction().begin();
        Employee employee = manager.find(Employee.class, id);
        manager.getTransaction().commit();
        manager.close();
        return employee;
    }

    public List<Employee> getEmployeesByDepartment(Long department){
        manager = factory.createEntityManager();
        manager.getTransaction().begin();
        Department department1 =manager.find(Department.class, department);
        List<Employee> employees = new ArrayList<>(department1.getEmployees());
        manager.getTransaction().commit();
        manager.close();
        return employees;
    }


    public void addDepartment(Department department) {
        manager = factory.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(department);
        manager.close();
    }

    public void mergeEmployee(Employee e) {
        manager = factory.createEntityManager();
        manager.getTransaction().begin();
        manager.merge(e);
        manager.close();
    }
}
