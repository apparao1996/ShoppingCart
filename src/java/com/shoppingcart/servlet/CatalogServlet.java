package com.shoppingcart.servlet;

import com.shoppingcart.persistance.ItemDAO;
import com.shoppingcart.pojo.Invoice;
import com.shoppingcart.pojo.Item;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author janith
 */
public class CatalogServlet extends HttpServlet {

    public static final String INVOICE_SESSION_NAME = "invoice";
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Invoice invoice = (Invoice) session.getAttribute(INVOICE_SESSION_NAME);
        if (invoice == null) {
            invoice = new Invoice();
        }

        Item item = new Item();
        item.setId(Integer.parseInt(request.getParameter("id")));
        item.setName(request.getParameter("name"));
        item.setDescription(request.getParameter("desc"));
        item.setPrice(Integer.parseInt(request.getParameter("price")));

        int qty = Integer.parseInt(request.getParameter("quantity"));

        invoice.addItem(item, qty);
        session.setAttribute(INVOICE_SESSION_NAME, invoice);
        
        RequestDispatcher view = request.getRequestDispatcher("/catalog.jsp"); 
        view.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        RequestDispatcher view = request.getRequestDispatcher("/catalog.jsp"); 
        view.forward(request, response);
    }
       
}
