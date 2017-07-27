<%--
  Created by IntelliJ IDEA.
  User: ningning.jiang
  Date: 2017/6/23
  Time: 8:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!doctype html>
<html>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <script type="text/javascript" src="${pageContext.request.contextPath }/resource/jquery/jquery-3.2.1.min.js"></script>
    <title>SpringDemo Title</title>
</head>
<body>
<script type="text/javascript">
    $(function () {
        window.location.href = "${pageContext.request.contextPath }/login";
    });
</script>
</body>
</html>