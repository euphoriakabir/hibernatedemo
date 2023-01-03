package com.oracle.main;

import com.oracle.dto.Subject;
import com.oracle.dto.Trainee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.LinkedList;

public class TrainerDriver {
    public static void main(String[] args) {
        SessionFactory sf=new Configuration().configure().buildSessionFactory();
        Session session=sf.openSession();
        /*Transaction tx=session.beginTransaction();

        Subject s1=new Subject();
        s1.setName("Java");

        Subject s2=new Subject();
        s2.setName("C++");

        Trainee t1=new Trainee();
        t1.setName("Pratik");

        Trainee t2=new Trainee();
        t2.setName("Gaurav");

        LinkedList<Subject> sList=new LinkedList<Subject>();
        sList.add(s1);sList.add(s2);

        LinkedList<Trainee> tList=new LinkedList<Trainee>();
        tList.add(t1);tList.add(t2);

        s1.setTrainees(tList);
        s2.setTrainees(tList);

        t1.setSubjects(sList);
        t2.setSubjects(sList);

        session.save(s1);
        session.save(s2);
        session.save(t1);
        session.save(t2);

        tx.commit();*/
        Subject subject = session.get(Subject.class,1);
        System.out.println(subject);
        System.out.println("#######################");
        System.out.println(subject.getTrainees());
        session.close();

        sf.close();
    }
}
