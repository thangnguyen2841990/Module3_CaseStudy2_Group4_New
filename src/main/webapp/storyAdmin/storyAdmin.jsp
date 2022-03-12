<%--
  Created by IntelliJ IDEA.
  User: MSI
  Date: 11-Mar-22
  Time: 10:04 AM
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
            <th>Id</th>
            <th>CategoryName</th>
            <th>Image</th>
            <th>Name</th>
            <th>Price</th>
            <th>Author</th>
            <th>Date Submitted</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${requestScope['listStory']}" var="story">
            <tr>
                <td>${story.id}</td>
                <td>${story.categoryName}</td>
                <td>
                    <img src="${story.img}">
                </td>
                <td>
                    <a href="/partadmins?action=viewPart&id=${story.id}">
                        ${story.name}
                    </a>
                </td>
                <td>${story.price}</td>
                <td>${story.writer}</td>
                <td>${story.dateSubmited}</td>
                <td>
                    <a href="/partadmins?action=updatePart&id=${story.id}">Update</a>
                    <a href="/partadmins?action=deletePart&id=${story.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
