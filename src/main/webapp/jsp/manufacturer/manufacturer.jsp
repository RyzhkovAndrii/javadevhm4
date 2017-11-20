<%@ page import="goit.gojava7.ryzhkov.model.Manufacturer" %>
<%@ page import="goit.gojava7.ryzhkov.model.Product" %>
<%@ page import="java.util.Set" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manufacturer info</title>
</head>
<body>
<%
    Manufacturer manufacturer = (Manufacturer) request.getAttribute("manufacturer");
%>
Name: <%=manufacturer.getName()%> <br>
Products: <br>
<%
    Set<Product> products = manufacturer.getProducts();
    for (Product product : products) {
%>
<ul>
    <li><%=product.getName()%></li>
</ul>
<%
    }
%>
<hr>
<a href=manufacturerUpdate?id=<%=manufacturer.getId()%>>Change manufacturer</a>
<br>
<form action="manufacturerDelete" method="post">
    <a href="#" onclick="parentNode.submit();">Delete manufacturer</a>
    <input type="hidden" name="id" value="<%=manufacturer.getId()%>"/>
</form>
</body>
</html>