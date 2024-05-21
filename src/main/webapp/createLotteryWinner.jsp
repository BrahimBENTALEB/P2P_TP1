<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Lottery Winner</title>
</head>
<body>
    <h1>Create Lottery Winner</h1>
    <form action="lotteryWinner" method="post">
        <input type="hidden" name="action" value="create">
        User ID: <input type="text" name="user_id"><br>
        Lottery Winner ID: <input type="text" name="lottery_winner_id"><br>
        Winnings: <input type="text" name="winnings"><br>
        <input type="submit" value="Create">
    </form>
</body>
</html>
