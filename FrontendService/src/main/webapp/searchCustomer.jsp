<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Search Customer</title>
</head>
<body>
    <h2>Search for a Customer</h2>
    <form action="/searchCustomer" method="get">
        <label for="accountNumber">Account Number:</label>
        <input type="text" id="accountNumber" name="acNo" required><br><br>
        <input type="submit" value="Search">
    </form>
</body>
</html>