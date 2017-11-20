<%@ page import="goit.gojava7.ryzhkov.model.Product" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products</title>
</head>
<body>
<h3>Products</h3>
<%
    List<Product> products = (List<Product>) request.getAttribute("products");
    for (Product product : products) {
%>
<a href=product?id=<%=product.getId()%>><%=product.getName()%></a><br>
<%
    }
%>
<br>
<hr>
<a href=productCreate>Create product</a><br>
<br>
<a href=main>Main page</a>
</body>
</html>
