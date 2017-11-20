<%@ page import="goit.gojava7.ryzhkov.model.Manufacturer" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Manufacturers</title>
</head>
<body>
<h3>Manufacturers</h3>
<%
    List<Manufacturer> manufacturers = (List<Manufacturer>) request.getAttribute("manufacturers");
    for (Manufacturer manufacturer : manufacturers) {
%>
<a href=manufacturer?id=<%=manufacturer.getId()%>><%=manufacturer.getName()%></a><br>
<%
    }
%>
<br>
<hr>
<a href=manufacturerCreate>Create manufacturer</a><br>
<br>
<a href=main>Main page</a>
</body>
</html>