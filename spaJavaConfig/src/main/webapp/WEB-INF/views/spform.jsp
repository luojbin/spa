<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
  <title>spring form taglib</title>
</head>
<body>

<h1>Register</h1>

<sf:form method="POST" commandName="spitter">
  <sf:errors path="*" element="div" cssClass="errors"/>
  <sf:label path="firstName"
            cssErrorClass="error">First Name</sf:label>:
  <sf:input path="firstName" cssErrorClass="error"/><br/>
  <sf:label path="lastName"
            cssErrorClass="error">Last Name</sf:label>:
  <sf:input path="lastName" cssErrorClass="error"/><br/>
  <sf:label path="email"
            cssErrorClass="error">Email</sf:label>:
  <sf:input path="email" cssErrorClass="error"/><br/>
  <sf:label path="username"
            cssErrorClass="error">Username</sf:label>:
  <sf:input path="username" cssErrorClass="error"/><br/>
  <sf:label path="password"
            cssErrorClass="error">Password</sf:label>:
  <sf:password path="password" cssErrorClass="error"/><br/>
  <input type="submit" value="Register"/>
</sf:form>

<div id="hello">
  <div class="good"></div>
  <div id="world">
    <world></world>
  </div>
</div>

</body>
</html>
