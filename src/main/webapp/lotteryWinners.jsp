<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lottery Winners</title>
</head>
<body>
    <h1>Lottery Winners</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>User ID</th>
            <th>Lottery Winner ID</th>
            <th>Winnings</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${winners}" var="winner">
            <tr>
                <td>${winner.id}</td>
                <td>${winner.userId}</td>
                <td>${winner.lotteryWinnerId}</td>
                <td>${winner.winnings}</td>
                <td>
                    <a href="lotteryWinner?action=update&id=${winner.id}">Update</a>
                    <a href="lotteryWinner?action=delete&id=${winner.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <a href="lotteryWinner?action=create">Create New Winner</a>
</body>
</html>
