package com.melshalati.util;

import com.melshalati.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;


public class ConnectionUtil {
    public  Session  getSession(){

        Configuration cfg = new Configuration();

        cfg.configure("hibernate.cfg.xml");

        SessionFactory factory = cfg.buildSessionFactory();

        Session session = factory.openSession();

        return session;
    }

    public List<Employee> getQuery(){
        Session session = getSession();
        Query query = session.createQuery("from Employee");
        List<Employee> list = query.list();
        return list;
    }
}
