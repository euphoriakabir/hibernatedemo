package com.oracle.main;

import com.oracle.dto.Citizen;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Query {
    public static void main(String[] args) {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        javax.persistence.Query query = session.createQuery("from Citizen where cId=:x");
        query.setParameter("x", 1000L);
        Citizen c1 = (Citizen) query.getSingleResult();
        System.out.println(c1);

        javax.persistence.Query joinQuery =
                session.createQuery("select c.cId,c.firstName,c.lastName,c.joiningDate,acc.accountBalance,acc.accountOpeningDate,acc.branchCode from Citizen c inner join c.accounts acc");
         List<Object[]> list= joinQuery.getResultList();
        for(Object[] obj:list){
            //System.out.println(obj);
            for(Object x:obj){
                System.out.print (x+"("+x.getClass()+") ::");
            }
            System.out.println("-------------------------------------------------");
        }

        session.close();
        sf.close();
    }
}
