package com.oracle.main;

import com.oracle.dto.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DriverClass {
    public static void main(String[] args) {
        SessionFactory sf=new Configuration().configure().buildSessionFactory();
        Session session=sf.openSession();
        Student student1=session.get(Student.class,2);
        System.out.println("********************");
        //System.out.println(student1);
        Student student2=session.get(Student.class,2);
        //System.out.println(student2);
        session.close();
        sf.close();
    }
}
