<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Добавление нового пользователя</title>
    <script src="/scripts/script.js"></script>
</head>
<body style="background-color: white">
<div style="text-align: center;">
    <form action="add" method="post">
        <div class="form-group">
            <label for="name" class="text-white">Name</label>
            <input type="text" class="form-control" id="name" name="name">
        </div>
        <div class="form-group">
            <label for="age" class="text-white">Age</label>
            <input type="number" class="form-control" id="age" name="age">
        </div>
        <button type="submit" class="btn btn-primary">Add</button>
    </form>
</div>
</body>
</html>