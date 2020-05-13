<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Activate User</title>
        <c:set var="context" value="${pageContext.request.contextPath}" />

        <link rel="stylesheet" href="${context}/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css">
        <script src="${context}/webjars/jquery/1.11.1/jquery.min.js"></script>
        <script src="${context}/webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>

        <script> let appPayload = ${response} </script>
    </head>
    <body>
        <div class="alert alert-danger" role="alert">
            ${response}
        </div>
    </body>
</html>
