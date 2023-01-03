package com.oracle.driver;

import com.oracle.dto.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

public class MainClass {
    public static void main(String[] args) throws IOException {
        SessionFactory sf= new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        Employee emp=new Employee();
        emp.setDob(new Date("22/02/1990"));
        emp.setFirstName("Pratik");
        emp.setLastName("Gaurav");
        FileInputStream fis=new FileInputStream("C:\\Users\\Pratik Gaurav\\Pictures\\Oracle-Java-2.jpg");
        byte[] arr=new byte[fis.available()];
        emp.setImage(arr);
        session.save(emp);
        tx.commit();
        session.close();
        sf.close();
    }
}
