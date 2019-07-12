<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
  <title>Spitter</title>
</head>
<body>
<h1>Hello world! the first spittle</h1>

<div class="spittleView">
  <div class="spittleMessage">
    <c:out value="${spittle.message}" />
  </div>
  <div class="spittleTime" >
    <c:out value="${spittle.time}" />
  </div>
</div>

</body>
</html>
