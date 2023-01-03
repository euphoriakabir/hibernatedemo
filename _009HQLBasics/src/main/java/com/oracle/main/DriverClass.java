package com.oracle.main;

import com.oracle.dto.Employee;
import com.oracle.dto.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

public class DriverClass {
    public static void main(String[] args) {
        SessionFactory sf=new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();

        /*Project p1=new Project();
        p1.setName("Zenith Bank");
        p1.setStartDate(new GregorianCalendar(2022,8,1));

        Project p2=new Project();
        p2.setName("Dukhan Bank");
        p2.setStartDate(new GregorianCalendar(2022,7,1));

        Project p3=new Project();
        p3.setName("Dubai Customs");
        p3.setStartDate(new GregorianCalendar(2022,5,12));

        List<Project> projects=new LinkedList<Project>();
        projects.add(p1);projects.add(p2);projects.add(p3);

        Employee e1=new Employee();
        e1.setProjects(projects);
        e1.setFirstName("Pratik");
        e1.setLastName("Gaurav");
        e1.setDoj(new GregorianCalendar(2022,05,12));

        List<Employee> employees=new LinkedList<Employee>();
        employees.add(e1);

        p1.setEmployees(employees);
        p2.setEmployees(employees);
        p3.setEmployees(employees);

        Transaction tx = session.beginTransaction();

        session.save(p1);
        session.save(p2);
        session.save(p3);
        session.save(e1);

        p1.setName("Zenith Bank Onsite.");

        tx.commit();*/

        Query query = session.createQuery("from Project");
        List<Project> projects = query.getResultList();
        for(Project p:projects){
            System.out.println(p);
        }
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        Query query1 = session.createQuery("from Project where pId=:x");
        query1.setParameter("x",1);
        Project p1= (Project) query1.getSingleResult();
        System.out.println(p1);

        session.close();

        sf.close();
    }
}
