<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2017/10/18
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="valueField" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/ui/themes/bootstrap/easyui.css">
    <link rel="stylesheet" type="text/css" href="/ui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="/ui/demo/demo.css">
    <link rel="stylesheet" type="text/css" href="/ui/bssys.css">
    <script type="text/javascript" src="/ui/jquery.min.js"></script>
    <script type="text/javascript" src="/ui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/ui/bssys.js"></script>
</head>
<body>

<div align="center">
    <table id="dg" title="成绩列表" class="easyui-datagrid" style="width: 100%;height:auto"
           toolbar="#toolbar"
           fitColumns="true" singleSelect="true" pagination="true"
           data-options="rownumbers:true,
            url:'/score/list',
            method:'get',
            pageSize:15,
            pageList:[5,10,15,20,25]">
        <thead>
        <tr>
            <th field="clazz" width="50">班级</th>
            <th field="number" width="50">学号</th>
            <th field="name" width="50">姓名</th>
            <th field="courseName" width="50">学科</th>
            <th field="score" width="50">成绩</th>
            <th field="courseCredit" width="50">学分</th>
            <th field="courseLearnTime" width="50">学时</th>

        </tr>
        </thead>
    </table>
</div>
<div id="toolbar">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newScore()">新建</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editScore()">编辑</a>
    <%--<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyScore()">删除</a>--%>
    <label>按年级查询</label>
    <input id="studentInput"
           name="grade"
           class="easyui-combobox"
           data-options="
                           valueField:'ddlcode',
                           textField:'ddlname',
                           width:300,
                           url:'${pageContext.request.contextPath}/systemddl/list/grade'" />
</div>

<div id="scoreDialog" class="easyui-dialog" style="width: 500px;height: 550px;padding: 10px 20px"
     closed="true" buttons="#stuForm-buttons">
    <div class="ftitle">学生信息</div>
    <form id="fm" method="post">
       <%-- <div class="fitem">
            <label>班级&nbsp;&nbsp;&nbsp;</label><div>&nbsp;</div>
            <input name="clazz"
                   class="easyui-combobox"
            &lt;%&ndash;textField和valueField看到的表示出来的值（界面上），和内里的值&ndash;%&gt;
                   data-options="
                           valueField:'clazz',
                           textField:'ddlname',
                           width:300,
                           url:'${pageContext.request.contextPath}/systemddl/list/grade'" />
        </div><br/>--%>

        <div class="fitem">
            <label>学科&nbsp;&nbsp;&nbsp;</label><div>&nbsp;</div>
            <input name="courseid"
                   class="easyui-combobox"
                   data-options="
                           valueField:'id',
                           textField:'name',
                           width:300,
                           url:'${pageContext.request.contextPath}/course/list/name'" />
        </div><br/>
           <div class="fitem">
               <label>成绩&nbsp;&nbsp;&nbsp;</label>
               <input name="score" class="easyui-validatebox">
           </div>
           <br/>

           <div class="fitem">
            <label>学号&nbsp;&nbsp;&nbsp;</label>
            <input name="number" class="easyui-validatebox">
        </div>
        <br/>


    </form>
</div>
<div id="stuForm-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveScore()">保存</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel"
       onclick="javascript:$('#scoreDialog').dialog('close')">取消</a>
</div>
<div>
    <form id="dfm" method="post">
        <input type="hidden" name="_method" value="DELETE">
    </form>
</div>
</body>
</html>
