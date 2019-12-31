<%--
  Created by IntelliJ IDEA.
  User: 1737783319
  Date: 2019/12/9
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<%@include file="../include/msgBoardMenu.jsp"%>

<div class="container mb-3">
    <form action="${pageContext.request.contextPath}/scanMsgSearchServlet" method="post">
        <div class="form-group">
            <label>title</label>
            <label>
                <input type="text" class="form-control" name="title" placeholder="Enter title" />
            </label>
        </div>

        <div class="form-group">
            <label>content</label>
            <label>
                <input type="text" class="form-control" name="content" placeholder="Enter content" />
            </label>
        </div>

        <div class="form-group">
            <label>student_name</label>
            <label>
                <input type="text" class="form-control" name="student_name" placeholder="Enter student_name" />
            </label>
        </div>


        <button type="submit" class="btn btn-primary mb-3">Submit</button>
    </form>
</div>

<div class="container mt-3">
    <c:forEach items="${requestScope.message_list}" var="message">
        <div class="media border p-3">
            <c:if test="${message.student_photo == ''}">
                <img src="https://static.runoob.com/images/mobile-icon.png" alt="John Doe" class="mr-3 mt-3 rounded-circle" style="width:60px;">
            </c:if>
            <c:if test="${message.student_photo != ''}">
                <img src="${pageContext.request.contextPath}${message.student_photo}" alt="John Doe" class="mr-3 mt-3 rounded-circle" style="width:60px;">
            </c:if>
            <div class="media-body">
                <h4>Title:${message.title}</h4>
                <p>Name:${message.student_name}</p>
                <blockquote class="blockquote">
                    <p>${message.content}</p>
                    <footer class="blockquote-footer"><fmt:formatDate value="${message.time}" pattern="yyyy-MM-dd"/></footer>
                </blockquote>

                <c:set var="message_id" value="${message.id + 0}"/>
                <c:set var="reply_list" value="${requestScope.reply_map[message_id]}"/>
                <c:forEach items="${reply_list}" var="reply">
                    <div class="media p-3">
                        <c:if test="${reply.teacher_photo == ''}">
                            <img src="https://static.runoob.com/images/mobile-icon.png" alt="John Doe" class="mr-3 mt-3 rounded-circle" style="width:60px;">
                        </c:if>
                        <c:if test="${reply.teacher_photo != ''}">
                            <img src="${pageContext.request.contextPath}${reply.teacher_photo}" alt="John Doe" class="mr-3 mt-3 rounded-circle" style="width:60px;">
                        </c:if>
                        <div class="media-body">
                            <p>Name:${reply.teacher_name}</p>
                            <blockquote class="blockquote">
                                <p>${reply.content}</p>
                                <footer class="blockquote-footer"><fmt:formatDate value="${reply.time}" pattern="yyyy-MM-dd"/>/footer>
                            </blockquote>

                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </c:forEach>
</div>

<%@include file="../include/htmlFoot.jsp"%>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="${pageContext.request.contextPath}/bootstrap/others/jquery.slim.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/others/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>
