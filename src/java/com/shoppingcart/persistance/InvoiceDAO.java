/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoppingcart.persistance;

import com.shoppingcart.pojo.Invoice;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 *
 * @author janith
 */
public class InvoiceDAO {
    
    private static InvoiceDAO instance = null;
    private final SessionFactory sessionFactory;
    
    private InvoiceDAO(){
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
                .applySettings(configuration.getProperties())
                .build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }
    
    public static InvoiceDAO getInstance(){
        if(instance == null){
            instance = new InvoiceDAO();
        }
        return instance;
    }
    
    public boolean saveInvoice(Invoice invoice){
        Session session = null;
        Transaction tx = null;
        boolean success = false;
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            session.save(invoice);
            tx.commit();
            success = true;
        } catch (Exception e) {
            System.out.println(e);
            tx.rollback();
            success = false;
        }finally{
            session.close();
        }
        return success;
    }
}