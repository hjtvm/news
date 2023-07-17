<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<% request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Insert title here</title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.5.0.min.js"></script>
</head>
<body>

<div class="rightinfo">
    <table class="tablelist" >
        <thead>
        <tr>
            <th style="width:100px;text-align:center;">新闻类别id</th>
            <th style="width:100px;text-align:center;">新闻类别名称</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${!empty categoryList}">
            <c:forEach items="${categoryList}" var="category">
                <tr>
                    <td align="center">${category.categoryId}</td>
                    <td align="center">${category.categoryName}</td>
                </tr>
            </c:forEach>
        </c:if>
</body>
</html>