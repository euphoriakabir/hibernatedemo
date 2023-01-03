package com.oracle.main;

import com.oracle.dto.Employee;
import com.oracle.dto.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.GregorianCalendar;
import java.util.LinkedList;

public class DriverClass {
    public static void main(String[] args) {
        SessionFactory sf=new Configuration().configure().buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();

        Employee e1=new Employee();
        e1.setFirstName("Pratik");
        e1.setLastName("Gaurav");


        Employee e2=new Employee();
        e2.setFirstName("Ankita");
        e2.setLastName("Noopur");

        LinkedList<Employee> empList=new LinkedList<Employee>();
        empList.add(e1);empList.add(e2);

        Project p1=new Project();
        p1.setName("Zenith Bank");
        p1.setEmployeeList(empList);
        p1.setStartDate(new GregorianCalendar(2022,8,1));

        Project p2=new Project();
        p2.setName("Dukhan Bank");
        p2.setEmployeeList(empList);
        p2.setStartDate(new GregorianCalendar(2022,7,1));

        LinkedList<Project> projectsList=new LinkedList<Project>();
        projectsList.add(p1);
        projectsList.add(p2);

        e1.setProjectList(projectsList);
        e2.setProjectList(projectsList);

        session.save(e1);
        session.save(e2);
        session.save(p1);
        session.save(p2);

        tx.commit();
        session.close();
        sf.close();
    }
}
