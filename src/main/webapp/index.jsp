<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<form action="servlet" method = "get" style="align-content: center">
    <input type = "hidden" required name = "command" value="view">
    <button type="submit" class="w3-button w3-circle w3-teal">List</button>
</form>

<form action="servlet" method = "get" style="align-content: center">
    <input type = "hidden" required name = "command" value="add">
    <button type="submit" class="w3-button w3-circle w3-teal">ADD</button>
</form>
</body>
</html>
