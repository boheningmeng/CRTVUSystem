<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2017/10/8
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--先给这个页面分div层--%>
<div style=" width:900px;height:auto;margin:0 auto">
    <div class="messager-body" style="width: auto;height:auto;margin:0 auto">
        <div class ="messager-info" style="height:56px;margin: 10px;">
            <p  align="center" style="font-size: 16px">
                <label for="number">工&nbsp;号 :</label>
                <input id="number" readonly="readonly" value="${globleUser.number}" class="easyui-text" style="width: 300px;height: 32px">
            </p>
        </div>
        <div class ="messager-info" style="height:56px;margin: 10px;">
            <p  align="center" style="font-size: 20px">
                <label for="username">姓&nbsp;名 :</label>
                <input id="username" readonly="readonly" value="${globleUser.username}" class="easyui-text" style="width: 300px;height: 32px">
            </p>
        </div>
        <div class ="messager-info" style="height:56px;margin: 10px;">
            <p  align="center" style="font-size: 20px">
                <label for="phone">手机号 :</label>
                <input id="phone" readonly="readonly" value="${globleUser.phone}" class="easyui-text" style="width: 300px;height: 32px">
            </p>
        </div>
        <div class ="messager-info" style="height:56px;margin: 10px;">
            <p  align="center" style="font-size: 20px">
                <label for="email">邮&nbsp;箱:</label>
                <input id="email" readonly="readonly" value="${globleUser.email}" class="easyui-text" style="width: 300px;height: 32px">
            </p>
        </div>
        <div class ="messager-info" style="height:56px;margin: 10px;">
            <p  align="center" style="font-size: 20px">
                <label for="rolename">职&nbsp;称 :</label>
                <input id="rolename" readonly="readonly" value="${globleUser.rolename}" class="easyui-text" style="width: 300px;height: 32px">
            </p>
        </div>

    </div>
</div>
</body>
</html>
