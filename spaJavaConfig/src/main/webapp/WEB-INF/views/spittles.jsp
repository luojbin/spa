<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
  <title>Spitter</title>
</head>
<body>
<h1>Recent Spittles</h1>

<c:forEach items="${spittleList}" var="spittle">
  <li id="spittle_<c:out value="spittle.id"/>">
    <div class="spittleMessage">
      <c:out value="${spittle.message}"/>
    </div>
    <div>
      <span class="spittleTime"><c:out value="${spittle.time}"/></span>
      <span class="spittleLocation">
        (<c:out value="${spittle.latitude}"/>, <c:out value="${spittle.longitude}"/>)
      </span>
    </div>
  </li>
</c:forEach>

</body>
</html>
