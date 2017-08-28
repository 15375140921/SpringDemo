<%--
  Created by IntelliJ IDEA.
  User: ningning.jiang
  Date: 2017/7/6
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Title</title>
    <%@include file="/resource/must_js.jsp" %>
    <%@include file="/resource/global.jsp"%>
</head>
<body>
    This is index page!
    <br>
    当前用户：<shiro:principal/>
    <br>
    <a href="${pageContext.request.contextPath}/admin">admin可以访问的页面</a>
    <br>
    <a href="${pageContext.request.contextPath}/teaManage">teaManage可以访问的页面</a>
    <br>
    <a href="${pageContext.request.contextPath}/tea">tea可以访问的页面</a>
    <br>
    <a href="${pageContext.request.contextPath}/stu">stu可以访问的页面</a>
    <br>
    <a href="${pageContext.request.contextPath}/notice">公告</a>
    <br>
    <a href="${pageContext.request.contextPath}/loginOut">退出</a>
    <br>
    <input type="text" onkeyup="keyUp(this);" title="请输入内容">
    <script type="text/javascript"  >
        function keyUp(obj) {
            var c=$(obj);
            if(/[^\d]/.test(c.val())){//替换非数字字符
                var temp_amount=c.val().replace(/[^\d]/g,'');
                c.val(temp_amount);
            }
        }
    </script>
</body>
</html>