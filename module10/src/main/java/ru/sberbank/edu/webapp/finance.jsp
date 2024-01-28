<%@page contentType="text/html; charset=UTF-8" %>
<!doctype html>
<html>
<head>
    <title>FinanceDeposit</title>
    <meta charset="utf-8">
    <style>
    font-family: 'monospace';
    font-size: 100px;
</style>
</head>
<body style="font-size:20px">
<center>
    <table>
        <head id="main">
        <tr>
            <th><h2>Калькулятор доходности вклада</h2></th>
        </tr>
        </head>
        <body>
        <tr>
        <form method="POST" action="">
       <td> Сумма на момент открытия:</td>
       <td><input name="sum" style="background-color:gray"></td>
        </tr>
        <tr>
            <td>Процентная ставка:</td>
            <td><input name="percent" style="background-color:gray"></td>
        </tr>
        <tr>
            <td>Количество лет:</td>
            <td><input name="years" style="background-color:gray"></td>
         </tr>
        </body>
    </table>
    <br>
    <input type="submit" value="Посчитать" style="background-color:blue ;width: 150px; height: 30px;">
    </center>
</body>
</html>