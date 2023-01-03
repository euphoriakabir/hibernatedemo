package com.oracle.main;

import com.oracle.dto2.Component;
import com.oracle.dto2.Device;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.LinkedList;

public class DeviceDriverClass {
    public static void main(String[] args) {
        SessionFactory sf=new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();

        Component c1=new Component();
        c1.setName("Screen");
        c1.setManufacturer("Samsung");
        c1.setPrice(60.0);

        Component c2=new Component();
        c2.setName("Crown");
        c2.setPrice(10.0);
        c2.setManufacturer("Foxcomm");

        Component c3=new Component();
        c3.setName("Strap");
        c3.setManufacturer("Eagles Leather");
        c3.setPrice(40.0);

        LinkedList<Component> list=new LinkedList<Component>();
        list.add(c1);list.add(c2);list.add(c3);

        Device d1=new Device();
        d1.setName("Watch");
        d1.setOrigin("China");
        d1.setComponents(list);
        Transaction tx = session.beginTransaction();
        session.save(d1);
        session.save(c1);
        session.save(c2);
        session.save(c3);
        tx.commit();
        session.close();
        sf.close();
    }
}
