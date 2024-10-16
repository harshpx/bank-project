<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<body>
    <h2>Withdraw Money</h2>
    <form action="/withdraw" method="post">
        <label for="accountNumber">Account Number:</label>
        <input type="text" id="accountNumber" name="acNo" required>
        <br><br>
        <label for="amount">Amount:</label>
        <input type="text" id="amount" name="balance" required>
        <br><br>
        <input type="submit" value="Withdraw">
    </form>
</body>
</html>