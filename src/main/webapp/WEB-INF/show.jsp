<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Burger Tracker</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
    <div class="main-container">
        <div class="table-show-all">
            <h1>Expense Details</h1>
            <a href="/" class="btn btn-secondary" >Go Back</a>
            <h4>Expense ID: ${expense.id}</h4>
            <h4>Expense Name: ${expense.expenseName}</h4>
            <h4>Description: ${expense.description}</h4>
            <h4>Vendor: ${expense.vendor}</h4>
            <h4>Amount Spent: $${expense.id}</h4>
        </div>
    </div>

    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/script.js"></script>
</body>
</html>