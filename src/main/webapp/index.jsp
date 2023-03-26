
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="command.add.AddCar " %>
<html>
<head>
    <title>Car store</title>
</head>
<body BGCOLOR="#FDF5E6">
<div class="header">
    <a class="active" href="index.jsp">Home</a>
    <a class="footer__nav-link" href="servlet?command=view_model">Models</a>
    <a class="footer__nav-link" href="servlet?command=view_color">Colors</a>
    <a class="footer__nav-link" href="/servlet?command=view_engine">Engines</a>
    <a class="footer__nav-link" href="/servlet?command=view_option">Options</a>
    <a class="footer__nav-link" href="/servlet?command=view_transmission">Transmissions</a>
    <a class="footer__nav-link" href="servlet?command=view_car">Cars</a>
    <a class="footer__nav-link" href="/servlet?command=view_client">Clients</a>
    <a class="footer__nav-link" href="/servlet?command=view_order">Orders</a>
</div>
<footer class="footer">
    <div class="wrap wrap__footer">
        <div class="footer__top">
            <div class="footer__nav">
                <ul>
                    <li class="footer__nav-item">
                        <a class="footer__nav-link" href="index.jsp">Home</a>
                    </li>
                    <li class="footer__nav-item">
                        <a class="footer__nav-link" href="servlet?command=view_model">Models</a>
                    </li>
                    <li class="footer__nav-item">
                        <a class="footer__nav-link" href="servlet?command=view_car">Cars</a>
                    </li>
                    <li class="footer__nav-item">
                        <a class="footer__nav-link" href="servlet?command=view_color">Colors</a>
                    </li>
                    <li class="footer__nav-item">
                        <a class="footer__nav-link" href="/sale">Sale</a>
                    </li>
                    <li class="footer__nav-item">
                        <a class="footer__nav-link" href="/all-cats">Product catalog</a>
                    </li>
                </ul>
                <ul>
                    <li class="footer__nav-item">
                        <a class="footer__nav-link" href="/news">News</a>
                    </li>
                    <li class="footer__nav-item">
                        <a class="footer__nav-link" href="/shipping">Shipping and payment</a>
                    </li>
                    <li class="footer__nav-item">
                        <a class="footer__nav-link" href="servlet?command=view_order">Orders</a>
                    </li>
                </ul>
            </div>
            <div class="footer__top-right">

                <div class="footer__time">
                    <div class="footer__day-work">
                        <p>Opening hours: <span>09.00 - 21.00</span></p>
                        <div class="footer__day-items">
                            <div class="footer__day-item"></div>
                            <div class="footer__day-item"></div>
                            <div class="footer__day-item"></div>
                            <div class="footer__day-item"></div>
                            <div class="footer__day-item"></div>
                            <div class="footer__day-item"></div>
                            <div class="footer__day-item"></div>
                        </div>
                    </div>
                </div>
            </div>
            <ul class="footer__cards">
                <li class="footer__card footer__card-visa"></li>
                <li class="footer__card footer__card-master"></li>
            </ul>
        </div>


    </div>
</footer>
</body>
</html>
