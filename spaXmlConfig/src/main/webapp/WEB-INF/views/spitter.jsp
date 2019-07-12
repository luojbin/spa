<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
  <title>Spitter</title>
</head>
<body>
<h1>your profiles</h1>

    <c:out value="${spitter.username}"/> <br />
    <c:out value="${spitter.firstName}"/> <br />
    <c:out value="${spitter.lastName}"/><br />
</body>
</html>
