<%--
  Created by IntelliJ IDEA.
  User: WSL
  Date: 2017/7/16
  Time: 11:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Store Detail</title>
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
    <!--菜单栏-->
    <%@ include file="menu.jsp" %>
    <!-- main content start-->
    <div class="main-content">
        <%@ include file="header.jsp" %>

        <div id="page-wrapper">
            <div class="graphs">
                <h3 class="blank1">商店详情</h3>
                <div class="col_3">
                    <div class="col-md-3 widget widget1">
                        <div class="r3_counter_box">
                            <i class="fa fa-mail-forward"></i>
                            <div class="stats">
                                <h5>${TotalNum} <span>件</span></h5>
                                <div class="grow">
                                    <p>总销售量</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3 widget widget1">
                        <div class="r3_counter_box">
                            <i class="fa fa-usd"></i>
                            <div class="stats">
                                <h5>${TotalSales}<span>元</span></h5>
                                <div class="grow grow1">
                                    <p>总销售额</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3 widget widget1">
                        <div class="r3_counter_box">
                            <i class="fa fa-users"></i>
                            <div class="stats">
                                <h5>${TotalCustomers} <span>人</span></h5>
                                <div class="grow grow3">
                                    <p>总客户量</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3 widget">
                        <div class="r3_counter_box">
                            <i class="fa fa-eye"></i>
                            <div class="stats">
                                <h5>${LeftNum} <span>件</span></h5>
                                <div class="grow grow2">
                                    <p>剩余商品数</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="clearfix">
                    </div>
                </div>
            </div>

            <br/>
            <br/>
            <div class="graphs">
                <div class="graph_box1">
                    <div class="col-md-6 grid_2 grid_2_bot">
                        <div class="grid_1">
                            <h4>总销售量</h4>
                            <canvas id="line1" height="100" width="600" style="width: 600px; height: 100px;"></canvas>
                            <script>
                                var lineChartData = {
                                    labels: ["Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Mon"],
                                    datasets: [
                                        {
                                            fillColor: "#fff",
                                            strokeColor: "#F44336",
                                            pointColor: "#fbfbfb",
                                            pointStrokeColor: "#F44336",
                                            data: [20, 35, 45, 30, 10, 65, 40]
                                        }
                                    ]

                                };
                                new Chart(document.getElementById("line1").getContext("2d")).Line(lineChartData);
                            </script>
                        </div>
                        <div class="line-bottom-grid">
                            <div class="grid_1">
                                <h4>总销售额</h4>
                                <canvas id="bar1" height="100" width="600"
                                        style="width: 600px; height: 100px;"></canvas>
                                <script>
                                    var barChartData = {
                                        labels: ["Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Mon", "Tue", "Wed", "Thu"],
                                        datasets: [
                                            {
                                                fillColor: "#8BC34A",
                                                strokeColor: "#8BC34A",
                                                data: [25, 40, 50, 65, 55, 30, 20, 10, 6, 4]
                                            },
                                            {
                                                fillColor: "#8BC34A",
                                                strokeColor: "#8BC34A",
                                                data: [30, 45, 55, 70, 40, 25, 15, 8, 5, 2]
                                            }
                                        ]

                                    };
                                    new Chart(document.getElementById("bar1").getContext("2d")).Bar(barChartData);
                                </script>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 grid_2 grid_2_bot">
                        <div class="grid_1">
                            <h4>剩余商品数</h4>
                            <canvas id="line2" height="75" width="600" style="width: 600px; height: 100px;"></canvas>
                            <script>
                                var lineChartData = {
                                    labels: ["Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Mon"],
                                    datasets: [
                                        {
                                            fillColor: "#fff",
                                            strokeColor: "#F44336",
                                            pointColor: "#fbfbfb",
                                            pointStrokeColor: "#F44336",
                                            data: [20, 35, 45, 30, 10, 65, 40]
                                        }
                                    ]

                                };
                                new Chart(document.getElementById("line2").getContext("2d")).Line(lineChartData);
                            </script>
                        </div>
                        <div class="line-bottom-grid">
                            <div class="grid_1">
                                <h4>Bar</h4>
                                <canvas id="bar2" height="75" width="600"
                                        style="width: 600px; height: 100px;"></canvas>
                                <script>
                                    var barChartData = {
                                        labels: ["Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Mon", "Tue", "Wed", "Thu"],
                                        datasets: [
                                            {
                                                fillColor: "#8BC34A",
                                                strokeColor: "#8BC34A",
                                                data: [25, 40, 50, 65, 55, 30, 20, 10, 6, 4]
                                            },
                                            {
                                                fillColor: "#8BC34A",
                                                strokeColor: "#8BC34A",
                                                data: [30, 45, 55, 70, 40, 25, 15, 8, 5, 2]
                                            }
                                        ]

                                    };
                                    new Chart(document.getElementById("bar2").getContext("2d")).Bar(barChartData);
                                </script>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
    <%@ include file="footer.jsp" %>
</section>
<script src="../../source/js/jquery.nicescroll.js"></script>
<script src="../../source/js/scripts.js"></script>
<script src="../../source/js/bootstrap.min.js"></script>
</body>
</html>
