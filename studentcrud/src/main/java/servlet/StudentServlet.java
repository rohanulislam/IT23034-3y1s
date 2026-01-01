package servlet;

import dao.StudentDAO;
import model.Student;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class StudentServlet extends HttpServlet {

    StudentDAO dao = new StudentDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String action = req.getParameter("action");
        String name = req.getParameter("name");
        String email = req.getParameter("email");

        if ("Insert".equals(action)) {
            dao.insertStudent(new Student(name, email));
        } else if ("Update".equals(action)) {
            dao.updateStudent(new Student(name, email));
        } else if ("Delete".equals(action)) {
            dao.deleteStudent(name);
        }

        resp.sendRedirect("index.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setAttribute("students", dao.getAllStudents());
        req.getRequestDispatcher("view.jsp").forward(req, resp);
    }

}
