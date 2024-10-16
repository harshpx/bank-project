<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<body>
    <h2>Deposit Money</h2>
    <form action="/deposit" method="post">
        <label for="accountNumber">Account Number:</label>
        <input type="text" id="accountNumber" name="acNo" required>
        <br><br>
        <label for="amount">Amount:</label>
        <input type="text" id="amount" name="balance" required>
        <br><br>
        <input type="submit" value="Deposit">
    </form>
</body>
</html>