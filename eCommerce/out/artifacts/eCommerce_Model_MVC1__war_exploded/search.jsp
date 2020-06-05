<%--
  Created by IntelliJ IDEA.
  User: ntidaking
  Date: 6/3/2020
  Time: 4:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p>Product List</p>
    <form action="result.jsp" method="get">
        <span style="color: red">
            <c:out value="${param.msg}"/>
        </span>
        <input type="text" name="name">
        <button>Submit</button>
    </form>
</body>
</html>
