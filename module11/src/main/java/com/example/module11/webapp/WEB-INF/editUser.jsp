<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Редактирование пользователя</title>
    <script src="/scripts/script.js"></script>
</head>
<body style="background-color: white">
<div style="text-align: center;">
    <form action="../edit" method="post">
        <div class="form-group">
            <label for="id" class="text-white">Id</label>
            <input type="number" class="form-control" id="id" value="${id}" name="id" readonly>
        </div>
        <div class="form-group">
            <label for="name" class="text-white">Name</label>
            <input type="text" class="form-control" id="name" value="${name}" name="name">
        </div>
        <div class="form-group">
            <label for="age" class="text-white">Age</label>
            <input type="number" class="form-control" id="age" value="${age}" name="age">
        </div>
        <button type="submit" class="btn btn-primary">Update</button>
    </form>
</div>
</body>
</html>