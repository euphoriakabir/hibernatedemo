package com.oracle.main;

import com.oracle.dto.BankAccount;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class LifeCycleDriver {
    public static void main(String[] args) {
        SessionFactory sf=new Configuration().configure().buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();
        BankAccount account= session.get(BankAccount.class,2000l);
        System.out.println("------------------------------------------------------");
        System.out.println(account);
        account.setAccountBalance(699999.0);
        tx.commit();
        session.close();
        sf.close();
    }
}
