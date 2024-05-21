<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Lottery Winner</title>
</head>
<body>
    <h1>Update Lottery Winner</h1>
    <form action="lotteryWinner" method="post">
        <input type="hidden" name="action" value="update">
        <input type="hidden" name="id" value="${winner.id}">
        User ID: <input type="text" name="user_id" value="${winner.userId}"><br>
        Lottery Winner ID: <input type="text" name="lottery_winner_id" value="${winner.lotteryWinnerId}"><br>
        Winnings: <input type="text" name="winnings" value="${winner.winnings}"><br>
        <input type="submit" value="Update">
    </form>
</body>
</html>
