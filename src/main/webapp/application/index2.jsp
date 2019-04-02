<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/25
  Time: 10:24
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
<div class="layui-form">
    <table class="layui-table">
        <colgroup>
            <col width="150">
            <col width="150">
            <col width="200">
            <col>
        </colgroup>
        <thead>
            <tr>
                <th>老师姓名：</th>
                <th>年龄：</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>${teacher.tName}</td>
                <td>${teacher.tAge}</td>
                <td><button class="btn btn-primary radius">修改</button><button class="btn btn-danger radius">删除</button></td>
            </tr>
        </tbody>
    </table>
</div>

<script src="static/lib/jquery/1.9.1/jquery.min.js"></script>
<script>


</script>
</body>
</html>
