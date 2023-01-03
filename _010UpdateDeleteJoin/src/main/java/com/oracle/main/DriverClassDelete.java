package com.oracle.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class DriverClassDelete {
    public static void main(String[] args) {
        SessionFactory sf=new Configuration().configure().buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx = session.beginTransaction();
        Query query= session.createQuery("delete from Project where pId=:x");
        query.setParameter("x",3);
        Integer rowsDeleted = query.executeUpdate();
        tx.commit();
        session.close();
        System.out.println("rowsDeleted :: " +rowsDeleted);
        sf.close();
    }
}
