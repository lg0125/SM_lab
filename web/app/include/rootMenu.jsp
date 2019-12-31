<%--
  Created by IntelliJ IDEA.
  User: 1737783319
  Date: 2019/12/4
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="zh-cmn-Hans">
<head>
    <!-- Required meta tags -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

</head>
<body>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp">首页</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/app/root/rootInfo.jsp">管理员账号信息修改</a>
            </li>

            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#"  data-toggle="dropdown">
                    课程信息设置
                </a>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/transAddCourseServlet">增加课程</a>
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/transTeacherCourseServlet">增加选课</a>
                </div>
            </li>

            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown">
                    教师账号管理
                </a>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/transTeacherSignUpServlet">教师账号注册</a>

                    <a class="dropdown-item" href="${pageContext.request.contextPath}/transTeacherListServlet">教师列表查看</a>
                </div>
            </li>

        </ul>
    </div>
</nav>


</body>
</html>

