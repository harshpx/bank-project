<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<body>
    <h2>Check Account Balance</h2>
    <form action="/checkBalance" method="post">
        <label for="accountNumber">Account Number:</label>
        <input type="text" id="accountNumber" name="acNo" required>
        <br><br>
        <input type="submit" value="Check Balance">
    </form>
</body>
</html>