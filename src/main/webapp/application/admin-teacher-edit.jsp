<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/19
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="<%=request.getContextPath()+"/"%>"/>
    <link href="static/css/H-ui.min.css" rel="stylesheet" type="text/css"/>
    <link href="static/css/H-ui.admin.css" rel="stylesheet" type="text/css"/>
    <link href="static/lib/icheck/icheck.css" rel="stylesheet" type="text/css"/>
    <link href="static/lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css"/>
    <link href="static/lib/zTree/v3/css/zTreeStyle/zTreeStyle.css" type="text/css" rel="stylesheet" />
</head>
<body>
<div class="pd-20">
    <form action="" method="post" class="form form-horizontal" id="form-teacher-edit">
        <input type="hidden" name="id" value="${teacher.id}">
        <div class="row cl">
            <label class="form-label col-3"><span class="c-red">*</span>老师姓名：</label>
            <div class="formControls col-5">
                <input type="text" class="input-text" placeholder="" id="tName" name="tName"
                       datatype="*1-8" nullmsg="老师名不能为空" value="${teacher.tName}">
            </div>
            <div class="col-4"></div>
        </div>
        <div class="row cl">
            <label class="form-label col-3"><span class="c-red">*</span>老师密码：</label>
            <div class="formControls col-5">
                <input type="text" class="input-text" placeholder="" id="tPassword" name="tPassword"
                       datatype="*1-8" nullmsg="老师密码不能为空" value="${teacher.tPassword}">
            </div>
            <div class="col-4"></div>
        </div>
        <div class="row cl">
            <div class="col-9 col-offset-3">
                <input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
            </div>
        </div>
    </form>
</div>

<script type="text/javascript" src="static/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="static/lib/icheck/jquery.icheck.min.js"></script>
<script type="text/javascript" src="static/lib/Validform/5.3.2/Validform.min.js"></script>
<script type="text/javascript" src="static/lib/layer/1.9.3/layer.js"></script>
<script type="text/javascript" src="static/js/H-ui.js"></script>
<script type="text/javascript" src="static/js/H-ui.admin.js"></script>
<script src="static/lib/zTree/v3/js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript">
    $(function () {
        $('.skin-minimal input').iCheck({
            checkboxClass: 'icheckbox-blue',
            radioClass: 'iradio-blue',
            increaseArea: '20%'
        });

        $("#form-teacher-edit").Validform({
            tiptype: 2,
            callback: function (form) {
                //表单验证通过后，点击添加才会进入这个方法
                $.ajax({
                    url: "teacher/update",
                    type: "POST",
                    data: $("#form-teacher-edit").serialize(),
                    success: function (data) {
                        // alert(data.data);
                        var icon;
                        if (data.result) {
                            icon = 6;
                        } else {
                            icon = 5;
                        }
                        layer.alert(data.data, {icon: icon}, function () {
                            /*关闭弹出框*/
                            var index = parent.layer.getFrameIndex(window.name);
                            parent.$('.btn-refresh').click();
                            parent.layer.close(index);
                            parent.location.reload();
                        });
                    }
                });
                return false;
            }
        });
    });

</script>
</body>
</html>
