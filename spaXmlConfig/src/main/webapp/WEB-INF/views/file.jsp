<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
  <title>文件上传</title>
  <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />">
</head>
<body>
<h1> 文件上传测试 </h1>

<div>
  <form method="post" enctype="multipart/form-data" action="<c:url value="/file/uploadToByte"/>">
    备注说明:<input type="text" name="msg"/><br/>
    上传人:<input type="text" name="uploader"/><br/>
    选择文件: <input type="file" name="file">
    <input type="submit" value="作为 byte[] 提交"/>
  </form>

  <form method="post" enctype="multipart/form-data" action="<c:url value="/file/uploadToMp"/>">
    备注说明:<input type="text" name="msg"/><br/>
    上传人:<input type="text" name="uploader"/><br/>
    选择文件: <input type="file" name="file">
    <input type="submit" value="作为 multipartFile 提交"/>
  </form>
  <form method="post" enctype="multipart/form-data" action="<c:url value="/file/uploadToPart"/>">
    备注说明:<input type="text" name="msg"/><br/>
    上传人:<input type="text" name="uploader"/><br/>
    选择文件: <input type="file" name="file">
    <input type="submit" value="作为 part 提交"/>
  </form>

</div>
</body>
</html>
