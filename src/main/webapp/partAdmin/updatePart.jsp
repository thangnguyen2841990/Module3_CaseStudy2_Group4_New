<%--
  Created by IntelliJ IDEA.
  User: MSI
  Date: 11-Mar-22
  Time: 11:16 AM
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
            <td>StoryId</td>
            <td>
                <input type="text" name="storyId" value="${requestScope['part'].getStoryID()}">
            </td>
        </tr>
        <tr>
            <td>CategoryId</td>
            <td>
                <input type="text" name="categoryId" value="${requestScope['part'].getCategoryId()}">
            </td>
        </tr>
        <tr>
            <td>Episode</td>
            <td>
                <input type="text" name="episode" value="${requestScope['part'].getEpisode()}">
            </td>
        </tr>
        <tr>
            <td>Name</td>
            <td>
                <input type="text" name="name" value="${requestScope['part'].getName()}">
            </td>
        </tr>
        <tr>
            <td>Content</td>
            <td>
                <input type="text" name="content" value="${requestScope['part'].getContent()}">
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <button>Update</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
