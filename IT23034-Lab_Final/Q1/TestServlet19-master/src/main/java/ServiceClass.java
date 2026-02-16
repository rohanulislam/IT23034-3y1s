import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceClass extends DBConnection {

    // Insert a new department
    public boolean insertDB(String Department_Name, int Number_of_Students) {
        this.getConnection();
        String sql = "INSERT INTO department(Department_Name, Number_of_Students) VALUES(?, ?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, Department_Name);
            ps.setInt(2, Number_of_Students); // use int
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return false;
    }

    // View all departments
    public List<String> viewDB() {
        List<String> result = new ArrayList<>();
        this.getConnection();
        String sql = "SELECT Department_Name, Number_of_Students FROM department";
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                result.add("Department: " + rs.getString("Department_Name")
                        + ", NumberOfStudents: " + rs.getInt("Number_of_Students"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return result;
    }

    // Update number of students for a department
    public boolean updateDB(String Department_Name, int Number_of_Students) {
        this.getConnection();
        String sql = "UPDATE department SET Number_of_Students = ? WHERE Department_Name = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, Number_of_Students); // use int
            ps.setString(2, Department_Name);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return false;
    }

    // Delete a department
    public boolean deleteDB(String Department_Name) {
        this.getConnection();
        String sql = "DELETE FROM department WHERE Department_Name = ?"; // fixed typo
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, Department_Name);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return false;
    }
}
