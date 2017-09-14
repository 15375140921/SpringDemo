<html>
<head>
    <title>Title</title>
</head>
<body>
<form id="form" action="" method="post">
    <p>${str}</p>

    <#list list as li>
        <table>
            <tr>
                <td>${li}</td>
            </tr>
        </table>
    </#list>

    <p>List中包含: <#list list as li>${li}<#sep>,</#list></p>

    <label for="username">用户名:</label><input type="text" id="username" name="username">
    <label for="password">密码:</label><input type="password" id="password" name="password">
    <br>
    <input type="checkbox" id="rememberMe" name="rememberMe" value="true"><label for="rememberMe">记住我</label>
    <input type="button" id="submitButton" value="提交">
<#--<c:if test="${msg != '' && msg != null}">
    <br>
    <span id="errorMsg" style="color: red">${msg}</span>
</c:if>-->
    <br>
    <input id="button1" type="button" class="button" value="button1">
    <input type="button" class="button" value="button2">
    <input type="button" class="button" value="button3">
</form>

</body>
</html>