<%--
  Created by IntelliJ IDEA.
  User: 1737783319
  Date: 2019/12/11
  Time: 21:56
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
    <div style="margin-left: 20%;margin-right: 20%;">
        <div style="margin-bottom: 5%;">
            <h3>课程详情</h3>
            <p>《软件项目管理》是软件工程专业的专业课程，本课程有贯穿始终的项目案例， 让学生切身体会软件项目管理过程， 教材《软件项目管理案例教程》是北京市精品教材，十一五国家规划教教材，有百余所高校采用，具有不错口碑。</p>
            <footer class="blockquote-footer" style="text-align: right" >课程团队  </footer>
        </div>




        <div style="margin-bottom: 5%;">
            <h3>课程概述</h3>
            <p> 《软件项目管理》是软件工程专业的专业课程，以培养软件项目管理能力为目的，本课程以路线图的形式讲述了软件项目管理的理论、方法以及技巧，包括项目初始、项目计划、项目执行控制、项目结束。本课程将CDIO工程教育模式引入到课堂教学中来，以实现“做中学”和“基于项目的学习”。通过贯穿始终的项目案例和情景项目展示，同时通过一个Web项目实践,完成了基于敏捷模型的项目开发和管理过程. 让学生切身体会软件项目管理过程，从而更好地将软件项目管理理论与实践相结合。</p>

        </div>

        <div style="margin-bottom: 5%;">
            <h3>授课目标</h3>
            <p>通过本课程的学习和实践，学生可以具有系统的工程实践学习经历，培养学生具有一定的组织管理能力、表达能力和人际交往能力以及在团队中发挥作用的能力。课程教学理念是“以学生为中心”，培养和提高学生的实践能力，培养学生团队工程素养以及带领团队管理好一个软件项目的能力，其中包括项目计划能力、项目需求分析建模能力、软件实现和执行能力、软件控制管理能力等。最后满足企业对软件项目人才的要求。达到满足企业对软件项目人才要求是培养的核心目标。</p>
        </div>

        <div style="margin-bottom: 5%;">
            <span style="font-size: 18px;font-weight: bold;">课程大纲</span>
            <div class="container">
                <div id="accordion">
                    <div class="card">
                        <div class="card-header">
                            <a class="card-link" data-toggle="collapse" href="#collapseOne" style="color: black">
                                第一章 软件项目管理基本概念
                            </a>
                        </div>
                        <div id="collapseOne" class="collapse show" data-parent="#accordion">
                            <div class="card-body">
                                <ul style="color: #95999c">
                                    <li><small>1.1.软件项目管理 基本概念</small></li>
                                    <li><small>1.2.PMBOK与软件项目管理知识体系</small></li>
                                    <li><small>1.3.敏捷项目管理</small></li>
                                    <li><small>第一章单元测试</small></li>
                                </ul>
                            </div>
                        </div>
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
