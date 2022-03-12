<%--
  Created by IntelliJ IDEA.
  User: MSI
  Date: 11-Mar-22
  Time: 9:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <tr>
            <th>ID</th>
            <th>StoryID</th>
            <th>CategoryID</th>
            <th>Episode</th>
            <th>Name</th>
            <th>Content</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${requestScope['listPart']}" var="part">
            <tr>
                <td>${part.id}</td>
                <td>${part.storyID}</td>
                <td>${part.categoryId}</td>
                <td>${part.episode}</td>
                <td>${part.name}</td>
                <td>${part.content}</td>
                <td>
                    <a href="/partadmins?action=update&id=${part.id}&categoryId=${part.categoryId}&storyId=${part.storyID}">Sửa</a>
                    <a href="/partadmins?action=delete&id=${part.id}">Xóa</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
