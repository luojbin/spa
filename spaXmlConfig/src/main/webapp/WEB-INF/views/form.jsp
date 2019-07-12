<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>spittr 注册</title>
  <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />">
</head>
<body>
<h1>欢迎注册 spittr</h1>

<div>
  <form method="post">
    姓氏:<input type="text" name="firstName"/><br/>
    名字:<input type="text" name="lastName"/><br/>
    用户名:<input type="text" name="username"/><br/>
    密码:<input type="password" name="password"/><br/>
    <input type="submit" value="注册"/>
  </form>

  <h1>spring form taglib</h1>

  <sf:form method="POST" commandName="spitter">
    <sf:errors path="*" element="div" cssClass="errors"/>

    <sf:label path="firstName" cssErrorClass="error">First Name</sf:label>:
    <sf:input path="firstName" cssErrorClass="error"/><br/>

    <sf:label path="lastName" cssErrorClass="error">Last Name</sf:label>:
    <sf:input path="lastName" cssErrorClass="error"/><br/>

    <sf:label path="username" cssErrorClass="error">Username</sf:label>:
    <sf:input path="username" cssErrorClass="error"/><br/>

    <sf:label path="password" cssErrorClass="error">Password</sf:label>:
    <sf:password path="password" cssErrorClass="error"/><br/>

    <input type="submit" value="Register"/>
  </sf:form>
  <h1>spring form taglib</h1>

  <sf:form method="POST" commandName="spitter">
<%--    <sf:errors path="*" element="div" cssClass="errors"/>--%>

    <sf:label path="firstName" cssErrorClass="error">First Name</sf:label>:
    <sf:input path="firstName" cssErrorClass="error"/>
    <sf:errors path="firstName" cssClass="errors"/><br/>

    <sf:label path="lastName" cssErrorClass="error">Last Name</sf:label>:
    <sf:input path="lastName" cssErrorClass="error"/>
    <sf:errors path="lastName" cssClass="errors"/><br/>

    <sf:label path="username" cssErrorClass="error">Username</sf:label>:
    <sf:input path="username" cssErrorClass="error"/>
    <sf:errors path="username" cssClass="errors"/><br/>

    <sf:label path="password" cssErrorClass="error">Password</sf:label>:
    <sf:password path="password" cssErrorClass="error"/>
    <sf:errors path="password" cssClass="errors"/><br/>

    <input type="submit" value="Register"/>
  </sf:form>

</div>
</body>
</html>
