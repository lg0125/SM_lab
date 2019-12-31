<%--
  Created by IntelliJ IDEA.
  User: 1737783319
  Date: 2019/12/5
  Time: 14:59
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

<%@include file="../include/htmlHead.jsp"%>

<%@include file="../include/teacherMenu.jsp" %>

<div class="container mb-3">
    <table class="table table-dark">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">course_id</th>
            <th scope="col">teacher_id</th>
            <th scope="col">teacher_name</th>
            <th scope="col">teacher_rank</th>
            <th scope="col">scan</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.teacher_course_list}" var="teacherCourse">
            <c:url value="courseGradeListServlet" var="scanURL">
                <c:param name="course_id" value="${teacherCourse.course_id}"/>
            </c:url>
            <tr>
                <th scope="row">*</th>
                <td>${teacherCourse.course_id}</td>
                <td>${teacherCourse.teacher_id}</td>
                <td>${teacherCourse.teacher_name}</td>
                <td>${teacherCourse.rank_name}</td>
                <td><a href="${scanURL}" class="btn btn-primary">scan</a></td>
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
