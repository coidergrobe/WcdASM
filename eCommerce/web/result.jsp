<%@ page import="com.example.model.ProductFinderBean" %><%--
  Created by IntelliJ IDEA.
  User: ntidaking
  Date: 6/3/2020
  Time: 4:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>List Product</title>
</head>
<body>
    <h2>List of Produdcts</h2>
    <%
        // nhan tham so gui len trong controller
        String keyword = request.getParameter("name");
        if(keyword == null || keyword.trim().isEmpty()){
            response.sendRedirect("search.jsp?msg=Enter your keyword");
            return;
        }
    %>

<%--        // goi model--%>
<jsp:useBean id="finder" class="com.example.model.ProductFinderBean"/>
<jsp:setProperty name="finder" property="keyword" value="<%=keyword%>"/>
<%--    jsp tag--%>

<%--<%--%>
<%--    ProductFinderBean productFinderBean = new ProductFinderBean();--%>
<%--    productFinderBean.setKeyword(keyword);--%>
<%--%>--%>

<table>
    <tr>
        <td>Id</td>
        <td>Name</td>
        <td>Description</td>
    </tr>
    <c:forEach items="${finder.products}" var="product">
        <tr>
            <td><c:out value="${product.id}"/></td>
            <td><c:out value="${product.name}"/></td>
            <td><c:out value="${product.description}"/></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
