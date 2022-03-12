<%--
  Created by IntelliJ IDEA.
  User: MSI
  Date: 12-Mar-22
  Time: 10:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
<table>
    <tr>
        <td>Image link</td>
        <td>Action</td>
    </tr>

        <c:forEach items="${requestScope['listImage']}" var="image">
    <tr>
            <td>
                <input type="text" value="${image.img}" name="img">
            </td>
        <td><a href="">
            <button>Sua</button></a>
            <a href="/partadmins?action=deleteImg&id=${image.id}">
                <button>Xoa</button></a>
        </td>
    </tr>



        </c:forEach>

    <tr>
        <td>
            <button>Confirm</button></td>

    </tr>
</table>
</form>
</body>
</html>
