import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentService extends MyDBClass {

    public boolean insertStudent(String studentName) {

        getConnection();
        String insertQuery = "INSERT INTO student(name) VALUES(?)";

        try {
            ps = connection.prepareStatement(insertQuery);
            ps.setString(1, studentName);
            ps.executeUpdate();

            ps.close();
            connection.close();
            return true;

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return false;
    }

    public List<Student> fetchAllStudents() {

        List<Student> studentList = new ArrayList<>();
        getConnection();
        String selectQuery = "SELECT * FROM student";

        try {
            ps = connection.prepareStatement(selectQuery);
            rs = ps.executeQuery();

            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt(1));
                student.setName(rs.getString(2));
                studentList.add(student);
            }

            ps.close();
            rs.close();
            connection.close();
            return studentList;

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public void updateStudent(int studentId, String updatedName) {

        getConnection();
        String updateQuery = "UPDATE student SET name=? WHERE id=?";

        try {
            ps = connection.prepareStatement(updateQuery);
            ps.setString(1, updatedName);
            ps.setInt(2, studentId);
            ps.executeUpdate();
            ps.close();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void deleteStudent(int studentId) {

        getConnection();
        String deleteQuery = "DELETE FROM student WHERE id=?";

        try {
            ps = connection.prepareStatement(deleteQuery);
            ps.setInt(1, studentId);
            ps.executeUpdate();

            ps.close();
            connection.close();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
