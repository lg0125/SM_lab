<%--
  Created by IntelliJ IDEA.
  User: 1737783319
  Date: 2019/12/5
  Time: 8:17
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
<%@include file="../include/studentMenu.jsp"%>

<div class="container mb-3">
    <table class="table table-dark">
        <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">student_id</th>
                <th scope="col">student_name</th>
                <th scope="col">course_id</th>
                <th scope="col">course_name</th>
                <th scope="col">teacher_name</th>
                <th scope="col">teacher_rank</th>
                <th scope="col">grade</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${requestScope.student_grade_list}" var="studentGrade">
                <tr>
                    <th scope="row">*</th>
                    <td>${studentGrade.student_id}</td>
                    <td>${studentGrade.student_name}</td>
                    <td>${studentGrade.course_id}</td>
                    <td>${studentGrade.course_name}</td>
                    <td>${studentGrade.teacher_name}</td>
                    <td>${studentGrade.rank_name}</td>
                    <td>${studentGrade.grade}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<%@include file="../include/htmlFoot.jsp"%>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="${pageContext.request.contextPath}/bootstrap/others/jquery.slim.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/others/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>

