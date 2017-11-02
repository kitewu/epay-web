<%--
  Created by IntelliJ IDEA.
  User: WSL
  Date: 2017/7/16
  Time: 12:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="left-side sticky-left-side">
    <div class="logo">
        <h1><a href="/storestatus">Admin</a></h1>
    </div>
    <div class="logo-icon text-center">
        <a href="/storestatus"><i class="lnr lnr-home"></i> </a>
    </div>
    <div class="left-side-inner">
        <ul class="nav nav-pills nav-stacked custom-nav">
            <li class="active"><a href="/storestatus"><i class="lnr lnr-power-switch"></i><span>商店管理</span></a>
                <ul class="sub-menu-list">
                    <li><a href="/storestatus">状态</a></li>
                    <li><a href="/storelist">所有商店</a></li>
                    <li><a href="/addstore">添加新商店</a></li>
                </ul>
            </li>

            <li class="menu-list"><a href="#"><i class="lnr lnr-cog"></i> <span>商品管理</span></a>
                <ul class="sub-menu-list">
                    <li><a href="addcommo">添加商品</a></li>
                    <li><a href="commolist">所有商品</a></li>
                </ul>
            </li>

            <li><a href="/history"><i class="lnr lnr-menu"></i> <span>购买记录</span></a></li>

            <li><a href="addstore.jsp"><i class="lnr lnr-spell-check"></i> <span>销售情况</span></a>
                <ul class="sub-menu-list">
                    <li><a href="grids.html">销售量</a></li>
                    <li><a href="widgets.html">销售额</a></li>
                    <li><a href="widgets.html">趋势</a></li>
                </ul>
            </li>

            <li class="menu-list"><a href="#"><i class="lnr lnr-book"></i> <span>Pages</span></a>
                <ul class="sub-menu-list">
                    <li><a href="signup">注册</a></li>
                    <li><a href="logout">注销</a></li>
                </ul>
            </li>


            <%--<li class="menu-list"><a href="#"><i class="lnr lnr-envelope"></i> <span>MailBox</span></a>--%>
            <%--<ul class="sub-menu-list">--%>
            <%--<li><a href="inbox.html">Inbox</a></li>--%>
            <%--<li><a href="compose-mail.html">Compose Mail</a></li>--%>
            <%--</ul>--%>
            <%--</li>--%>

            <%--<li class="menu-list"><a href="#"><i class="lnr lnr-indent-increase"></i> <span>Menu Levels</span></a>--%>
            <%--<ul class="sub-menu-list">--%>
            <%--<li><a href="charts.html">Basic Charts</a></li>--%>
            <%--</ul>--%>
            <%--</li>--%>

            <%--<li><a href="codes.html"><i class="lnr lnr-pencil"></i> <span>Typography</span></a></li>--%>

            <%--<li><a href="media.html"><i class="lnr lnr-select"></i> <span>Media Css</span></a></li>--%>

        </ul>
    </div>
</div>
