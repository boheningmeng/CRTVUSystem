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
    <script type="text/javascript" src="/ui/bssys.js"></script>
</head>
<body>

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
            <th field="voGrade" width="50">年级</th>
            <th field="sex" width="50">性别</th>
            <th field="voIsChoose" width="50">是否选课</th>

        </tr>
        </thead>
    </table>
</div>
<div id="toolbar">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newStu()">新建</a>
</div>

<div id="stuDialog" class="easyui-dialog" style="width: 500px;height: 550px;padding: 10px 20px"
     closed="true" buttons="#stuForm-buttons">
    <div class="ftitle">学生信息</div>
    <form id="fm" method="post">
        <div class="fitem">
            <label>年级&nbsp;&nbsp;&nbsp;</label><div>&nbsp;</div>
            <input name="grade"
                   class="easyui-combobox"
                   <%--textField和valueField看到的表示出来的值（界面上），和内里的值--%>
                   data-options="
                           valueField:'ddlcode',
                           textField:'ddlname',
                           width:300,
                           url:'${pageContext.request.contextPath}/systemddl/list/grade'" />
        </div><br/>
        <div class="fitem">
            <label>专业名称&nbsp;&nbsp;&nbsp;</label><div>&nbsp;</div>
            <input name="major"
                   class="easyui-combobox"
                   data-options="
                           valueField:'ddlcode',
                           textField:'ddlname',
                           width:300,
                           url:'${pageContext.request.contextPath}/systemddl/list/major'" />
        </div><br/>
        <div class="fitem">
            <label>入学时间&nbsp;&nbsp;&nbsp;</label><div>&nbsp;</div>
            <input name="Entime"
                   class="easyui-combobox"
                   data-options="
                           valueField:'ddlcode',
                           textField:'ddlname',
                           width:300,
                           url:'${pageContext.request.contextPath}/systemddl/list/Entime'" />
        </div><br/>
        <div class="fitem">
            <label>班级&nbsp;&nbsp;&nbsp;</label><div>&nbsp;</div>
            <input name="clazzid"
                   class="easyui-combobox"
                   data-options="
                           valueField:'id',
                           textField:'name',
                           width:300,
                           url:'${pageContext.request.contextPath}/clazz/getList'" />
        </div><br/>
        <div class="fitem">
            <label>学号&nbsp;&nbsp;&nbsp;</label>
            <input name="number" class="easyui-validatebox">
        </div>
        <br/>
        <div class="fitem">
            <label>姓名&nbsp;&nbsp;&nbsp;</label>
            <input name="name" class="easyui-validatebox">
        </div>
        <br/>
        <%--<div class="fitem">
            <label>年级&nbsp;&nbsp;&nbsp;</label>
            <input name="grade" class="easyui-validatebox">
        </div>--%>
        <br/>
        <div class="fitem">
            <label>性别&nbsp;&nbsp;&nbsp;</label>
            <input name="sex" class="easyui-validatebox">
        </div>

        <div class="fitem">
            <label>邮箱&nbsp;&nbsp;&nbsp;</label>
            <input name="email" class="easyui-validatebox">
        </div>
        <br/>
        <div class="fitem">
            <label>手机号&nbsp;&nbsp;&nbsp;</label>
            <input name="phone" class="easyui-validatebox">
        </div>
        <br/>
        <%--<div class="fitem">--%>
            <%--<label>特长&nbsp;&nbsp;&nbsp;</label>--%>
            <%--<textarea name="strongpoint" class="textareaComment" placeholder="200字以内"></textarea>--%>
        <%--</div>--%>
    </form>
</div>
<div id="stuForm-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveStu()">保存</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel"
       onclick="javascript:$('#stuDialog').dialog('close')">取消</a>
</div>

</body>
</html>
