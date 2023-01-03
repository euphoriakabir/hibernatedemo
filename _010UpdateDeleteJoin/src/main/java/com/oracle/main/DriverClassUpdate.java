package com.oracle.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class DriverClassUpdate {
    public static void main(String[] args) {
        SessionFactory sf=new Configuration().configure().buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();
        Query query= session.createQuery("update Project set name=:x where id=:y");
        query.setParameter("x","Dukhan Bank Offshore");
        query.setParameter("y",2);
        Integer rowsUpdated = query.executeUpdate();
        tx.commit();
        System.out.println(rowsUpdated);
        session.close();
        sf.close();
    }
}
