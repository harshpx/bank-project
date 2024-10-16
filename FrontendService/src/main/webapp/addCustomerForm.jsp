<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add Customer</title>
</head>
<body>
<h2>Add New Customer</h2>
<form action="/addCustomerAdmin" method="get">
        <label for="acNo">Account Number:</label>
        <input type="number" id="acNo" name="acNo" required><br>

        <label for="name">Customer Name:</label>
        <input type="text" id="name" name="name" required><br>

        <label for="balance">Initial Balance:</label>
        <input type="number" id="balance" name="balance" required><br>

        <input type="submit" value="Add Customer">
</form>
</body>
</html>