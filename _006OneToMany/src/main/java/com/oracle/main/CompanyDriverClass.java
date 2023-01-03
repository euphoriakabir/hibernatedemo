package com.oracle.main;

import com.oracle.dto3.Company;
import com.oracle.dto3.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class CompanyDriverClass {
    public static void main(String[] args) {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();
        Company company=new Company();
        company.setName("Oracle");
        company.setCategory("IT");

        Employee e1=new Employee();
        e1.setCompany(company);
        e1.setName("Pratik Gaurav");
        e1.setDob(new Date());

        Employee e2=new Employee();
        e2.setCompany(company);
        e2.setName("Ankita Noopur");
        e2.setDob(new Date());

        Employee e3=new Employee();
        e3.setCompany(company);
        e3.setName("Rudra Narayan");
        e3.setDob(new Date());
        session.save(e1);session.save(e2);session.save(e3);session.save(company);
        tx.commit();
        session.close();
        sf.close();
    }
}
