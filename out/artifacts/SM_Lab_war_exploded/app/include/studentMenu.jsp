<%--
  Created by IntelliJ IDEA.
  User: 1737783319
  Date: 2019/12/3
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="zh-cmn-Hans">
<head>
    <!-- Required meta tags -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
</head>
<body>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp">首页</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <ul class="navbar-nav">

            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/app/root/uploadHead.jsp">头像上传</a>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/transSelectCourseServlet">选课</a>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/transStudentCourseServlet">课表查询</a>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/transStudentGradeListServlet">成绩查询</a>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/scanWarningStudentServlet">成绩通知预警</a>
            </li>
        </ul>
    </div>
</nav>


<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="${pageContext.request.contextPath}/bootstrap/others/jquery.slim.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/others/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>

