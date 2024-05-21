<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Lottery</title>
</head>
<body>
    <h1>Create Lottery</h1>
    <form action="lottery" method="post">
        <input type="hidden" name="action" value="create">
        Lottery Name: <input type="text" name="lottery_name"><br>
        Start Date: <input type="date" name="start_date"><br>
        End Date: <input type="date" name="end_date"><br>
        Winning Numbers: <input type="text" name="winning_numbers"><br>
        <input type="submit" value="Create">
    </form>
</body>
</html>
