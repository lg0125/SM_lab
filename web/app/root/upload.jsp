<%--
  Created by IntelliJ IDEA.
  User: 1737783319
  Date: 2019/12/3
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<%@include file="../include/indexMenu.jsp"%>

<form action="${pageContext.request.contextPath}/uploadServlet" enctype="multipart/form-data" method="post" class="form-control">
    <label>File1:</label>
    <label>
        <input type="file" name="file1"><br>
    </label>
    <label>File2:</label>
    <label>
        <input type="file" name="file2"><br>
    </label>
    <input type="submit" name="submit" value="submit">
</form>

<%@include file="../include/htmlFoot.jsp"%>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="${pageContext.request.contextPath}/bootstrap/others/jquery.slim.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/others/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>
