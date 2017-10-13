<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2017/10/13
  Time: 18:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="/ui/js/jquery-3.1.1.min.js"></script>
    <script src="/ui/js/jquery-ui.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/ui/js/jquery-ui.min.css">
    <link rel="stylesheet" type="text/css" href="/ui/css/login.css">
</head>
<body>

    <div class="easyui-textbox" align="center" >
        <form id="ff" method="post" align="center">
            <table cellpadding="5">
                <tr>
                    <td>输入原密码:</td>
                    <td><input  class="easyui-textbox" type="text" name="oldpassword" data-options="required:true"></td>
                </tr>
                <tr>
                    <td>输入新密码:</td>
                    <td><input class="easyui-textbox" type="text" name="newpassword1"validType="length[4,32]" data-options="required:true'"></td>
                </tr>
                <tr>
                    <td>确认新密码:</td>
                    <td><input class="easyui-textbox" type="text" name="newpassword2" validType="equalTo['#password']" data-options="required:true"  invalidMessage="两次输入密码不匹配">
                    <span id="tishi"></span></td>
                </tr>
                <tr>
                    <td><input type="button" onclick="per_pass()" value="提交"> </td>
                </tr>
            </table>

        </form>
    </div>
   <%-- <div class="middle">
    <div class="m_main">
        <div class="title">修改密码</div>
        <input type="text" class="user_message user1" name="oldpassword">
        <label class="label l1">5-16位数字或字母</label>
        <div class="icon user_icon"></div>
        <input type="password" class="user_message user2" name="newpassword">
        <label class="label l2">5-16位数字或字母</label>
        <div class="icon pass_icon"></div>
        <input type="password" class="user_message user3" name="newpassword">
        <label class="label l3">与上次输入的密码一致</label>
        <div class="icon pass_icon2"></div>
        <input type="submit" disabled="disabled" value="提&nbsp&nbsp交" class="order submit">

        </form>
    </div>
    </div>
    <script type="text/javascript">
        $(function(){
            $(".middle").show("explode",1000);
            $(".f2").click(function(){
                $(".m1").hide("explode",1000);
                $(".m2").show();
            })
            $(".m2> .user_message").focus(function(){
                var a = $(this).index();
                if(a > 2){
                    a = Math.floor(a/2);
                }
                $(".m2> .label").eq(a-1).hide("slide",1000);
            })
            $(".m2> .user_message").blur(function(){
                var reg =/^[a-zA-Z0-9][a-zA-Z0-9]{4,16}$/;
                var a = $(this).index();
                if(a > 2){
                    a = Math.floor(a/2);
                }
                var b = 0;
                var c = 0;
                if(!reg.test($(this).val())) {
                    $(".m2> .label").eq(a-1).html("格式错误，请重新输入").show("slide",1000);
                }else{
                    b=1;
                }
                if(a == 3){
                    if($(".user3").val() != $(".user2").val()) {
                        $(".l3").html("密码不一致").show("slide",1000);
                    }else{
                        console.log($(".user3").val());
                        console.log($(".user2").val());
                        $(".l3").hide("slide",1000);
                        c=1;
                    }
                }
                console.log((b + c));
                if((b+c) == 2){
                    $(".m2 .submit").removeAttr("disabled","disabled");
                }
            })
            $(".m1 .user_message").blur(function(){
                if($(this).val() == ""){
                    var a = $(this).index();
                    if(a > 2){
                        a=a/2;
                    }
                    $(".m1 .submit").attr("disabled","disabled");
                    $(".label").eq(a-1).show("bounce",1000)
                }else{
                    $(".m1 .submit").removeAttr("disabled","disabled");
                    $(".label").eq(a-1).hide("bounce",1000)
                }
            })
            $(".m1 .user_message").focus(function(){
                var a = $(this).index();
                if(a > 2){
                    a=a/2;
                }
                $(".label").eq(a-1).hide("bounce",1000)
            })
        })
    </script>--%>
</body>
</html>
