<%-- 
    Document   : catalog
    Created on : May 2, 2017, 3:01:36 PM
    Author     : janith
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Shopping Catalog</title>
        <meta name="generator" content="Google Web Designer 1.7.3.0307">
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
            <a href="http://localhost:8080/ShoppingCart/cart">Go to cart</a>
        </div>
        <br>
        <h4>Select Items</h4>
        <div class="table_div">
            <table border="1">
                <tr>
                <form name="item1" method="POST" action="#">
                    <td class="id">001</td>
                    <td class="name">Item 01</td>
                    <td class="desc">Item 01 description</td>
                    <td class="price">100</td> <input type="hidden" name="id"
                                                      value="001"> <input type="hidden" name="name"
                                                      value="Item 01"> <input type="hidden" name="desc"
                                                      value="Item 01 description"> <input type="hidden"
                                                      name="price" value="100">
                    <td><input class="qty" type="text" name="quantity" value="01" /></td>
                    <td><input type="submit" name="add_to_cart"
                               value="Add To Cart"></td>
                </form>
                </tr>
                <tr>
                <form name="item2" method="POST" action="#">
                    <td class="id">002</td>
                    <td class="name">Item 02</td>
                    <td class="desc">Item 02 description</td>
                    <td class="price">200</td> <input type="hidden" name="id"
                                                      value="002"> <input type="hidden" name="name"
                                                      value="Item 02"> <input type="hidden" name="desc"
                                                      value="Item 02 description"> <input type="hidden"
                                                      name="price" value="200">
                    <td><input class="qty" type="text" name="quantity" value="01" /></td>
                    <td><input type="submit" name="add_to_cart"
                               value="Add To Cart"></td>
                </form>
                </tr>
                <tr>
                <form name="item3" method="POST" action="#">
                    <td class="id">003</td>
                    <td class="name">Item 03</td>
                    <td class="desc">Item 03 description</td>
                    <td class="price">300</td> <input type="hidden" name="id"
                                                      value="003"> <input type="hidden" name="name"
                                                      value="Item 03"> <input type="hidden" name="desc"
                                                      value="Item 03 description"> <input type="hidden"
                                                      name="price" value="300">
                    <td><input class="qty" type="text" name="quantity" value="01" /></td>
                    <td><input type="submit" name="add_to_cart"
                               value="Add To Cart"></td>
                </form>
                </tr>
            </table>
        </div>
    </body>
</html>
