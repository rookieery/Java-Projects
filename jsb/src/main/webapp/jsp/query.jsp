<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: VULCAN
  Date: 2019/8/15
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<html>
<head>
    <title>查询列表</title>
</head>
<body>
<table border="1" class="table table-bordered table-hover">
    <tr class="success">
        <th><input type="checkbox"></th>
        <th>编号</th>
        <th>姓名</th>
        <th>生日</th>
        <th>性别</th>
        <th>地址</th>
    </tr>

    <c:forEach items="${userListKey}" var="user" varStatus="s">
        <tr>
            <td><input type="checkbox"></td>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.birthday}</td>
            <td>${user.sex}</td>
            <td>${user.address}</td>
            <td><a class="btn btn-default btn-sm" >修改</a>&nbsp;
                <a class="btn btn-default btn-sm" >删除</a></td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
