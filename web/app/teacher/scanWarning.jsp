<%--
  Created by IntelliJ IDEA.
  User: 1737783319
  Date: 2019/12/12
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="zh-cmn-Hans">
<head>
    <!-- Required meta tags -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
</head>
<body>

<%@include file="../include/htmlHead.jsp" %>
<%@include file="../include/teacherMenu.jsp" %>

<div class="container">
    <table class="table table-dark text-center">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">student_id</th>
            <th scope="col">title</th>
            <th scope="col">content</th>
            <th scope="col">time</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.teacher_warning}" var="warning">
            <tr>
                <th scope="col">*</th>
                <td>${warning.student_id}</td>
                <td>${warning.title}</td>
                <td>${warning.content}</td>
                <td><fmt:formatDate value="${warning.time}" pattern="yyyy-MM-dd"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<%@include file="../include/htmlFoot.jsp" %>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="${pageContext.request.contextPath}/bootstrap/others/jquery.slim.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/others/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>
