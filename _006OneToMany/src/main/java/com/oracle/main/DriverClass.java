package com.oracle.main;

import com.oracle.dto.Account;
import com.oracle.dto.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.LinkedList;

public class DriverClass {
    public static void main(String[] args) {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Account acc1=new Account();
        acc1.setBranch(001);
        acc1.setBalance(1000000.0);

        Account acc2=new Account();
        acc2.setBranch(001);
        acc2.setBalance(1100000.0);

        Customer cust1 = new Customer();
        cust1.setFirstName("pratik");
        cust1.setLastName("gaurav");

        LinkedList<Account> list=new LinkedList<Account>();
        list.add(acc1);list.add(acc2);

        cust1.setAccountList(list);

        session.save(acc1);
        session.save(acc2);
        session.save(cust1);

        tx.commit();
        session.close();
        sf.close();
    }
}
