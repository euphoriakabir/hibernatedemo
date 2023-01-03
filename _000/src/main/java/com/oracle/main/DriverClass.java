package com.oracle.main;

import com.oracle.dto.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DriverClass {
    public static void main(String[] args) {
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Student st=new Student();
        st.setFirstName("Pratik");
        st.setLastName("Gaurav");
        session.save(st);
        tx.commit();
        session.close();
        sessionFactory.close();
    }
}
