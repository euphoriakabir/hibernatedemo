package com.oracle.main;

import com.oracle.dto.Employee;
import com.oracle.dto.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DriverClassGetLoad {
    public static void main(String[] args) {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        Project p1 = session.load(Project.class,2000);
        System.out.println("____________________________________________");
        System.out.println(p1);
        System.out.println("____________________________________________");
        System.out.println(p1.getEmployees());
        session.close();
        sf.close();
    }
}
