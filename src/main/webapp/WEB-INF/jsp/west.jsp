
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<style type="text/css">
    .menu-last {
        margin-bottom: 5px;
    }
</style>
<body>
<div class="easyui-accordion" style="width:auto;border: 0px;">
    <ul id="menu" class="easyui-tree" style="margin-top: 10px;margin-left: 5px;">
        <li>
            <span>个人相关操作</span>
            <%--<ul>
                <li data-options="attributes:{'url':'tp_1_manage'}">课题管理</li>
                <li>
                    <span>课题相关查询</span>
                    <ul>
                        <li data-options="attributes:{'url':'tp_2_defenseGroup'}">答辩分组查询</li>
                        <li data-options="attributes:{'url':'tp_1_myStudent'}">我的学生名单</li>
                    </ul>
                </li>
                <li>
                    <span>课题相关填写</span>
                    <ul>
                        <li data-options="attributes:{'url':''}">填报设计成绩</li>
                        <li data-options="attributes:{'url':'tp_3_answerPT'}">答疑时间和地点设置</li>
                    </ul>
                </li>
            </ul>--%>
            <ul>
               <%-- <li data-options="attributes:{'url':'personInfo'}">个人信息查看</li>--%>
                 <%-- /加上这个符号代表从 根工程访问--%>
                <li data-options="attributes:{'url':'/personInfo'}">个人信息查看</li>
                <li data-options="attributes:{'url':'/per_password_change'}">个人密码修改</li>
                <shiro:hasRole name="2">
                <li>个人课表</li>
                </shiro:hasRole>
            </ul>
        </li>
        <shiro:hasPermission name="score:*">
        <li>
            <span>成绩管理</span>
            <ul>
                <li>班级成绩导入</li>
                <li>班级成绩查看</li>
            </ul>
        </li>
        </shiro:hasPermission>
        <shiro:hasRole name="2">
        <li>
            <span>选课管理</span>
            <ul>
                <li>课程添加</li>
                <li>选课信息查看</li>
            </ul>
        </li>
        </shiro:hasRole>
        <shiro:hasPermission name="manage:*">
        <li>
            <span>高级管理</span>
            <ul>
                <li>教师管理</li>
                <li data-options="attributes:{'url':'/stu_manage'}">学生管理</li>
                <li>课程管理</li>
                <li data-options="attributes:{'url':'/score_manage'}">成绩管理</li>
                <li>选课管理</li>
            </ul>
        </li>
        </shiro:hasPermission>
        <shiro:hasRole  name="1">
        <li>
            <span>系统管理</span>
            <ul>
                <li data-options="attributes:{'url':'/sys_directory'}">字典管理</li>
                <li>学生信息导入</li>
                <li>老师信息导入</li>
                <li data-options="attributes:{'url':'/sys_notice'}">通知管理</li>
            </ul>
        </li></shiro:hasRole>
        <%--<li>
            <span>个人相关操作</span>
            <ul>
                <li>
                    <span>个人信息管理</span>
                    <ul>
                        <li data-options="attributes:{'url':'personalInfo'}">个人信息</li>
                        <li data-options="attributes:{'url':'personalPass'}">密码修改</li>
                    </ul>
                </li>
                <li>
                    <span>邮件管理</span>
                    <ul>
                        <li data-options="attributes:{'url':'per_mail_message'}">给同学留言</li>
                        <li data-options="attributes:{'url':''}">收件箱</li>
                        <li data-options="attributes:{'url':''}">发件箱</li>
                    </ul>
                </li>
            </ul>
        </li>
        <shiro:hasPermission name="advance:*">
            <li>
                <span>高级管理</span>
                <ul>
                    <li>
                        <span>查询统计相关</span>
                        <ul>
                            <li data-options="attributes:{'url':'adv_select_selectedTopic'}">课题选择情况</li>
                            <li data-options="attributes:{'url':'adv_select_passedTopic'}">教师课题统计</li>
                            <li data-options="attributes:{'url':'adv_select_timeAndPlace'}">指导时间和地点统计</li>
                            <li data-options="attributes:{'url':'adv_select_research'}">结合科研实际统计</li>
                            <li data-options="attributes:{'url':''}">未选题情况统计</li>
                            <li data-options="attributes:{'url':''}">教师被选课题统计</li>
                            <li data-options="attributes:{'url':''}">毕业设计情况汇总</li>
                        </ul>
                    </li>
                    <shiro:hasPermission name="notice:*">
                        <li data-options="attributes:{'url':'adv_notice'}">通知管理</li>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="topic:*">
                        <li data-options="attributes:{'url':''}">课题审核</li>
                    </shiro:hasPermission>
                </ul>
            </li>
        </shiro:hasPermission>
        <shiro:hasPermission name="system:*">
            <li>
                <span>系统管理</span>
                <ul>
                    <shiro:hasPermission name="systemddl:*">
                        <li data-options="attributes:{'url':'sys_directory'}">字典管理</li>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="role:*">
                        <li data-options="attributes:{'url':'sys_role'}">角色管理</li>
                    </shiro:hasPermission>
                    <li data-options="attributes:{'url':'sys_year'}">年度设置</li>
                    <li data-options="attributes:{'url':'sys_chooseTime'}">选课题时间设置</li>
                    <li data-options="attributes:{'url':''}">已选课题管理</li>
                    <shiro:hasPermission name="user:*">
                        <li>
                            <span>用户管理</span>
                            <ul>
                                <li data-options="attributes:{'url':'sys_user_teacher'}">教师管理</li>
                                <li data-options="attributes:{'url':'sys_user_student'}">学生管理</li>
                            </ul>
                        </li>
                    </shiro:hasPermission>
                </ul>
            </li>
        </shiro:hasPermission>--%>
    </ul>
</div>

<script type="text/javascript">
   /* $(function(){ }  这是jquery里的,是当文档载入完毕就执行,的意思.*/
    $(function(){
        $('#menu').tree({
            onClick: function(node){
                if($('#menu').tree("isLeaf",node.target)){
                    if ($('#tt').tabs('exists', node.text)){
                        $('#tt').tabs('select', node.text);
                    } else {
                        var content = '<iframe scrolling="auto" frameborder="0"  src="'+node.attributes.url+'" style="width:100%;height:100%;"></iframe>';
                        $('#tt').tabs('add',{
                            title:node.text,
                            content:content,
                            closable:true
                        });
                    }
                }
            }
        });
    });
</script>
</body>
