<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <a href="/userservlet">Danh sách User</a>
    <h1>Cập nhật tài khoản</h1>
    <c:if test="${requestScope['message']==2}">
        <p class="alert alert-success">Xảy ra lỗi!</p>
    </c:if>
    <c:if test="${requestScope['message']==1}">
        <p class="alert alert-success"> Thành công!</p>
    </c:if>
    <form action="/userservlet?action=edit&id=${requestScope['user'].getId()}" method="post">
        <div class="mb-3">
            <label for="exampleInputPassword1" class="form-label">Tên tài khoản:</label>
            <input type="text" class="form-control" id="exampleInputPassword1" name="username" value="${requestScope['user'].getUsername()}">
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">Mật khẩu:</label>
            <input type="text" class="form-control" id="password" name="password" value="${requestScope['user'].getPassword()}">
        </div>
        <div class="mb-3">
            <label for="fullName" class="form-label">Full name:</label>
            <input type="text" class="form-control" id="fullName" name="fullName" value="${requestScope['user'].getFullName()}">
        </div>
        <div class="mb-3">
            <label for="role" class="form-label">Role:</label>
            <input type="text" class="form-control" id="role" name="role" value="${requestScope['user'].isRole()}">
        </div>
        <div class="mb-3">
            <label for="email" class="form-label">Email:</label>
            <input type="text" class="form-control" id="email" name="email" value="${requestScope['user'].getEmail()}">
        </div>
        <div class="mb-3">
            <label for="img" class="form-label">Image:</label>
            <input type="text" class="form-control" id="img" name="img" value="${requestScope['user'].getImg()}">
        </div>
        <div class="mb-3">
            <label for="address" class="form-label">Address:</label>
            <input type="text" class="form-control" id="address" name="address" value="${requestScope['user'].getAddress()}">
        </div>
        <div class="mb-3">
            <label for="phone" class="form-label">Phone:</label>
            <input type="text" class="form-control" id="phone" name="phone" value="${requestScope['user'].getPhone()}">
        </div>
        <button type="submit" class="btn btn-primary">Cập nhật</button>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>