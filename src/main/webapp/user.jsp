<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User List</title>
</head>
<body>
    <h1>User List</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Password</th>
            <th>Action</th>
        </tr>
        <!-- <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.email}</td>
                <td>${user.password}</td>
                <td>
                    <a href="user?action=update&id=${user.id}">Update</a>
                    <a href="user?action=delete&id=${user.id}">Delete</a>
                </td>
            </tr>
        </c:forEach> -->
    </table>
    <br>
    <a href="user?action=create">Create New User</a>
</body>
</html>
