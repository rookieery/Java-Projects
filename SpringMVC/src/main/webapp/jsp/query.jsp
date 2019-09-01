<%--
  Created by IntelliJ IDEA.
  User: VULCAN
  Date: 2019/8/30
  Time: 11:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>

<html>
<head>
</head>
<body>
hello
${list}
<c:forEach items="${list}" var="user" varStatus="s">
   <tr>
      <td><input type="checkbox"></td>
      <td>${user.id}</td>
      <td>${user.username}</td>
      <td>${user.birthday}</td>
      <td>${user.sex}</td>
      <td>${user.address}</td>
   </tr>
</c:forEach>
</body>
</html>
