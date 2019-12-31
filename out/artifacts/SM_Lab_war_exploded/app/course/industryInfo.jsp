<%--
  Created by IntelliJ IDEA.
  User: 1737783319
  Date: 2019/12/11
  Time: 22:11
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

<%@include file="../include/indexMenu.jsp"%>

<div class="container-fluid lead " style="margin:10% 33%" >

<pre>
    <mark>《软件项目管理》
    </mark>是软件工程专业的专业课程，
本课程有贯穿始终的项目案例，
让学生切身体会软件项目管理过程，
教材《软件项目管理案例教程》是北京市精品教材，十一五国家规划教教材，
有百余所高校采用，具有不错口碑。
</pre>

</div>

<%@include file="../include/htmlFoot.jsp"%>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="${pageContext.request.contextPath}/bootstrap/others/jquery.slim.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/others/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>
