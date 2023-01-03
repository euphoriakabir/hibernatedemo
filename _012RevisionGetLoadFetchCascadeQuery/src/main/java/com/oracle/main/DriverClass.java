package com.oracle.main;

import com.oracle.dto.BankAccount;
import com.oracle.dto.Citizen;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.Date;
import java.util.LinkedList;

public class DriverClass {
    public static void main(String[] args) {
        SessionFactory sf=new Configuration().configure().buildSessionFactory();

        Citizen c1=new Citizen();
        c1.setFirstName("Pratik");
        c1.setLastName("Gaurav");
        c1.setJoiningDate(new Date(2022,05,12));

        Citizen c2=new Citizen();
        c2.setFirstName("Ankita");
        c2.setLastName("Noopur");
        c2.setJoiningDate(new Date(2021,05,12));


        BankAccount b1=new BankAccount();
        b1.setBranchCode(001);
        b1.setAccountBalance(350000.0);
        b1.setAccountOpeningDate(new Date(2022,07,22));

        BankAccount b2=new BankAccount();
        b2.setBranchCode(001);
        b2.setAccountBalance(450000.0);
        b2.setAccountOpeningDate(new Date(2022,8,21));

        BankAccount b3=new BankAccount();
        b3.setBranchCode(001);
        b3.setAccountBalance(550000.0);
        b3.setAccountOpeningDate(new Date(2022,07,22));

        Session session= sf.openSession();
        Transaction tx=session.beginTransaction();
        session.save(c1);
        session.save(c2);
        /*session.save(b1);
        session.save(b2);
        session.save(b3);*/

        LinkedList<BankAccount> list1=new LinkedList<BankAccount>();
        list1.add(b1);list1.add(b2);

        LinkedList<BankAccount> list2=new LinkedList<BankAccount>();
        list2.add(b3);

        c1.setAccounts(list1);
        c2.setAccounts(list2);

        tx.commit();
        session.close();
        sf.close();
    }
}
