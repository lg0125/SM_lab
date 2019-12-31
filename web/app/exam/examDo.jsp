<%--
  Created by IntelliJ IDEA.
  User: 1737783319
  Date: 2019/12/5
  Time: 21:57
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

<div class="container mb-3">
    <p>请回答下列问题</p>

    <form action="${pageContext.request.contextPath}/examDoServlet" method="post">
        <c:forEach items="${requestScope.problem_list}" var="problem" varStatus="status" begin="0" step="1" >
            <p>${status.index + 1}.${problem.question}</p>

            <label>
                <input type="radio" name="choose_${status.index + 1}" value="${problem.id}ID1" > ${problem.choose_1}
            </label>
            <label>
                <input type="radio" name="choose_${status.index + 1}" value="${problem.id}ID2" > ${problem.choose_2}
            </label>
            <label>
                <input type="radio" name="choose_${status.index + 1}" value="${problem.id}ID3" > ${problem.choose_3}
            </label>
            <label>
                <input type="radio" name="choose_${status.index + 1}" value="${problem.id}ID4" > ${problem.choose_4}
            </label>

            <br>
        </c:forEach>


        <input type="hidden" name="problem_num" value="${requestScope.problem_num}">
        <input type="hidden" name="course_id" value="${requestScope.course_id}">
        <input type="hidden" name="teacher_id" value="${requestScope.teacher_id}">
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>

</div>

<%@include file="../include/htmlFoot.jsp"%>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="${pageContext.request.contextPath}/bootstrap/others/jquery.slim.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/others/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>

