package se.joafre;

import org.hibernate.Transaction;
import se.joafre.model.Department;
import se.joafre.model.Employee;
import se.joafre.model.ParkingSpace;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public final class Runner {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");

    private static EntityManager em;

    private static EntityTransaction tx;

    public static void main(String[] args) {

        ParkingSpace parkingSpace = new ParkingSpace(1L, "2A");
        Employee one = new Employee("fredrik", parkingSpace);

        Department it = new Department("IT");
        Department floor = new Department("Floor");
        Department boss = new Department("Boss");

        one.addDepartment(it).addDepartment(floor).addDepartment(boss);

        System.out.println("Departments size: " + one.getDepartments().size());

        em = emf.createEntityManager();

        tx = em.getTransaction();

        tx.begin();
        em.persist(one);
        tx.commit();
        em.close();

    }


}
