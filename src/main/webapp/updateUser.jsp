<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update User</title>
</head>
<body>
    <h1>Update User</h1>
    <form action="user" method="post">
        <input type="hidden" name="action" value="update">
        <input type="hidden" name="id" value="${user.id}">
        Name: <input type="text" name="name" value="${user.name}"><br>
        Email: <input type="email" name="email" value="${user.email}"><br>
        Password: <input type="password" name="password" value="${user.password}"><br>
        <input type="submit" value="Update">
    </form>
</body>
</html>
