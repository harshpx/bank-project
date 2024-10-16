<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Withdraw Money</title>
</head>
<body>
<h2>Withdraw Money</h2>
<form action="/withdrawCustomer" method="get">
    <label for="accountNumber">Account Number:</label>
    <input type="text" id="accountNumber" name="acNo" required><br><br>
    <label for="amount">Amount:</label>
    <input type="number" id="amount" name="balance" required><br><br>
    <input type="submit" value="Withdraw">
</form>
</body>
</html>