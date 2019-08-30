<%--
  Created by IntelliJ IDEA.
  User: VULCAN
  Date: 2019/8/14
  Time: 9:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
</head>
<body>
    <form id="form" action="${pageContext.request.contextPath}/batchUpdateSubmit" method="post">
        <table width="100%" border="1">
            <tr>
                <td>
                    <input type="submit" value="批量更新">
                </td>
            </tr>
        </table>
        <table border="1" class="table table-bordered table-hover">
            <tr>
                <th>编号</th>
                <th>姓名</th>
                <th>生日</th>
                <th>性别</th>
                <th>地址</th>
            </tr>

            <c:forEach items="${userListKey}" var="user" varStatus="status">
                <tr>
                    <td><input type="text" name="List[${status.index}].id" value="${user.id}" readonly="true"> </td>
                    <td><input type="text" name="List[${status.index}].name" value="${user.username}"> </td>
                    <td><input type="text" name="List[${status.index}].birthday" value="${user.birthday}"></td>
                    <td><input type="text" name="List[${status.index}].sex" value="${user.sex}"></td>
                    <td><input type="text" name="List[${status.index}].address" value="${user.address}"></td>
                </tr>

            </c:forEach>


        </table>
    </form>



</body>
</html>

