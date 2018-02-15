<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Home</title>
</head>
<body>
<h1>Hello Spring MVC</h1>
<H2>List of Users: </H2>
<c:forEach var="post" items="${postList}">
    <c:out value="${post.id}"/>
    <c:out value="${post.title}"/>
    <c:forEach var="comment" items="${post.comments}">
        <c:out value="${comment.id}"/>
        <c:out value="${comment.review}"/>
    </c:forEach>
</c:forEach>
</body>
</html>