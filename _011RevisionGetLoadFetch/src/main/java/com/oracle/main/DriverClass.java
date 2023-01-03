package com.oracle.main;

import com.oracle.dto.Employee;
import com.oracle.dto.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class DriverClass {
    public static void main(String[] args) {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Employee e1 = new Employee();
        e1.setFirstName("Pratik");
        e1.setLastName("Gaurav");
        e1.setSalary(1200.0);

        Employee e2 = new Employee();
        e2.setFirstName("Ankita");
        e2.setLastName("Noopur");
        e2.setSalary(1100.0);

        Employee e3 = new Employee();
        e3.setFirstName("Rudra");
        e3.setLastName("Narayan");
        e3.setSalary(2000.0);

        List<Employee> el1 = new LinkedList<Employee>();
        el1.add(e1);
        el1.add(e2);

        List<Employee> el2 = new LinkedList<Employee>();
        el2.add(e3);
        el2.add(e2);

        Project p1 = new Project();
        p1.setName("Zenith Bank");
        p1.setProjectCost(50000.0);
        p1.setEmployees(el1);
        p1.setStartDate(new Date(2022, 8, 1));

        Project p2 = new Project();
        p2.setName("Dukhan Bank");
        p2.setProjectCost(45000.0);
        p2.setEmployees(el2);
        p2.setStartDate(new Date(2022, 05, 1));

        List<Project> pl1 = new ArrayList<Project>();
        List<Project> pl2 = new ArrayList<Project>();

        pl1.add(p1);
        pl2.add(p2);

        e1.setProjects(pl1);
        e2.setProjects(pl2);

        session.save(e1);session.save(e2);session.save(e3);
        session.save(p1);session.save(p2);

        tx.commit();
        session.close();
        sf.close();
    }
}
