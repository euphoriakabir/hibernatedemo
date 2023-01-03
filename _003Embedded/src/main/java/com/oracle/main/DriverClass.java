package com.oracle.main;

import com.oracle.dto.Address;
import com.oracle.dto.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DriverClass {
    public static void main(String[] args) {
        SessionFactory sf=new Configuration().configure().buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();
        Employee emp1=new Employee();
        emp1.setFirstName("Pratik");
        emp1.setLastName("Gaurav");
        Address address=new Address();
        address.setCity("Patna");
        address.setStreet("A/12");
        Employee emp2=new Employee();
        emp2.setFirstName("Ankita");
        emp2.setLastName("Noopur");
        emp2.setAddress(address);
        emp1.setAddress(address);
        session.save(emp1);
        session.save(emp2);
        tx.commit();
        session.close();
        sf.close();
    }
}
