<%--
  Created by IntelliJ IDEA.
  User: luojbin
  Date: 2021/3/25
  Time: 22:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>登录</title>
</head>
<body>
<div id="header"></div>

<div id="content">

    <form name='f' action='/login' method='POST'>
        <table>
            <tr><td>User:</td><td>
                <input type='text' name='username' value='' /></td></tr>
            <tr><td>Password:</td>
                <td><input type='password' name='password'/></td></tr>
            <tr><td colspan='2'>
                <input id="remember_me" name="remember-me" type="checkbox"/>
                <label for="remember_me" class="inline">Remember me</label></td></tr>
            <tr><td colspan='2'>
                <input name="submit" type="submit" value="Login"/></td></tr>
        </table>
    </form>
</div>
</body>
</html>
