<%--
  Created by IntelliJ IDEA.
  User: 1737783319
  Date: 2019/12/3
  Time: 21:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="zh-cmn-Hans">
<head>
    <!-- Required meta tags -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <%--  <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">--%>
</head>
<body>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp">导航</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
    </button>

    <c:if test="${sessionScope.user_info.type == 'student'}">
        <div class="collapse navbar-collapse" id="collapsibleNavbar">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/listWriteMsgServlet">发表留言</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/listRepliedMsgServlet">已回答留言之查看</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/changeDeleteMsgServlet">留言修改删除</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/scanMsgReplyServlet">留言回复浏览</a>
                </li>

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                        留言板首页课程显示设置
                    </a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/msgContentSetDeptServlet">学院</a>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/msgContentSetTeacherServlet">教师</a>
                    </div>
                </li>
            </ul>
        </div>
    </c:if>

    <c:if test="${sessionScope.user_info.type == 'teacher'}">
        <div class="collapse navbar-collapse" id="collapsibleNavbar">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/listNotRepliedMsgServlet">待回复的留言</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/changeDeleteMsgReplyServlet">回复留言之修改删除</a>
                </li>
               <%-- <li class="nav-item">
                    <a class="nav-link" href="#">授课留言访问权限设置</a>
                </li>--%>
            </ul>
        </div>
    </c:if>

</nav>


<%--<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="${pageContext.request.contextPath}/bootstrap/others/jquery.slim.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/others/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.bundle.min.js"></script>--%>
</body>
</html>
