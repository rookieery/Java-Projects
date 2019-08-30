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
    <script>
        function deleteUser(id) {
            //用户安全提示
            if (confirm("您确定要删除吗？")) {
                //访问路径
                location.href = "${pageContext.request.contextPath}/delUserServlet?id=" + id;
            }
        }

        function updateUser(id) {
            if (confirm("您确定要修改吗？")) {
                location.href = "${pageContext.request.contextPath}/findUserServlet?id=" + id;
            }
        }

        window.onload = function () {
            document.getElementById("batchUpdate").onclick = function () {
                location.href = "${pageContext.request.contextPath}/batchUpdate";
            }

            document.getElementById("delSelected").onclick = function () {
                if (confirm("您确定要全部删除吗？ ")) {
                    var flag = false;
                    var cbs = document.getElementsByName("ids");
                    for (var i = 0; i < cbs.length; i++) {
                        if (cbs[i].checked) {
                            flag = true;
                            break
                        }
                    }
                    if (flag) {
                        document.getElementById("form").submit();
                    }
                }
            }
            document.getElementById("firstCb").onclick = function () {
                var cbs = document.getElementsByName("ids");
                for (var i = 0; i < cbs.length; i++) {
                    cbs[i].checked = this.checked;
                }
            }
        }
    </script>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">用户信息列表</h3>

    <div style="float: left;">

        <form action="${pageContext.request.contextPath}/SelectedUserServlet" method="post" class="form-inline">
            <div class="form-group">
                <label for="exampleInputName2">编号</label>
                <input type="text" class="form-control" id="exampleInputName2" name="id" >
            </div>
            <div class="form-group">
                <label for="exampleInputName3">姓名</label>
                <input type="text" class="form-control" id="exampleInputName3" name="name">
            </div>
            <div class="form-group">
                <label for="exampleInputName4">生日</label>
                <input type="text" class="form-control" id="exampleInputName4" name="birthday">
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>

    </div>

    <div style="float: right;margin: 5px;">

        <a class="btn btn-primary" href="${pageContext.request.contextPath}/jsp/add.jsp">添加联系人</a>
        <a class="btn btn-primary" href="javascript:void(0);" id="delSelected">删除选中</a>
        <a class="btn btn-primary" href="javascript:void(0);" id="batchUpdate">批量修改</a>

    </div>
    <form id="form" action="${pageContext.request.contextPath}/delSelectedServlet" method="post">
        <table border="1" class="table table-bordered table-hover">
            <tr class="success">
                <th><input type="checkbox" id="firstCb"></th>
                <th>编号</th>
                <th>姓名</th>
                <th>生日</th>
                <th>性别</th>
                <th>地址</th>
                <th>操作</th>
            </tr>

            <c:forEach items="${userListKey}" var="user" varStatus="s">
                <tr>
                    <td><input type="checkbox" name="ids" value="${user.id}"></td>
                    <td>${user.id}</td>
                    <td>${user.username}</td>
                    <td>${user.birthday}</td>
                    <td>${user.sex}</td>
                    <td>${user.address}</td>
                    <td><a class="btn btn-default btn-sm"
                           href="${pageContext.request.contextPath}/findUserServlet?id=${user.id}">修改</a>&nbsp;
                        <a class="btn btn-default btn-sm" href="javascript:deleteUser(${user.id})">删除</a></td>
                </tr>

            </c:forEach>


        </table>
    </form>

    <div>
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <li>
                    <a href="#" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <li><a href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li>
                    <a href="#" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
                <span style="font-size: 25px;margin-left: 5px;">
                    共16条记录，共4页
                </span>

            </ul>
        </nav>


    </div>


</div>


</body>
</html>

