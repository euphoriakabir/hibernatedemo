package com.oracle.main;

import com.oracle.dto.Component;
import com.oracle.dto.Device;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.LinkedList;

public class DriverClass {
    public static void main(String[] args) {
        SessionFactory sf=new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        Component c1=new Component();
        c1.setName("Screen");
        c1.setPrice(2000.0);

        Component c2=new Component();
        c2.setName("Camera");
        c2.setPrice(2500.0);

        Component c3=new Component();
        c3.setName("Back Panel");
        c3.setPrice(1500.0);

        LinkedList<Component> componentList=new LinkedList<Component>();
        componentList.add(c1);
        componentList.add(c2);
        componentList.add(c3);

        Device d1=new Device();
        d1.setComponents(componentList);
        d1.setPrice(10000.0);
        d1.setName("Mobile Phone");

        Transaction tx=session.beginTransaction();

        session.save(d1);
        session.save(c1);
        session.save(c2);
        session.save(c3);
        c3.setPrice(1510.0);

        tx.commit();
        session.close();
        sf.close();

    }
}
