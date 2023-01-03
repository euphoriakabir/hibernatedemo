package com.oracle.main;

import com.oracle.dto.BankAccount;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CacheDriver {
    public static void main(String[] args) {
        SessionFactory sf=new Configuration().configure().buildSessionFactory();
        Session session1 = sf.openSession();
        BankAccount account1 = session1.get(BankAccount.class,2000l);
        System.out.println(account1);
        session1.close();
        Session session2 = sf.openSession();
        BankAccount account2 = session2.get(BankAccount.class,2000l);
        System.out.println(account2);
        session1.close();
        sf.close();
    }
}
