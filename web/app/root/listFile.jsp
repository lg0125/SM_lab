<%--
  Created by IntelliJ IDEA.
  User: 1737783319
  Date: 2019/12/3
  Time: 15:55
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


<div class="container col-md-3">
    <div style="overflow: auto;height: 400px">

    <table class="table table-dark table-hover">
        <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">name</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="me" items="${requestScope.fileNameMap}">
                <c:url value="downloadServlet" var="downUrl" >
                    <c:param name="fileName" value="=${me.key}" />
                </c:url>
            <tr>
                <th scope="row">*</th>
                <td><a href="${downUrl}" class="btn btn-outline-info btn-sm" role="button">${me.value}</a></td>
            </tr>
            </c:forEach>
        </tbody>
    </table>

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
