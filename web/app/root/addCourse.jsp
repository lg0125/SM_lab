<%--
  Created by IntelliJ IDEA.
  User: 1737783319
  Date: 2019/12/4
  Time: 21:07
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
<%@include file="../include/rootMenu.jsp"%>

<div class="container mb-3">
    <table class="table table-dark">
        <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">course_id</th>
                <th scope="col">course_name</th>
                <th scope="col">course_introduction</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${requestScope.course_list}" var="course" varStatus="status">
                <tr>
                    <th scope="row">${status.index}</th>
                    <td>${course.id}</td>
                    <td>${course.name}</td>
                    <td>${course.introduction}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>


<div class="container mb-3">
    <form method="post" action="${pageContext.request.contextPath}/addCourseServlet">

        <div class="form-group">
            <label>course_id</label>

            <label>
                <input type="text" class="form-control" name="course_id" placeholder="Enter course id" />
            </label>
        </div>

        <div class="form-group">
            <label>course_name</label>
            <label>
                <input type="text" class="form-control" name="course_name" placeholder="Enter course name" />
            </label>
        </div>

        <div class="form-group">
            <label>introduction</label>
            <label>
                <textarea class="form-control" name="introduction" rows="3" placeholder="Enter introduction"></textarea>
            </label>
        </div>

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