package com.shoppingcart.servlet;

import com.shoppingcart.persistance.InvoiceDAO;
import com.shoppingcart.pojo.Invoice;
import com.shoppingcart.pojo.InvoiceItem;
import static com.shoppingcart.servlet.CatalogServlet.INVOICE_SESSION_NAME;
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
        
        //Handle item quantity updates
        if(request.getParameter("update") != null){
            try{            
                int itemId = Integer.parseInt(request.getParameter("id"));
                int qty = Integer.parseInt(request.getParameter("quantity"));
                itemList.stream()
                    .filter(ci -> ci.getItemId().getId() == itemId)
                    .forEach(ci -> ci.setQuantity(qty));
                RequestDispatcher view = request.getRequestDispatcher("/cart.jsp");
                view.forward(request, response);
            }catch(NumberFormatException e){
                RequestDispatcher view = request.getRequestDispatcher("/cart.jsp");
                view.forward(request, response);
            }
        }
        
        //Handle item removals
        if(request.getParameter("delete") != null){
            try{
                int itemId = Integer.parseInt(request.getParameter("id"));
                itemList.removeIf(ci -> ci.getItemId().getId() == itemId);
                RequestDispatcher view = request.getRequestDispatcher("/cart.jsp");
                view.forward(request, response);
            }catch(NumberFormatException e){
                RequestDispatcher view = request.getRequestDispatcher("/cart.jsp");
                view.forward(request, response);
            }
        }
        
        //Handle checkout. This part persists the invoice object
        if(request.getParameter("checkout") != null){
            boolean saved = InvoiceDAO.getInstance().saveInvoice(invoice);
            session.setAttribute("CHECKED_OUT", saved);
            session.removeAttribute(INVOICE_SESSION_NAME);
            response.sendRedirect("/ShoppingCart");
        }
    }

}
