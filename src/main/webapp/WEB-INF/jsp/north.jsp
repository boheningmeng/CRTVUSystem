
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
<div style="height:50px;text-align: center;font-family: 微软雅黑;font-size: 25px;" >
    <span style=" width: 300px;">
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;教务管理系统
    </span>
    <c:if test="${globleUser != null}">
        <span style="color: #000000;display:block; width: 20px; float:right; text-align:right;font-family: 微软雅黑;font-size: 16px;">
                &nbsp;&nbsp;
        </span>
        <span style="color: #000000;display:block; width: 300px; float:right; text-align:right;font-family: 微软雅黑;font-size: 16px;">
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;当前${globleUser.rolename}：&nbsp;&nbsp;&nbsp;&nbsp;${globleUser.username}&nbsp;&nbsp;&nbsp;&nbsp;
            <a class="easyui-linkbutton" iconCls="icon-no" style="width: 60px;height: 35px;" onclick="logout()">登出</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        </span>
    </c:if>
</div>
</body>
</html>
