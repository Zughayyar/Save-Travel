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
            <h1>Edit Burger ${expense.id}</h1>
            <a href="/" class="btn btn-secondary" >Go Back</a>
            <form:form action="/expense/makeEdit" method="post" modelAttribute="expense" >
                <form:hidden path="id" value="${expense.id}"/>
                <div class="mb-3">
                    <form:label path="expenseName" cssClass="form-label" for="expenseName">Expense Name</form:label>
                    <form:input path="expenseName" class="form-control" id="expenseName" />
                    <form:errors path="expenseName" cssClass="errorMessage" />
                </div>
                <div class="mb-3">
                    <form:label path="vendor" cssClass="form-label" for="vendor">Vendor</form:label>
                    <form:input path="vendor" class="form-control" id="vendor" />
                    <form:errors path="vendor" cssClass="errorMessage" />
                </div>
                <div class="mb-3">
                    <form:label path="amount" cssClass="form-label" for="amount">Amount ($)</form:label>
                    <form:input path="amount" class="form-control" id="amount" />
                    <form:errors path="amount" cssClass="errorMessage" />
                </div>
                <div class="mb-3">
                    <form:label path="description" cssClass="form-label" for="description">Description</form:label>
                    <form:textarea path="description" class="form-control" id="description" />
                    <form:errors path="description" cssClass="errorMessage" />
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form:form>
        </div>
    </div>

    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/script.js"></script>
</body>
</html>