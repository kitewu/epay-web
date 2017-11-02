<%--
  Created by IntelliJ IDEA.
  User: WSL
  Date: 2017/7/21
  Time: 12:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>历史纪录</title>
    <link href="css/bootstrap-table.css" rel="stylesheet">
    <link href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="css/styles.css" rel="stylesheet">
</head>
<body>
<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-body">
                    <div>
                        <table id="TABLES" data-toggle="table" data-show-refresh="true"
                               data-url="/back/getbuyhistory" data-show-toggle="true"
                               data-show-columns="true"
                               data-select-item-name="toolbar1" data-pagination="true" data-sort-name="name"
                               data-sort-order="desc">
                            <thead>
                            <tr>
                                <th data-field="id" data-sortable="true">编号</th>
                                <th data-field="commodity_id" data-sortable="true">商品名称</th>
                                <th data-field="store_id" data-sortable="true">购买店铺</th>
                                <th data-field="buy_date" data-sortable="true">购买时间</th>
                                <th data-field="price" data-sortable="true">价格</th>
                            </tr>
                            </thead>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="../../source/js/bootstrap-table.js"></script>
<script>
    window.onload = function () {
        ChangePage();
    };	//网页载入时触发
    function ChangePage() {
        $('#TABLES').bootstrapTable('refresh', {url: "/back/getbuyhistory"});
    }
</script>
</body>
</html>