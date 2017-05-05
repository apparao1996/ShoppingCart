/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoppingcart.persistance;

import com.shoppingcart.pojo.User;
import com.shoppingcart.pojo.Item;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 *
 * @author janith
 */
public class UserDAO {
    
    private static UserDAO instance;
    private SessionFactory sessionFactory;

    private UserDAO() throws HibernateException{
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
                .applySettings(configuration.getProperties())
                .build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    public static UserDAO getInstance() throws HibernateException{
        if(instance == null){
            instance = new UserDAO();
        }
        return instance;
    }
    
    public List<User> getItems() throws HibernateException{
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query q = session.getNamedQuery("User.findAll");
        List<User> items = q.list();
        return items;
    }
    
}
