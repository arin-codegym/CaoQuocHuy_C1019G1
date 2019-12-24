<%--
  Created by IntelliJ IDEA.
  User: Arin
  Date: 12/12/2019
  Time: 10:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer List</title>
</head>
<body>
<h1>Products</h1>
<p>
    <a href="${pageContext.request.contextPath}/product?action=create">Create new Product</a>
</p>
<table border="1">
    <tr>
        <td>Name Product</td>
        <td>Price</td>
        <td>Producer</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach items='${requestScope["productList"]}' var="product">
        <tr>
            <td>
                <a href="${pageContext.request.contextPath}/product?action=view&id=${product.getId()}">${product.getName()}</a>
            </td>
            <td>${product.getPrice()}</td>
            <td>${product.getProducer()}</td>
            <td><a href="${pageContext.request.contextPath}/product?action=edit&id=${product.getId()}">edit</a></td>
            <td><a href="${pageContext.request.contextPath}/product?action=delete&id=${product.getId()}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>