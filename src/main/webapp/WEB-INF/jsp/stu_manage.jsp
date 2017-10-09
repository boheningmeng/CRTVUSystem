<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2017/10/9
  Time: 9:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/ui/themes/bootstrap/easyui.css">
    <link rel="stylesheet" type="text/css" href="/ui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="/ui/demo/demo.css">
    <link rel="stylesheet" type="text/css" href="/ui/bssys.css">
    <script type="text/javascript" src="/ui/jquery.min.js"></script>
    <script type="text/javascript" src="/ui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/ui/crtvus.js"></script>
</head>
<body>
<%--<div align="center">
      <table id="dg" title="学生列表" class="easyui-datagrid" style="width:100%;height:auto"
      fitColumns="true" singleSelect="true" pagination="true"
      data-options="rownumbers:true,
       url:'/student/manage',
       method:'get',
       pageSize:15,
       pageList:[5,10,15,20,25]">
          <thead>
          <tr>
              <th filed="number" width="50">学号</th>
              <th filed="name" width="30">姓名</th>
              <th filed="sex" width="26">性别</th>
              <th filed="voGrade" width="50">年级</th>
              <th filed="voClazz" width="50">班级</th>
              <th filed="voMajor" width="50">专业</th>
              <th filed="voEntime" width="50">入学时间</th>
              <th filed="voIschoose" width="50">是否选课</th>
              <th filed="email" width="50">电子邮件</th>
              <th filed="phone" width="50">电话号码</th>

          </tr>
          </thead>
      </table>
</div>--%>
<div align="center">
    <table id="dg" title="学生列表" class="easyui-datagrid" style="width: 100%;height:auto"
           toolbar="#toolbar"
           fitColumns="true" singleSelect="true" pagination="true"
           data-options="rownumbers:true,
            url:'/student/list',
            method:'get',
            pageSize:15,
            pageList:[5,10,15,20,25]">
        <thead>
        <tr>
            <th field="voMajor" width="50">专业</th>
            <th field="voClazz" width="50">班级</th>
            <th field="number" width="50">学号</th>
            <th field="name" width="50">姓名</th>
            <th field="grade" width="50">年级</th>
            <th field="sex" width="50">性别</th>
            <th field="voIsChoose" width="50">是否选课</th>

        </tr>
        </thead>
    </table>
</div>
</body>
</html>
