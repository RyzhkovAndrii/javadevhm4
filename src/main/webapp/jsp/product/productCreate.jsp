<%@ page import="goit.gojava7.ryzhkov.model.Manufacturer" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product creating...</title>
</head>
<body>
<form action="productCreate" method="post">
    Name: <input type="text" name="name"/> <br/>
    Price: <input type="text" name="price"/> <br/>
    Manufacturer:
    <select type="text" name="manufacturerId">
        <%
            List<Manufacturer> manufacturers = (List<Manufacturer>) request.getAttribute("manufacturers");
            for (Manufacturer manufacturer : manufacturers) {
        %>
        <option value="<%=manufacturer.getId()%>"><%=manufacturer.getName()%></option>
        <%
            }
        %>
    </select> <br/>
    <input type="submit" value="Create"/>
</form>
</body>
</html>
