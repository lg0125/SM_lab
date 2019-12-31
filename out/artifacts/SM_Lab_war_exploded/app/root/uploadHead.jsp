<%--
  Created by IntelliJ IDEA.
  User: 1737783319
  Date: 2019/12/18
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
</head>
<body>

<%@include file="../include/htmlHead.jsp"%>
<c:if test="${sessionScope.user_info.type == 'teacher'}">
    <%@include file="../include/teacherMenu.jsp"%>
</c:if>

<c:if test="${sessionScope.user_info.type == 'student'}">
    <%@include file="../include/studentMenu.jsp"%>
</c:if>
<br>
<div class="container">
    <form action="${pageContext.request.contextPath}/UploadHeadServlet" enctype="multipart/form-data" method="post" >

            <input type="file" name="head" id="head" class="form-control"><br>
        <button class="btn btn-primary" type="submit">Submit</button><br>
    </form>
</div>


<br><br><br>
<%@include file="../include/htmlFoot.jsp"%>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="${pageContext.request.contextPath}/bootstrap/others/jquery.slim.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/others/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>
