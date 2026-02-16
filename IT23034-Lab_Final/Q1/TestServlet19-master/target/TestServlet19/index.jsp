<html>
<body>
<h2>Enter Department Details</h2>

<form method="get" action="TestServlet">

    <label for="deptName">Department Name:</label>
    <input type="text" id="deptName" name="deptName" required>
    <br><br>

    <label for="totalStudent">Number of Students:</label>
    <input type="number" id="totalStudent" name="totalStudent" required>
    <br><br>

    <input type="submit" name="action" value="Insert">
    <input type="submit" name="action" value="View">
    <input type="submit" name="action" value="Update">
    <input type="submit" name="action" value="Delete">

</form>

</body>
</html>
