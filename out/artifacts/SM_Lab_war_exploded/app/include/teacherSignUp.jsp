<%--
  Created by IntelliJ IDEA.
  User: 1737783319
  Date: 2019/12/3
  Time: 20:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-cmn-Hans">
<head>
    <!-- Required meta tags -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
</head>
<body>

<%@include file="htmlHead.jsp" %>
<%@include file="rootMenu.jsp"%>

<div class="container mb-3">
    <table class="table table-dark">
        <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">id</th>
                <th scope="col">password</th>
                <th scope="col">name</th>
                <th scope="col">rank</th>
                <th scope="col">introduction</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${requestScope.teacher_list}" var="teacher" varStatus="status">
                <tr>
                    <th scope="row">${status.index}</th>
                    <td>${teacher.id}</td>
                    <td>${teacher.password}</td>
                    <td>${teacher.name}</td>
                    <td>${teacher.rank_name}</td>
                    <td>${teacher.introduction}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<div class="container mb-3">
    <h2>教师账号注册</h2>
    <form method="post" action="${pageContext.request.contextPath}/signUpServlet">
        <div class="form-group">
            <label for="id">id:</label>
            <input type="text" class="form-control" id="id"  name="id" placeholder="Enter Student id">
        </div>

        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" class="form-control" id="password"  name="password" placeholder="Enter Student password">
        </div>

        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" class="form-control" id="name"  name="name" placeholder="Enter your name">
        </div>

        <div class="form-group mb-3">
            <label for="rank_name">Rank:
                <select name="rank_name" class="custom-select-sm" id="rank_name">
                    <option value="assistant">assistant</option>
                    <option value="lecturer">lecturer</option>
                    <option value="adj_professor">adj_professor</option>
                    <option value="professor">professor</option>
                </select>
            </label>
        </div>

        <div class="form-group">
            <label for="introduction">introduction</label>
            <textarea class="form-control" id="introduction" name="introduction" cols="20" rows="3"></textarea>
        </div>

        <input type="hidden" name="type" value="teacher" />

        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>

<%@include file="htmlFoot.jsp"%>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="${pageContext.request.contextPath}/bootstrap/others/jquery.slim.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/others/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>
