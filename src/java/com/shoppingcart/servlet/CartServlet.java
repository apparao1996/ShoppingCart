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

public class CartServlet extends HttpServlet {

    RequestDispatcher requetsDispatcherObj;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        requetsDispatcherObj = request.getRequestDispatcher("/Cart.jsp");
        requetsDispatcherObj.forward(request, response);
    }

}
