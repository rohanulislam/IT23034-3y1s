import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Database {

    private static final String URL = "jdbc:mysql://localhost:3306/studentdb";
    private static final String USER = "root";
    private static final String PASSWORD = "2122003Rr";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void insertStudent(String name, String email) {
        String sql = "INSERT INTO students (name, email) VALUES (?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.executeUpdate();
            System.out.println("Inserted successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                students.add(new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    static class Student {
        int id;
        String name;
        String email;

        Student(int id, String name, String email) {
            this.id = id;
            this.name = name;
            this.email = email;
        }
    }

    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        String name=scan.nextLine();
        String email=scan.nextLine();
        insertStudent(name, email);

        for (Student s : getStudents()) {
            System.out.println(s.id + " " + s.name + " " + s.email);
        }
    }
}
