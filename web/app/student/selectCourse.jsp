<%--
  Created by IntelliJ IDEA.
  User: 1737783319
  Date: 2019/12/5
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <h3>选课列表</h3>
    <table class="table table-dark">
        <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">student_id</th>
                <th scope="col">course_id</th>
                <th scope="col">course_name</th>
                <th scope="col">teacher_id</th>
                <th scope="col">teacher_name</th>
                <th scope="col">rank_name</th>
                <th scope="col">op</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${requestScope.select_course_list}" var="select_course">
                <c:url value="/selectCourseServlet" var="selectCourse">
                    <c:param name="course_id" value="${select_course.course_id}"/>
                    <c:param name="teacher_id" value="${select_course.teacher_id}"/>
                </c:url>
                <tr>
                    <th scope="row">*</th>
                    <td>${select_course.student_id}</td>
                    <td>${select_course.course_id}</td>
                    <td>${select_course.course_name}</td>
                    <td>${select_course.teacher_id}</td>
                    <td>${select_course.teacher_name}</td>
                    <td>${select_course.rank_name}</td>
                    <td>
                        <a href="${selectCourse}" class="btn btn-primary">submit</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

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
            <th scope="col">op</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.student_course_list}" var="student_course">
            <c:url value="/deleteSelectCourseServlet" var="deleteCourse">
                <c:param name="course_id" value="${student_course.course_id}"/>
                <c:param name="teacher_id" value="${student_course.teacher_id}"/>
            </c:url>
            <tr>
                <th scope="row">*</th>
                <td>${student_course.student_id}</td>
                <td>${student_course.student_name}</td>
                <td>${student_course.course_id}</td>
                <td>${student_course.course_name}</td>
                <td>${student_course.teacher_name}</td>
                <td>${student_course.rank_name}</td>
                <td>
                    <a href="${deleteCourse}" class="btn btn-primary">delete</a>
                </td>
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
