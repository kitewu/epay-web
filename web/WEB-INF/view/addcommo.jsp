<%--
  Created by IntelliJ IDEA.
  User: WSL
  Date: 2017/7/16
  Time: 13:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Store</title>
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
    <script>
        new WOW().init();
    </script>
    <script src="../../source/js/jquery-1.10.2.min.js"></script>
</head>

<body class="sticky-header left-side-collapsed" onload="initMap()">
<section>
    <%@ include file="menu.jsp" %>
    <div class="main-content">
        <%@ include file="header.jsp" %>
        <div id="page-wrapper">
            <div class="graphs">
                <h3 class="blank1">添加商品</h3>
                <div class="tab-content">
                    <div class="tab-pane active" id="horizontal-form">
                        <form class="form-horizontal">
                            <div class="form-group">
                                <label for="commo_name" class="col-sm-2 control-label">商品名称</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control1" id="commo_name"
                                           placeholder="Default Input">
                                </div>
                            </div>
                        </form>
                        <form class="form-horizontal">
                            <div class="form-group">
                                <label for="price" class="col-sm-2 control-label">价格</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control1" id="price"
                                           placeholder="Default Input">
                                </div>
                            </div>
                        </form>
                        <form class="form-horizontal">
                            <div class="form-group">
                                <label for="rfid_number" class="col-sm-2 control-label">RFID码</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control1" id="rfid_number"
                                           placeholder="Default Input">
                                </div>
                            </div>
                        </form>
                        <form class="form-horizontal">
                            <div class="form-group">
                                <label for="store_id" class="col-sm-2 control-label">商店号</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control1" id="store_id"
                                           placeholder="Default Input">
                                </div>
                            </div>
                        </form>
                        <form class="form-horizontal">
                            <div class="form-group">
                                <label for="aff" class="col-sm-2 control-label">备注</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control1" id="aff"
                                           placeholder="Default Input">
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="panel-footer">
                        <div class="row">
                            <div class="col-sm-8 col-sm-offset-2">
                                <button class="btn-success btn" onclick="Submit()">Submit</button>
                                <button class="btn-inverse btn" onclick="Reset()">Reset</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<script>
    function Submit() {
        var commo_name = $("#commo_name").val();
        var price = $("#price").val();
        var rfid_number = $("#rfid_number").val();
        var store_id = $("#store_id").val();
        var aff = $("#aff").val();
        if ("" == commo_name || price == "" || rfid_number == "" || "" == store_id || aff == "") {
            alert("内容不能为空");
            return;
        }
        $.ajax({
            type: "post",
            url: '/addnewcommo',
            data: {commo_name: commo_name, price: price, rfid_number: rfid_number, store_id: store_id, aff: aff},
            success: function (data) {
                alert(data);
            }
        });
    }

    function Reset() {
        $("#address").val("");
        $("#is_use").val("");
        $("#aff").val("");
    }
</script>
<script src="../../source/js/jquery.nicescroll.js"></script>
<script src="../../source/js/scripts.js"></script>
<script src="../../source/js/bootstrap.min.js"></script>
</body>
</html>