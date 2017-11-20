<%@ page import="goit.gojava7.ryzhkov.model.Manufacturer" %>
<%@ page import="goit.gojava7.ryzhkov.model.Product" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product updating...</title>
</head>
<body>
<%
    Product product = (Product) request.getAttribute("product");
    Manufacturer productManufacturer = product.getManufacturer();
%>
<form action="productUpdate" method="post">
    <input type="hidden" name="id" value = "<%=product.getId()%>"/> <br/>
    Name: <input type="text" name="name" value = "<%=product.getName()%>"/> <br/>
    Price: <input type="text" name="price" value = "<%=product.getPrice()%>"/> <br/>
    Manufacturer:
    <select type="text" name="manufacturerId" >
        <%
            List<Manufacturer> manufacturers = (List<Manufacturer>) request.getAttribute("manufacturers");
            for (Manufacturer manufacturer : manufacturers) {
                if (manufacturer.getId().equals(productManufacturer.getId())) {
        %>
        <option selected value="<%=productManufacturer.getId()%>"><%=productManufacturer.getName()%></option>
        <%
            } else {
        %>
        <option value="<%=manufacturer.getId()%>"><%=manufacturer.getName()%></option>
        <%
                }
            }
        %>
    </select> <br/>
    <input type="submit" value="Update"/>
</form>
</body>
</html>
