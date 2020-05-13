<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

 <%
         String oktaBaseURL = "https://venuoktadomain.info?stateToken=";
        response.setStatus(response.SC_MOVED_TEMPORARILY);
         response.setHeader("Location", oktaBaseURL.concat(request.getAttribute("stateToken").toString())); 
  %>