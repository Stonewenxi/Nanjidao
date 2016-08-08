<%--
  Created by IntelliJ IDEA.
  User: shuqi
  Date: 3/9/16
  Time: 4:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ page import="java.io.File" %>
<%!
    private long getFileTime(String filePath) {
        long l;
        File file = new File(filePath);
        l = file.lastModified();
        return l;
    }
%>
<html>
<head>
    <base href="http://${header['host']}${pageContext.request.contextPath}">
    <link href="css/index.css?v=<%= getFileTime(application.getRealPath("css/index.css")) %>" rel="stylesheet"
          type="text/css">
    <script type="text/javascript"
            src="js/common.js?v=<%= getFileTime(application.getRealPath("js/common.js")) %>"></script>
    <title>欢迎来到LinhuiFund</title>
</head>
<body>
<!--网站Logo区-->
<section class="logo">
    <img src="images/LinhuiFundLogo.png" height=62>
</section>
<!--网站Logo区以上-->

<!--题图区-->
<section class="themePic">
    <header>
        <h1 id="sortTitle" sortId=${sortId}>全部项目</h1>
        <div style="margin-top:0.14rem;margin-bottom:0.14rem;height:0.01rem;width:3.23rem;background-color:#777777;"></div>
        <p></p>
    </header>
</section>
<!--题图区以上-->

<!--主内容区-->
<section class="content">

    <!--主内容区左边-->
    <section class="contentDetail">

        <section id="project_section">
            <!--一个折叠后的项目-->
            <section class="contentDetailCollapsed" style="display: block">
                <header>
                    <p><span class="title"></span><span class="subTitle"></span></p>
                </header>
                <p></p>
            </section>
            <!--一个折叠后的项目以上-->

            <!--一个展开后的项目-->
            <section class="contentDetailExpanded" style="display: none">
                <div class="logoCurrentTriangle"></div>
                <h1></h1>
                <h2></h2>
                <p></p>
                <button type="button">
                    <div></div>
                    <div style="padding:0;margin-left:0.1rem;width:1px;height:0.6rem;background:#EE1438;"></div>
                    <div>详情</div>
                </button>
            </section>
            <!--一个展开后的项目以上-->
        </section>

    </section>
    <!--主内容区左边以上-->

    <!--主内容区右边-->
    <section class="contentLogo">

        <project id="project">
            <!--一个项目-->
            <figure class="figureSelect">
                <div class="logoPic"><img src="" width=100% height=100%></div>
                <figcaption>
                    <div class="logoCurrentSquare" style="visibility: hidden"></div>
                    <p><span class="title"></span><span class="subTitle"></span></p>
                </figcaption>
            </figure>
            <div class="logoSeparator"></div>
            <!--一个项目以上-->
        </project>

    </section>
    <!--主内容区右边以上-->

</section>
<!--主内容区以上-->

<section class="submit" style="display: none">
    <button>我要融资</button>
</section>
</body>

<script type="text/javascript" src="js/jquery-2.2.2.min.js"></script>
<script type="text/javascript" src="js/jweixin-1.0.0.js"></script>
<script type="text/javascript"
        src="js/util.js?v=<%= getFileTime(application.getRealPath("view/js/util.js")) %>"></script>
<script type="text/javascript"
        src="js/index.js?v=<%= getFileTime(application.getRealPath("view/js/index.js")) %>"></script>
</html>
