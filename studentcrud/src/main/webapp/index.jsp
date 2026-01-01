<!DOCTYPE html>
<html>
<head>
    <title>Student CRUD</title>
</head>
<body>

<h1>Enter Student Details</h1>

<!-- INSERT / UPDATE / DELETE -->
<form action="student" method="post">
    Name: <input type="text" name="name"><br><br>
    Email: <input type="email" name="email"><br><br>

    <button type="submit" name="action" value="Insert">Insert</button>
    <button type="submit" name="action" value="Update">Update</button>
    <button type="submit" name="action" value="Delete">Delete</button>
</form>

<br>

<!-- VIEW -->
<form action="student" method="get">
    <button type="submit">View</button>
</form>

</body>
</html>
