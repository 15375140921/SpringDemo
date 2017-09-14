<%--
  Created by IntelliJ IDEA.
  User: ningning.jiang
  Date: 2017/7/7
  Time: 8:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ include file="/resource/global.jsp" %>
<!doctype html>
<html>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Title</title>
</head>
<body>
    This is notice page.
    <shiro:hasRole name="admin">
        <p>admin-Role</p>
    </shiro:hasRole>
    <shiro:hasPermission name="admin:manage">
        <p>admin:manage-Permission</p>
    </shiro:hasPermission>
    <shiro:hasRole name="teaManage">
        <p>teaManage-Role</p>
    </shiro:hasRole>
    <shiro:hasRole name="tea">
        <p>tea-Role</p>
    </shiro:hasRole>
    <shiro:hasPermission name="tea">
        <p>tea-Permission</p>
    </shiro:hasPermission>
    <shiro:hasRole name="stu">
        <p>stu-Role</p>
    </shiro:hasRole>
    <shiro:hasPermission name="tea:manage">
        <p>tea:manage-Permission</p>
    </shiro:hasPermission>
    <shiro:hasPermission name="tea:update">
        <p>tea:update-Permission</p>
    </shiro:hasPermission>
</body>
</html>