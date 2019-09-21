<%--
  Created by IntelliJ IDEA.
  User: fernandobraga
  Date: 21/9/19
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Success</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/b4abea9736.js"></script>
    </head>
    <body>
        <div class="mx-auto alert alert-success text-center" role="alert">
            <h4 class="alert-heading">Login was succesful!
                <i class="far fa-check-circle"></i>
            </h4>
            <p>Welcome, <c:out value="${username}"/></p>
        </div>
    </body>
</html>
