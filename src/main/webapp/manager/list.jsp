<%--
  Created by IntelliJ IDEA.
  User: tubac
  Date: 10/03/2022
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <!-- Tempusdominus Bootstrap 4 -->
    <link rel="stylesheet" href="../plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css">
    <!-- iCheck -->
    <link rel="stylesheet" href="../plugins/icheck-bootstrap/icheck-bootstrap.min.css">
    <!-- JQVMap -->
    <link rel="stylesheet" href="../plugins/jqvmap/jqvmap.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="../dist/css/adminlte.min.css">
    <!-- overlayScrollbars -->
    <link rel="stylesheet" href="../plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
    <!-- Daterange picker -->
    <link rel="stylesheet" href="../plugins/daterangepicker/daterangepicker.css">
    <!-- summernote -->
    <link rel="stylesheet" href="../plugins/summernote/summernote-bs4.min.css">
</head>

<style>
    th{
        text-align: center;
    }
</style>
<body>

<div class = "wrapper">

    <aside class="main-sidebar sidebar-dark-primary elevation-4">
        <!-- Brand Logo -->
        <a href="index3.html" class="brand-link">
            <img src="../dist/img/AdminLTELogo.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3" style="opacity: .8">
            <span class="brand-text font-weight-light">Admin System</span>
        </a>

        <!-- Sidebar -->
        <div class="sidebar">
            <!-- Sidebar user panel (optional) -->
            <div class="user-panel mt-3 pb-3 mb-3 d-flex">
                <div class="image">
                    <img src="../dist/img/user2-160x160.jpg" class="img-circle elevation-2" alt="User Image">
                </div>
                <div class="info">
                    <a href="#" class="d-block">Alexander Pierce</a>
                </div>
            </div>

            <!-- SidebarSearch Form -->
            <div class="form-inline">
                <form action="stories">
                    <div class="input-group" data-widget="sidebar-search">
                        <input class="form-control form-control-sidebar" name="q" type="search" placeholder="Search" aria-label="Search">
                        <div class="input-group-append">
                            <button class="btn btn-sidebar">
                                <i class="fas fa-search fa-fw">Tìm Kiếm</i>
                            </button>
                        </div>
                    </div>
                </form>
            </div>

            <!-- Sidebar Menu -->
            <nav class="mt-2">
                <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
                    <!-- Add icons to the links using the .nav-icon class
                         with font-awesome or any other icon font library -->
                    <li class="nav-item">
                        <a href="stories" class="nav-link">
                            <i class="nav-icon fas fa-th"></i>
                            <p>
                                Quản Lý Danh Sách
                            </p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="categories" class="nav-link">
                            <i class="nav-icon fas fa-th"></i>
                            <p>
                                Quản Lý Danh Mục
                            </p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="stories?action=create" class="nav-link">
                            <i class="nav-icon fas fa-th"></i>
                            <p>
                                Tạo Tác Phẩm Mới
                            </p>
                        </a>
                    </li>
                </ul>
            </nav>
            <!-- /.sidebar-menu -->
        </div>
        <!-- /.sidebar -->
    </aside>
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <!-- /.content-header -->

        <!-- Main content -->
        <section class="content">
            <div class="container-fluid">
                <h1>DANH SÁCH CÁC lOẠI TRUYỆN</h1>
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th scope="col">STT</th>
                        <th scope="col">Tên Sách</th>
                        <th scope="col">Loại Giá</th>
                        <th scope="col">Tác Giả</th>
                        <th scope="col">Ngày Đăng</th>
                        <th scope="col">Hình Ảnh</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="story" varStatus="loop" items="${stories}">
                        <tr>
                            <td>${loop.count}</td>
                            <td><a href="/stories?action=view&id=${story.id}">${story.name}</a></td>
                            <td>${story.price}</td>
                            <td>${story.writer}</td>
                            <td>${story.dateSubmited}</td>
                            <td>${story.img}</td>

                            <td>
                                <a class="btn btn-info" href="stories?action=edit&id=${story.id}">SỬA<i class="fa fa-edit"></i></a>
                            </td>
                            <td><a class="btn btn-danger" href="stories?action=delete&id=${story.id}">XÓA<i class="fa fa-trash"></i></a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div><!-- /.container-fluid -->
        </section>
        <!-- /.content -->
    </div>

</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</body>
</html>