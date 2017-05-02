package com.shoppingcart.servlet;

import com.shoppingcart.pojo.Cart;
import com.shoppingcart.pojo.CartItem;
import com.shoppingcart.pojo.Item;
import java.io.IOException;
import java.util.ArrayList;
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
        }

        Item item = new Item();
        item.setId(Integer.parseInt(request.getParameter("id")));
        item.setName(request.getParameter("name"));
        item.setDescription(request.getParameter("desc"));
        item.setPrice(Integer.parseInt(request.getParameter("price")));

        int qty = Integer.parseInt(request.getParameter("quantity"));

        cart.addItem(item, qty);
        session.setAttribute("cart", cart);
        
        RequestDispatcher view = request.getRequestDispatcher("/catalog.jsp"); 
        view.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("/catalog.jsp"); 
        view.forward(request, response);
    }
       
}
