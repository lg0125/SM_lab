<%--
  Created by IntelliJ IDEA.
  User: 1737783319
  Date: 2019/12/11
  Time: 22:15
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

<div class="container-fluid" style="display: block;margin-bottom: 4%;margin-top:3%">
    <h1 style="text-align: center " >团队介绍</h1>
    <div class="row">

        <div class="col-md-5 text-right">
            <img src="${pageContext.request.contextPath}/easyicon/1.jpg" alt="logo" height="300px" width="300px">
        </div>
        <div class="col-md-5" style="margin-top: 3%;font-size: 30px">
            <pre class="">Logo:
外边框代表我们的在线学习网站这个平台,
中间的长条代表来自各个地方的学习用户，
箭头代表我们教师团队以及开发人员等，
寓意大家一起努力在平台的帮助下，
一起突破自己，完成自己的目标。
            </pre>
        </div>
    </div>

</div>

<div class="container-fluid" style="display: block;margin-bottom: 4%">
    <h1 style="text-align: center ;margin-bottom: 15px">团队架构</h1>
    <div class="text-center">
        <img src="${pageContext.request.contextPath}/easyicon/2.png" alt="团队架构" height="400px" >
    </div>
</div>

<div class="container-fluid" style="display: block;margin-bottom: 4% ">
    <h1 style="text-align: center;">团队人员简介</h1>
    <div class="row align-items-center justify-content-center">
        <div class="col-md-8 ">
            <p style="font-size: 25px ;color: #95999c">团队主要有教师团队，开发维护人员以及市场专员
                其中教师团队，由多名资深软件项目管理研究方面的老师组成，网站中的所有视频，资料是这些老师们通过多年的教学经验以及各方面资源获取。
                开发维护人员由五名帅气的计算机科学与技术的男同学组成，负责了网站的开发、运维，虽然开发经验不多，但是钻研精神超级棒，
                小组成员各具特色，不断改善网站布局和使用感受，结合自身学习情况，为使用的用户创造最舒适的在线网站学习平台。
                市场专员主要负责网站的推广以及收集网站的使用反馈，帮助开发人员更好的完成自己的开发任务，同时，收集用户对于学习内容的反馈，及时帮助教师团队提高教学质量，优化教学方式。
            </p>
        </div>
    </div>
    <div>

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
