<%-- 
    Document   : Cart
    Created on : May 2, 2017, 10:59:17 AM
    Author     : janith
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping Cart</title>
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
        <h3>&nbsp; &nbsp; Shopping Cart</h3>
        <br>
        <div id="go_to_catalog_link" height="10%" width="20%" align="right">
            <a href="http://localhost:8080/ShoppingCart">Go to catalog</a>
        </div>
        <br>
        <h4>Selected Items</h4>
        <div class="table_div">
            <c:if test="${cart.getItemList().size() > 0}">
                <table border="1">
                    <thead>
                    <td>Id</td>
                    <td>Name</td>
                    <td>Description</td>
                    <td>Unit Price</td>
                    <td>Qty.</td>
                    <td>Total</td>
                    </thead>                    
                    <c:forEach var="cartitem" items="${cart.getItemList()}">
                        <tr>
                            <td class="id">${cartitem.item.id}</td>
                            <td class="name">${cartitem.item.name}</td>
                            <td class="desc">${cartitem.item.description}</td>
                            <td class="price">${cartitem.item.price}</td>
                            <td class="quantity">${cartitem.quantity}</td>                        
                            <td class="price">${cartitem.item.price*cartitem.quantity}</td>
                            <c:set var="subTotal" scope="page" value="${subTotal + (cartitem.item.price*cartitem.quantity)}"/>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td colspan="5" class="price">Sub Total </td>
                        <td class="price"><c:out value="${subTotal}"/></td>
                    </tr>
                </table>       
            </c:if>
            <c:if test="${cart == null || cart.getItemList().size() == 0}">
                <h4>Cart is Empty!</h4>
            </c:if>
        </div>
    </body>
</html>
