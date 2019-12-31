<%--
  Created by IntelliJ IDEA.
  User: 1737783319
  Date: 2019/12/11
  Time: 23:37
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
<%@include file="../include/indexMenu.jsp"%>

<div class="container mb-3" style="margin-top:5px;">
    <div class="row">
        <div class="col-sm-3" style="overflow:scroll;">

            <ul class="list-group" style="height:10px">
                <li class="list-group-item list-group-item-info">   <a href="https://www.runoob.com/try/demo_source/mov_bbb.mp4"> <span class="badge">第一集</span></a></li>
                <li class="list-group-item list-group-item-info">   <a href="https://www.runoob.com/try/demo_source/mov_bbb.mp4"> <span class="badge">第二集</span></a></li>
                <li class="list-group-item list-group-item-info">  <a href="https://www.runoob.com/try/demo_source/mov_bbb.mp4"> <span class="badge">下载</span></a></li>
                <li class="list-group-item list-group-item-info">  <a href="https://www.runoob.com/try/demo_source/mov_bbb.mp4"> <span class="badge">下载</span></a></li>
                <li class="list-group-item list-group-item-info">  <a href="https://www.runoob.com/try/demo_source/mov_bbb.mp4"> <span class="badge">下载</span></a></li>
                <li class="list-group-item list-group-item-info">   <a href="https://www.runoob.com/try/demo_source/mov_bbb.mp4"> <span class="badge">下载</span></a></li>
                <li class="list-group-item list-group-item-info">  <a href="https://www.runoob.com/try/demo_source/mov_bbb.mp4"> <span class="badge">下载</span></a></li>
                <li class="list-group-item list-group-item-info">  <a href="https://www.runoob.com/try/demo_source/mov_bbb.mp4"> <span class="badge">下载</span></a></li>
                <li class="list-group-item list-group-item-info">  <a href="https://www.runoob.com/try/demo_source/mov_bbb.mp4"> <span class="badge">下载</span></a></li>
                <li class="list-group-item list-group-item-info">   <a href="https://www.runoob.com/try/demo_source/mov_bbb.mp4"> <span class="badge">下载</span></a></li>
                <li class="list-group-item list-group-item-info">  <a href="https://www.runoob.com/try/demo_source/mov_bbb.mp4"> <span class="badge">下载</span></a></li>
                <li class="list-group-item list-group-item-info">  <a href="https://www.runoob.com/try/demo_source/mov_bbb.mp4"> <span class="badge">下载</span></a></li>
                <li class="list-group-item list-group-item-info">  <a href="https://www.runoob.com/try/demo_source/mov_bbb.mp4"> <span class="badge">下载</span></a></li>
                <li class="list-group-item list-group-item-info"> <a href="https://www.runoob.com/try/demo_source/mov_bbb.mp4"> <span class="badge">下载</span></a></li>
            </ul>


        </div>


        <div class="col-sm-8">
            <h1>软件项目管理</h1>
            <p>描述</p>
            <video width="400" controls>
                <source src="https://www.runoob.com/try/demo_source/mov_bbb.mp4" type="video/mp4">

                Your browser does not support HTML5 video.
            </video>
        </div>
    </div>
</div>

<%@include file="../include/htmlFoot.jsp"%>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="${pageContext.request.contextPath}/bootstrap/others/jquery.slim.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/others/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>
