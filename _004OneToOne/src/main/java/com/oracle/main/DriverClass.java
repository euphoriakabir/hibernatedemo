package com.oracle.main;

import com.oracle.dto.AadharDetails;
import com.oracle.dto.Citizen;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DriverClass {
    public static void main(String[] args) {
        SessionFactory sf=new Configuration().configure().buildSessionFactory();
        Session session=sf.openSession();

        Transaction tx=session.beginTransaction();

        Citizen citizen1=new Citizen();
        citizen1.setFirstName("Pratik");
        citizen1.setLastName("Gaurav");

        AadharDetails ad1=new AadharDetails();
        ad1.setCity("Patna");
        ad1.setState("Bihar");

        Citizen citizen2=new Citizen();
        citizen2.setFirstName("Ankita");
        citizen2.setLastName("Noopur");

        AadharDetails ad2=new AadharDetails();
        ad2.setCity("Chappra");
        ad2.setState("Bihar");

        citizen1.setAadharDetails(ad1);
        citizen2.setAadharDetails(ad2);

        session.save(ad1);
        session.save(ad2);
        session.save(citizen1);
        session.save(citizen2);

        tx.commit();
        session.close();
        sf.close();
    }
}
