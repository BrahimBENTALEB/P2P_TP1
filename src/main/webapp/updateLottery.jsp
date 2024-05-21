<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Lottery</title>
</head>
<body>
    <h1>Update Lottery</h1>
    <form action="lottery" method="post">
        <input type="hidden" name="action" value="update">
        <input type="hidden" name="id" value="${lottery.id}">
        Lottery Name: <input type="text" name="lottery_name" value="${lottery.lotteryName}"><br>
        Start Date: <input type="date" name="start_date" value="${lottery.startDate}"><br>
        End Date: <input type="date" name="end_date" value="${lottery.endDate}"><br>
        Winning Numbers: <input type="text" name="winning_numbers" value="${lottery.winningNumbers}"><br>
        <input type="submit" value="Update">
    </form>
</body>
</html>
