<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Going to main page...</title>
</head>
<body>
    <% request.getRequestDispatcher("/jsp/main.jsp").forward(request, response);%>
</body>
</html>
