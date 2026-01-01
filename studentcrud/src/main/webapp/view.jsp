<%@ page import="java.util.*, model.Student" %>

<h1>Action: View</h1>

<table border="1" width="60%">
    <tr>
        <th>Name</th>
        <th>Email</th>
    </tr>

    <%
        List<Student> list = (List<Student>) request.getAttribute("students");
        for (Student s : list) {
    %>
    <tr>
        <td><%= s.getName() %></td>
        <td><%= s.getEmail() %></td>
    </tr>
    <% } %>
</table>
