<%--
  Created by IntelliJ IDEA.
  User: 1737783319
  Date: 2019/12/12
  Time: 9:13
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

<%@include file="../include/htmlHead.jsp" %>
<%@include file="../include/teacherMenu.jsp" %>

<div class="container">
    <h3><a href="${pageContext.request.contextPath}/scanWarningServlet" class="btn btn-primary">已发表预警查看</a></h3>
</div>

<div class="container">
    <table class="table table-dark text-center">
        <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">course_id</th>
                <th scope="col">course_name</th>
                <th scope="col">student_id</th>
                <th scope="col">student_name</th>
                <th scope="col">teacher_name</th>
                <th scope="col">rank_name</th>
                <th scope="col">grade</th>
                <th scope="col">write</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${requestScope.studentGrade_warning_list}" var="studentGrade">
                <c:url value="/writeWarningServlet" var="writeWarning">
                    <c:param name="course_id" value="${studentGrade.course_id}"/>
                    <c:param name="teacher_id" value="${studentGrade.teacher_id}" />
                    <c:param name="student_id" value="${studentGrade.student_id}" />
                    <c:param name="grade" value="${studentGrade.grade}"/>
                </c:url>
                <tr>
                    <th scope="col">*</th>
                    <td>${studentGrade.course_id}</td>
                    <td>${studentGrade.course_name}</td>
                    <td>${studentGrade.student_id}</td>
                    <td>${studentGrade.student_name}</td>
                    <td>${studentGrade.teacher_name}</td>
                    <td>${studentGrade.rank_name}</td>
                    <td>${studentGrade.grade}</td>
                    <td><a href="${writeWarning}" class="btn btn-primary">Warning</a></td>
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
