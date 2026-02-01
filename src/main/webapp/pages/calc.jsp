<%--
  Created by IntelliJ IDEA.
  User: Андрей
  Date: 31.01.2026
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body>
    <nav class="navbar bg-body-tertiary">
        <form class="container-fluid justify-content-start">
            <a class="nav-link active" aria-current="page" href="/calculator">Calculator</a>
            <a class="nav-link" aria-current="page" href="/history">History</a>
        </form>
    </nav>
    <form action="/calculator" method="post">
        <div class="input-group mb-3">
            <span class="input-group-text">First number</span>
            <input type="text" class="form-control" name="num1">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text">Second number</span>
            <input type="text" class="form-control" name="num2">
        </div>
        <select class="form-select" aria-label="Default select example" name="operation">
            <option selected value="+">Addition</option>
            <option value="-">Subtraction</option>
            <option value="/">Divide</option>
            <option value="*">Multiply</option>
        </select>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
    <c:if test="${result != null}">
        <h3>${num1} ${operation} ${num2}</h3>
        <h3>Result: ${result}</h3>
    </c:if>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
</body>
</html>
