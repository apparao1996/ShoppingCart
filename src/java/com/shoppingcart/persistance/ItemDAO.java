/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoppingcart.persistance;

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
public class ItemDAO {

    private static ItemDAO instance;
    private SessionFactory sessionFactory;

    private ItemDAO()  throws HibernateException{
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
                .applySettings(configuration.getProperties())
                .build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    public static ItemDAO getInstance() throws HibernateException{
        if(instance == null){
            instance = new ItemDAO();
        }
        return instance;
    }
    
    public List<Item> getItems() throws HibernateException{
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query q = session.getNamedQuery("Item.findAll");
        List<Item> items = q.list();
        return items;
    }
    
}
