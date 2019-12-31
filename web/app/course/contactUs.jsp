<%--
  Created by IntelliJ IDEA.
  User: 1737783319
  Date: 2019/12/11
  Time: 22:04
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

<div class="container-fluid" style="display: block;">

    <div class="col-sm-3 col-md-5 " style="margin-left:10% ">
        <p class="display-4">联系我们：</p>
        <p style="font-size: 35px">Contact us:</p>

    </div>

    <div  style="margin-bottom: 5%" >
        <div style="margin:0 auto;width:250px;height:50px;border:1px solid #F00}">
            <img src="${pageContext.request.contextPath}/easyicon/mail_36px_1164631_easyicon.net.png" style="padding-right: 10px"/>
            <span style="display:inline-block">1737783319@qq.com</span><br><br>
        </div>
        <div style="margin:0 auto;width:250px;height:50px;border:1px solid #F00}">
            <img src="${pageContext.request.contextPath}/easyicon/location_22.666666666667px_1164569_easyicon.net.png" style="vertical-align:middle;padding-left: 5px;padding-right: 14px"/>
            <span style="display:inline-block">上海市杨浦区军工路516号</span><br><br>
        </div>
        <div style="margin:0 auto;width:250px;height:50px;border:1px solid #F00}">
            <img src="${pageContext.request.contextPath}/easyicon/wechat_32px_1164797_easyicon.net.png" style="vertical-align:middle;padding-right: 10px"/>
            <span style="display:inline-block">由他代劳有限责任公司</span><br><br>
        </div>
        <div style="margin:0 auto;width:250px;height:50px;border:1px solid #F00}">
            <img src="" style="vertical-align:middle;padding-right: 10px"/>
            <span style="display:inline-block">二公寓三号楼326</span>
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
