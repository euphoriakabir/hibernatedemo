package com.oracle.main;

import com.oracle.dto.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class DriverClassJoin {
    public static void main(String[] args) {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        Query query = session.createQuery("select e.eId,e.firstName,e.lastName,e.doj,p.pId,p.startDate,p.name from Employee as e inner join e.projects as p where e.eId=:x");
        query.setParameter("x", 1);
        List<Object[]> list = query.getResultList();
        for (Object[] obj : list) {
            System.out.println("_____________________________");
            for (Object x : obj) {
                System.out.print(x + "-->>");
            }
            System.out.println("_____________________________");
        }
        session.close();
        sf.close();
    }
}
