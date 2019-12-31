<%--
  Created by IntelliJ IDEA.
  User: 1737783319
  Date: 2019/12/9
  Time: 13:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="zh-cmn-Hans">
<head>
    <!-- Required meta tags -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
</head>
<body>

<%@include file="../include/htmlHead.jsp"%>
<%@include file="../include/msgBoardMenu.jsp"%>

<div class="container mb-3">
    <form action="${pageContext.request.contextPath}/writeMsgServlet" method="post">

        <div class="form-group">
            <label>title</label>
            <label>
                <input type="text" class="form-control" name="title" placeholder="Enter title" />
            </label>
        </div>

        <div class="form-group">
            <label>content</label>
            <label>
                <textarea class="form-control" name="content" rows="3" cols="20" placeholder="Enter content"></textarea>
            </label>
        </div>

        <input type="hidden" name="course_id" value="${requestScope.course_id}" />
        <input type="hidden" name="teacher_id" value="${requestScope.teacher_id}" />
        <button type="submit" class="btn btn-primary mb-3">Submit</button>
    </form>
</div>

<%@include file="../include/htmlFoot.jsp"%>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="${pageContext.request.contextPath}/bootstrap/others/jquery.slim.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/others/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>
