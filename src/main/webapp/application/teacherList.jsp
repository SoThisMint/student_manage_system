<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/2
  Time: 20:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="<%=request.getContextPath()+"/"%>" />
    <link href="static/css/H-ui.min.css" rel="stylesheet" type="text/css" />
    <link href="static/css/H-ui.login.css" rel="stylesheet" type="text/css" />
    <link href="static/css/style.css" rel="stylesheet" type="text/css" />
    <link href="static/lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
</head>
<body>
<table class="table table-border table-bordered table-hover table-bg">
    <thead>
        <tr>
            <th scope="col" colspan="7">老师信息</th>
        </tr>
        <tr class="text-c">
            <th width="80">老师姓名</th>
        </tr>
    </thead>
    <tbody>
        <tr class="text-c">
            <td>${teacher.tName}</td>
        </tr>
    </tbody>
</table>
<button class="btn btn-primary radius" onclick="showStus()">老师列表管理</button>

<div class="cl pd-5 bg-1 bk-gray"><span class="l"> <a href="javascript:;" onclick="batchDelete()"
                                                      class="btn btn-danger radius"><i
        class="Hui-iconfont">&#xe6e2;</i> 批量删除</a> <a class="btn btn-primary radius" href="javascript:;"
                                                      onclick="admin_teacher_add('添加老师','application/admin-teacher-add.jsp','800','500')"><i
        class="Hui-iconfont">&#xe600;</i> 添加老师</a> </span>
</div>
<table class="table table-border table-bordered table-hover table-bg" id="teacherBody">
    <thead>
    <tr>
        <th scope="col" colspan="7">老师列表管理</th>
    </tr>
    <tr class="text-c">
        <th width="25"><input type="checkbox" value="全选" name=""></th>
        <th width="40">老师姓名</th>
        <th width="70">操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${teacherList}" var="teacher">
        <tr class="text-c">
            <td><input type="checkbox" class="delBox" name="" value="${teacher.id}"></td>
            <td>${teacher.tName}</td>
            <td class="f-14">
                <a title="编辑" href="javascript:;" onclick="admin_teacher_edit('老师编辑','teacher/toUpdate/${teacher.id}','800','500')"
                   style="text-decoration:none">
                    <i class="Hui-iconfont">&#xe6df;</i></a>
                <a title="删除" href="javascript:;" onclick="admin_teacher_del(this,${teacher.id})" class="ml-5"
                   style="text-decoration:none">
                    <i class="Hui-iconfont">&#xe6e2;</i></a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<script src="static/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="static/lib/layer/1.9.3/layer.js"></script>
<script type="text/javascript" src="static/lib/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="static/js/H-ui.js"></script>
<script type="text/javascript" src="static/js/H-ui.admin.js"></script>
<script>
    // $("#teacherBody").hide();
    // function showStus() {
    //     $("#teacherBody").show();
    // }

    function admin_teacher_del(obj, id) {
        layer.confirm('角色删除须谨慎，确认要删除吗？', function (index) {
            //此处请求后台程序，下方是成功后的前台处理……
            $.ajax({
                url: "teacher/delete",
                type: "POST",
                data: {"id": id},
                success: function (data) {
                    if (data.result) {
                        $(obj).parents("tr").remove();
                        layer.msg(data.data, {icon: 1, time: 0.001}, function () {
                            location.reload();
                        });
                    } else {
                        layer.msg(data.data, {icon: 2, time: 1000});
                    }
                }
            })
        });
    }

    /*管理员-老师-添加*/
    function admin_teacher_add(title, url, w, h) {
        layer_show(title, url, w, h);
    }

    /*管理员-老师-编辑*/
    function admin_teacher_edit(title, url, id, w, h) {
        layer_show(title, url, w, h);
    }

    //批量删除
    function batchDelete() {
        var obj = $(".delBox:checked");
        if (obj == null) {
            layer.msg("请选中要删除的数据！", {icon: 2, time: 2000});
            return;
        }
        var ids = [];
        for (var i = 0; i < obj.length; i++) {
            ids.push(obj[i].value);
        }
        $.ajax({
            url: "teacher/batchDelete",
            type: "POST",
            data: "ids=" + ids,
            success: function (data) {
                if (data.result) {
                    layer.msg(data.data, {icon: 1, time: 0.001}, function () {
                        location.reload();
                    });
                } else {
                    layer.msg(data.data, {icon: 2, time: 1000});
                }
            }
        })
    }
</script>
</body>
</html>
