<%--
  Created by IntelliJ IDEA.
  User: 1737783319
  Date: 2019/12/3
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="zh-cmn-Hans">
<head>
    <!-- Required meta tags -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<%--    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="${pageContext.request.contextPath}/bootstrap/others/jquery.slim.min.js"></script>
    <script src="${pageContext.request.contextPath}/bootstrap/others/popper.min.js"></script>
    <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.bundle.min.js"></script>--%>
</head>
<body>


    <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp">首页</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="collapsibleNavbar">
            <ul class="navbar-nav">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                        课程介绍
                    </a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/app/course/courseIntro.jsp">课程信息</a>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/app/course/industryInfo.jsp">行业信息</a>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/app/course/teamIntro.jsp">团队介绍</a>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/app/course/contactUs.jsp">联系我们</a>
                    </div>
                </li>

                <c:if test="${sessionScope.user_info.type == 'student'}">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/app/student/studentContent.jsp">学生选课</a>
                    </li>
                </c:if>

                <c:if test="${sessionScope.user_info.type == 'teacher'}">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/app/teacher/teacherContent.jsp">教师管理</a>
                    </li>
                </c:if>

                <c:if test="${sessionScope.user_info.type == 'root'}">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/app/root/rootContent.jsp">管理员设置</a>
                    </li>
                </c:if>

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbardrop1" data-toggle="dropdown">
                        学习天地
                    </a>
                    <div class="dropdown-menu">
                        <c:if test="${sessionScope.user_info.type == 'student'}">
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/app/video/onlineStudy.jsp">网上课程</a>
                        </c:if>
                        <c:if test="${sessionScope.user_info.type == 'student'}">
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/transStuCourseExamServlet">在线测试</a>
                        </c:if>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/app/video/resourceContent.jsp">资料区</a>

                    </div>
                </li>

                <c:if test="${sessionScope.user_info.type == 'student'}">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/studentGoMsgServlet">留言板</a>
                    </li>
                </c:if>

                <c:if test="${sessionScope.user_info.type == 'teacher'}">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/teacherGoMsgServlet">留言板</a>
                    </li>
                </c:if>
            </ul>

        </div>
    </nav>
</body>
</html>
