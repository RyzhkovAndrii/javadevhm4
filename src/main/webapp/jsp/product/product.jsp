<%@ page import="goit.gojava7.ryzhkov.model.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product info</title>
</head>
<body>
<%
    Product product = (Product) request.getAttribute("product");
%>
Name: <%=product.getName()%> <br>
Price: <%=product.getPrice()%> <br>
Manufacturer: <%=product.getManufacturer().getName()%> <br>
<hr>
<a href=productUpdate?id=<%=product.getId()%>>Change product</a>
<br>
<form action="productDelete" method="post">
    <a href="#" onclick="parentNode.submit();">Delete product</a>
    <input type="hidden" name="id" value="<%=product.getId()%>"/>
</form>
</body>
</html>
