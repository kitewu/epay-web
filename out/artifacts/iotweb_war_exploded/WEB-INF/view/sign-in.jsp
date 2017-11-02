<%--
  Created by IntelliJ IDEA.
  User: WSL
  Date: 2017/7/16
  Time: 13:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign In</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <script type="application/x-javascript"> addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);
    function hideURLbar() {
        window.scrollTo(0, 1);
    } </script>
    <link href="../../source/css/bootstrap.min.css" rel='stylesheet' type='text/css'/>
    <link href="../../source/css/style.css" rel='stylesheet' type='text/css'/>
    <link href="../../source/css/font-awesome.css" rel="stylesheet">
    <link rel="stylesheet" href="../../source/css/icon-font.min.css" type='text/css'/>
    <script src="../../source/js/Chart.js"></script>
    <link href="../../source/css/animate.css" rel="stylesheet" type="text/css" media="all">
    <script src="../../source/js/wow.min.js"></script>
    <script>
        new WOW().init();
    </script>
    <script src="../../source/js/jquery-1.10.2.min.js"></script>
</head>

<body class="sign-in-up">
<section>
    <div id="page-wrapper" class="sign-in-wrapper">
        <div class="graphs">
            <div class="sign-in-form">
                <div class="sign-in-form-top">
                    <p><span>Sign In to</span> <a href="/">Admin</a></p>
                </div>
                <div class="signin">

                    <div class="log-input">
                        <div class="log-input-left">
                            <input type="text" class="user" value="Yourname" name="uid" onfocus="this.value = '';"
                                   onblur="if (this.value == '') {this.value = 'Email address:';}"/>
                        </div>
                        <span class="checkbox2"> <label class="checkbox"><input type="checkbox" name="checkbox"
                                                                                checked=""/><i> </i></label> </span>
                        <div class="clearfix">
                        </div>
                    </div>
                    <div class="log-input">
                        <div class="log-input-left">
                            <input type="password" class="lock" name="passwd" value="password"
                                   onfocus="this.value = '';"
                                   onblur="if (this.value == '') {this.value = 'Email address:';}"/>
                        </div>
                        <span class="checkbox2"> <label class="checkbox"><input type="checkbox" name="checkbox"
                                                                                checked=""/><i> </i></label> </span>
                        <div class="clearfix">
                        </div>
                    </div>
                    <input type="submit" onclick="Checklogin()" value="确定"/>
                </div>
            </div>
        </div>
    </div>
    <%@ include file="footer.jsp" %>
</section>
<script>
    function Checklogin() {
        window.location.href = 'storestatus';
    }
</script>
<script src="../../source/js/jquery.nicescroll.js"></script>
<script src="../../source/js/scripts.js"></script>
<script src="../../source/js/bootstrap.min.js"></script>
</body>
</html>