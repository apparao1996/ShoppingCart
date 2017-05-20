<%-- 
    Document   : catalog
    Created on : May 2, 2017, 3:01:36 PM
    Author     : janith
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="com.shoppingcart.persistance.ItemDAO" %>
<%@ page import="com.shoppingcart.pojo.*" %>
<%@ page import="javax.annotation.Resource" %>
<%@ page import="javax.persistence.EntityManagerFactory" %>
<%@ page import="javax.persistence.PersistenceUnit" %>
<%@ page import="javax.transaction.UserTransaction" %>
<%@ page import="java.util.List" %>


<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Shopping Catalog</title>
        <meta name="generator" content="Google Web Designer 1.7.3.0307">
        <script type="text/javascript">
            var test = ${CHECKED_OUT};
            if(test == true){
                alert("All items checked out.\nSee you again!");
                ${CHECKED_OUT = false}
            }
        </script>
        <style type="text/css">
            p {
                margin: 5px;
            }

            h3 {
                margin: 5px;
            }

            div {
                padding: 3px;
            }

            td {
                padding: 8px;
            }

            .table_div {
                width: 90%;
                margin: auto;
            }

            .id {
                width: 10%;
            }

            .name {
                width: 20%;
            }

            .desc {
                width: 40%;
            }

            .price {
                width: 15%;
                text-align: right;
            }

            .qty {
                width: 80%;
                text-align: center;
            }

            .add_to_cart {
                width: 20%;
            }
        </style>
    </head>
    <body>
        <br>
        <h3>&nbsp; &nbsp; Shopping Catalog</h3>
        <br>
        <div id="go_to_cart_link" height="10%" width="20%" align="right">
            <a href="/ShoppingCart/cart">Go to cart</a>
        </div>
        <br>
        <h4>Select Items</h4>
        <div class="table_div">
            <table border="1">
            <%
                ItemDAO itemDAO = ItemDAO.getInstance();
                List<Item> items = itemDAO.getItems();
                for(Item item : items){
            %>
            <tr>
            <form name="item<%= item.getId() %>" method="POST" action="">
                    <td class="id"><%= item.getId() %></td>
                    <td class="name"><%= item.getName() %></td>
                    <td class="desc"><%= item.getDescription() %></td>
                    <td class="price"><%= item.getPrice() %></td> 
                    <input type="hidden" name="id" value="<%= item.getId() %>"> 
                    <input type="hidden" name="name" value="<%= item.getName() %>"> 
                    <input type="hidden" name="desc" value="<%= item.getDescription() %>"> 
                    <input type="hidden" name="price" value="<%= item.getPrice() %>">
                    <td><input class="qty" type="text" name="quantity" value="01" /></td>
                    <td><input type="submit" name="add_to_cart" value="Add To Cart"></td>
                </form>
            </tr>
            <%
            }    
            %>
            </table>
        </div>
    </body>
</html>
