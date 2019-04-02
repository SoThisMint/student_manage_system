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
    <tr class="text-c">
        <td width="80">学生姓名:</td>
        <td>${student.sName}</td>
    </tr>
</table>
<button class="btn btn-primary radius" onclick="showTeachers()">学生管理</button>

<table class="table table-border table-bordered table-hover table-bg">
    <thead>
    <tr>
        <th scope="col" colspan="7">学生列表管理</th>
    </tr>
    <tr class="text-c">
        <th width="25"><input type="checkbox" value="" name=""></th>
        <th width="40">学生姓名</th>
        <th width="70">操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${studentList}" var="student">
        <tr class="text-c">
            <td><input type="checkbox" class="delBox" name="" value="${student.id}"></td>
            <td>${student.sName}</td>
            <td class="f-14">
                <a title="编辑" href="javascript:;" onclick="admin_role_edit('学生编辑','sysRole/toUpdate/${student.id}')"
                   style="text-decoration:none">
                    <i class="Hui-iconfont">&#xe6df;</i></a>
                <a title="删除" href="javascript:;" onclick="admin_role_del(this,${student.id})" class="ml-5"
                   style="text-decoration:none">
                    <i class="Hui-iconfont">&#xe6e2;</i></a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<script src="static/lib/jquery/1.9.1/jquery.min.js"></script>
<script>
    function showTeachers() {

    }
</script>
</body>
</html>
