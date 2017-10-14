
function endEditing(){
    if (editIndex == undefined){return true}
    if ($('#dg').datagrid('validateRow', editIndex)){
        var ed = $('#dg').datagrid('getEditor', {index:editIndex,field:'productid'});
        var productname = $(ed.target).combobox('getText');
        $('#dg').datagrid('getRows')[editIndex]['productname'] = productname;
        $('#dg').datagrid('endEdit', editIndex);
        editIndex = undefined;
        return true;
    } else {
        return false;
    }
}
function onClickRow(index){
    if (editIndex != index){
        if (endEditing()){
            $('#dg').datagrid('selectRow', index)
                .datagrid('beginEdit', index);
            editIndex = index;
        } else {
            $('#dg').datagrid('selectRow', editIndex);
        }
    }
}
function append(){
    if (endEditing()){
        $('#dg').datagrid('appendRow',{status:'P'});
        editIndex = $('#dg').datagrid('getRows').length-1;
        $('#dg').datagrid('selectRow', editIndex)
            .datagrid('beginEdit', editIndex);
    }
}
function removeit(){
    if (editIndex == undefined){return}
    $('#dg').datagrid('cancelEdit', editIndex)
        .datagrid('deleteRow', editIndex);
    editIndex = undefined;
}
function accept(){
    if (endEditing()){
        $('#dg').datagrid('acceptChanges');
    }
}
function reject(){
    $('#dg').datagrid('rejectChanges');
    editIndex = undefined;
}
function getChanges(){
    var rows = $('#dg').datagrid('getChanges');
    alert(rows.length+' rows are changed!');
}

function logout() {
    $.get("/user/logout", null, function (res){
        window.location.href = "/login";
    })
}

function newStu(){
    $("#fm").form("clear");
    $("#stuDialog").dialog("open").dialog("setTitle","学生管理-新建");
    url="/student/addition";
}
/*
function login(){
    $("#fm").form("submit",{
        url:"/user/login",
        success:function(res){
            window.location.href = res;
        }
    })
}
*/
function editStu(){
    var row = $("#dg").datagrid("getSelected");
    if(row){
        $("#stuDialog").dialog("open").dialog("setTitle","学生管理--编辑");
        $("fm").form("clear");
        $("fm").form("load",row);
        url = "/student/update"+row.sid;
    }
}

function destoryStu(){
    var row = $("#dg").dialog("getSelected");
    if(row){
        $.message.conirm("confirm","确定要删除这条记录吗",function(r){
            if(r){

            }
        })
    }
}

function readNotice(){
    var row = $("#dg").datagrid("getSelected");
    if(row){
        $("#read_noticeDialog").dialog("open").dialog("setTitile",row.title);
        $("#notice_content").html(row.content);
        $("#notice_footer").html("发布人: "+row.publisher+"  发布日期: "+row.date);
    }
}
function newNotice(){
    $("#fm").form("clear");
    $("#noticeDialog").dialog("open").dialog("setTitle","通知管理——新建");
    url = "/notice/addition";
}