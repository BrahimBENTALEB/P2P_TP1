<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lotteries</title>
</head>
<body>
    <h1>Lotteries</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Lottery Name</th>
            <th>Start Date</th>
            <th>End Date</th>
            <th>Winning Numbers</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${lotteries}" var="lottery">
            <tr>
                <td>${lottery.id}</td>
                <td>${lottery.lotteryName}</td>
                <td>${lottery.startDate}</td>
                <td>${lottery.endDate}</td>
                <td>${lottery.winningNumbers}</td>
                <td>
                    <a href="lottery?action=update&id=${lottery.id}">Update</a>
                    <a href="lottery?action=delete&id=${lottery.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <a href="lottery?action=create">Create New Lottery</a>
</body>
</html>
