<%--
  Created by IntelliJ IDEA.
  User: WSL
  Date: 2017/7/16
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Store List</title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <script type="application/x-javascript"> addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);
    function hideURLbar() {
        window.scrollTo(0, 1);
    } </script>
    <link href="../../source/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="../../source/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="../../source/css/font-awesome.css" rel="stylesheet"/>
    <link rel="stylesheet" href="../../source/css/icon-font.min.css" type="text/css"/>
    <script src="../../source/js/Chart.js"></script>
    <link href="../../source/css/animate.css" rel="stylesheet" type="text/css" media="all"/>
    <script> new WOW().init(); </script>
    <script src="../../source/js/jquery-1.10.2.min.js"></script>
    <link href="../../source/css/bootstrap-table.css" rel="stylesheet">
</head>

<body class="sticky-header left-side-collapsed" onload="initMap()">
<section>
    <%@ include file="menu.jsp" %>
    <div class="main-content">
        <%@ include file="header.jsp" %>
        <div id="page-wrapper">
            <h3 class="blank1">所有商店</h3>
            <div class="col-sm-offset-3 col-lg-10 col-lg-offset-1 main">
                <div class="row">
                    <div class="col-lg-15">
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <div>
                                    <table id="TABLES" data-toggle="table" data-show-refresh="true"
                                           data-url="/back/getallstorejson" data-show-toggle="true"
                                           data-show-columns="true"
                                           data-select-item-name="toolbar1" data-pagination="true" data-sort-name="name"
                                           data-sort-order="desc">
                                        <thead>
                                        <tr>
                                            <th data-field="id" data-sortable="true">编号</th>
                                            <th data-field="location" data-sortable="true">位置</th>
                                            <th data-field="if_use" data-sortable="true">正常使用</th>
                                            <th data-field="aff" data-sortable="true">店铺详情</th>
                                        </tr>
                                        </thead>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<script src="../../source/js/jquery.nicescroll.js"></script>
<script src="../../source/js/scripts.js"></script>
<script src="../../source/js/bootstrap.min.js"></script>
<script src="../../source/js/bootstrap-table.js"></script>
<script>
    window.onload = function () {
        ChangePage();
    };	//网页载入时触发
    function ChangePage() {
        $('#TABLES').bootstrapTable('refresh', {url: "/back/getallstorejson"});
    }
</script>
</body>
</html>