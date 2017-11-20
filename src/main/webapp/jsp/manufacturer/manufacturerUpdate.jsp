<%@ page import="goit.gojava7.ryzhkov.model.Manufacturer" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manufacturer info</title>
</head>
<body>
<%
    Manufacturer manufacturer = (Manufacturer) request.getAttribute("manufacturer");
%>
<form action="manufacturerUpdate" method="post">
    <input type="hidden" name="id" value = "<%=manufacturer.getId()%>"/> <br/>
    Name: <input type="text" name="name" value="<%=manufacturer.getName()%>"/> <br>
    <input type="submit" value="Update"/>
</form>
</body>
</html>