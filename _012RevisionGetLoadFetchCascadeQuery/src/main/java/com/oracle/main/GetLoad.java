package com.oracle.main;

import com.oracle.dto.Citizen;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cache.ehcache.internal.EhcacheRegionFactory;
import org.hibernate.cfg.Configuration;

public class GetLoad {
    public static void main(String[] args) {
        SessionFactory sf=new Configuration().configure().buildSessionFactory();
        Session session=sf.openSession();
        Citizen citizen= session.get(Citizen.class,1000L);
        System.out.println("------------------------------------------------");
        System.out.println(citizen);

        Citizen citizen1= session.load(Citizen.class,1001L);
        System.out.println("*************************************************");
        System.out.println(citizen1);

        session.close();
        sf.close();
    }
}
