<%--
  Created by IntelliJ IDEA.
  User: 1737783319
  Date: 2019/12/4
  Time: 21:05
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

<form method="post" action="${pageContext.request.contextPath}/changeInfoServlet">

    <div class="form-group">
        <label>old_id</label>

        <label>
            <input type="text" class="form-control" name="old_id" placeholder="Enter old id" />
        </label>
    </div>

    <div class="form-group">
        <label>new_id</label>
        <label>
            <input type="password" class="form-control" name="new_id" placeholder="Enter new id" />
        </label>
    </div>

    <div class="form-group">
        <label>old_password</label>
        <label>
            <input type="text" class="form-control" name="old_password" placeholder="Enter old password" />
        </label>
    </div>

    <div class="form-group">
        <label>new_password</label>
        <label>
            <input type="password" class="form-control" name="new_password" placeholder="Enter new password" />
        </label>
    </div>

    <input type="hidden" name="type" value="student" />

    <button type="submit" class="btn btn-primary mb-3">Submit</button>
</form>

<%@include file="../include/htmlFoot.jsp"%>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="${pageContext.request.contextPath}/bootstrap/others/jquery.slim.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/others/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>
