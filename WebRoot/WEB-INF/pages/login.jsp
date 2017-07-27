<%--
  Created by IntelliJ IDEA.
  User: ningning.jiang
  Date: 2017/6/30
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="form" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!doctype html>
<html>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Title</title>
    <%@include file="/resource/must_js.jsp"%>
</head>
<body>
    <form id="form" action="${pageContext.request.contextPath }/login" method="post">
        <label for="username">用户名:</label><input type="text" id="username" name="username">
        <label for="password">密码:</label><input type="password" id="password" name="password">
        <br>
        <input type="checkbox" id="rememberMe" name="rememberMe" value="true"><label for="rememberMe">记住我</label>
        <%--<button type="button" ></button>--%>
        <input type="button" id="submitButton" value="提交">
        <c:if test="${msg != '' && msg != null}">
            <br>
            <span id="errorMsg" style="color: red">${msg}</span>
        </c:if>
        <br>
        <input id="button1" type="button" class="button" value="button1">
        <input type="button" class="button" value="button2">
        <input type="button" class="button" value="button3">
    </form>

    <script type="text/javascript">
    $(function () {
        $("#submitButton").click(function () {
            debugger;
            $("form").submit();
        });

        $("form").on("click", "form .button", function () {
            alert("button");
        });

        var $button1 = $("#button1");

        $button1.on("click.namespace1", function () {
            alert(1);
        });

        $button1.off("click.namespace2");

        $button1.on("click.namespace2", function () {
            alert(2);
        });



    })
    </script>
</body>
</html>