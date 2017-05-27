<%--
  Created by IntelliJ IDEA.
  User: jiangchangwei
  Date: 2017/5/24
  Time: 下午3:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://" + request.getServerName() + ":" + request.getServerPort()+ path + "/";
    System.out.println(basePath);
%>
<html>
<head>
    <title>Title</title>
    <script src= "<%= basePath%>resources/js/jquery-3.2.1.js" type="text/javascript"></script>
    <script src="<%= basePath%>resources/js/list.js" type="text/javascript"></script>
    <script type="text/javascript">
        function deleteBatch1(basePath) {
            const path = basePath + "DeleteBatchServlet.action";
            // document.getElementById("mainForm").setAttribute("action", path);
            // document.getElementById("mainForm")
            // console.log(path);
            // console.log($("#mainForm").attr("action"));
            $("#mainForm").attr("action", path);
            // console.log($("#mainForm").attr("action"));
            $("#mainForm").submit();
        }
    </script>
</head>
<body>
<h1>显示的内容</h1>
<hr>
<div style="float: left;">
    <a href="#">新增</a>&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="javascript:deleteBatch1('<%= basePath%>');" >删除</a>
    <%--<a href="<%= basePath%>DeleteBatchServlet.action">删除</a>--%>
</div>
<br>
<form action="<%=basePath%>List.action" method="post" id="mainForm" name="mainForm">
<div>
    <table>
        <tr>
            <td>指令名称：</td>
            <td><input type="text" name="command" value=""></td>
            <td>描述：</td>
            <td><input name="description" type="text" value=""></td>
            <td><input type="submit" value="提交" name="submit"></td>
        </tr>
    </table>
</div>

    <div style="align-items: center;">
        <table>
            <tr>
                <th><input type="checkbox" id="all" onclick="" /></th>
                <th>序号</th>
                <th>指令名称</th>
                <th>描述</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${messageList}" var="message" varStatus="status">
                <tr <c:if test="${status.index % 2 != 0}">style="background-color:#ECF6EE"</c:if>>
                    <td><input type="checkbox" name="id" value="${message.id}"></td>
                    <td>${status.index + 1}</td>
                    <td>${message.command}</td>
                    <td>${message.description}</td>
                    <td>
                        <a href="#">修改</a>&nbsp;&nbsp;&nbsp;
                        <a href="/DeleteOneServlet.action?id=${message.id}">删除></a>
                    </td>

                </tr>
            </c:forEach>
        </table>
    </div>
</form>
</body>
</html>
