package com.shoppingcart.servlet;

import com.shoppingcart.pojo.Invoice;
import com.shoppingcart.pojo.InvoiceItem;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("/cart.jsp"); 
        view.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Invoice invoice = (Invoice) session.getAttribute(CatalogServlet.INVOICE_SESSION_NAME);
        if (invoice == null || invoice.getInvoiceItemList().isEmpty()) {
            return;
        }
        
        List<InvoiceItem> itemList = invoice.getInvoiceItemList();
        itemList.forEach(ci -> ci.setInvId(invoice));
        
    }

}
