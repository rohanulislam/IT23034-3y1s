import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.sql.*;
import java.time.LocalDate;

public class Main extends Application {

    Connection conn;

    TextField nameField = new TextField();
    DatePicker dobPicker = new DatePicker();
    TextField searchField = new TextField();
    ListView<String> listView = new ListView<>();

    @Override
    public void start(Stage stage) {

        connectDB();
        createTable();
        showUpcoming();
        checkTodayBirthday();

        Label title = new Label("জন্মদিন ব্যবস্থাপনা");
        Label nameLbl = new Label("নাম:");
        Label dobLbl  = new Label("জন্মদিন:");

        Button addBtn = new Button("যোগ করুন");
        Button updateBtn = new Button("হালনাগাদ");
        Button deleteBtn = new Button("মুছে ফেলুন");
        Button searchBtn = new Button("অনুসন্ধান");
        Button upcomingBtn = new Button("আসন্ন জন্মদিন");

        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
        root.setHgap(10);
        root.setVgap(10);

        root.add(title, 0, 0, 2, 1);
        root.add(nameLbl, 0, 1);
        root.add(nameField, 1, 1);
        root.add(dobLbl, 0, 2);
        root.add(dobPicker, 1, 2);

        HBox btnBox = new HBox(10, addBtn, updateBtn, deleteBtn);
        btnBox.setAlignment(Pos.CENTER);
        root.add(btnBox, 0, 3, 2, 1);

        root.add(new Label("নাম বা মাস অনুসন্ধান:"), 0, 4);
        root.add(searchField, 1, 4);

        HBox searchBox = new HBox(10, searchBtn, upcomingBtn);
        searchBox.setAlignment(Pos.CENTER);
        root.add(searchBox, 0, 5, 2, 1);

        root.add(listView, 0, 6, 2, 1);

        addBtn.setOnAction(e -> addBirthday());
        updateBtn.setOnAction(e -> updateBirthday());
        deleteBtn.setOnAction(e -> deleteBirthday());
        searchBtn.setOnAction(e -> searchBirthday());
        upcomingBtn.setOnAction(e -> showUpcoming());

        stage.setScene(new Scene(root, 450, 500));
        stage.setTitle("জন্মদিন ম্যানেজার");
        stage.show();
    }

    void connectDB() {
        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/birthdaydb",
                    "root", ""
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void createTable() {
        try {
            conn.createStatement().execute("""
                CREATE TABLE IF NOT EXISTS birthdays(
                  id INT AUTO_INCREMENT PRIMARY KEY,
                  name VARCHAR(100),
                  dob DATE
                );
            """);
        } catch (Exception ignored) {}
    }

    void addBirthday() {
        try {
            PreparedStatement st = conn.prepareStatement(
                    "INSERT INTO birthdays(name, dob) VALUES(?,?)"
            );
            st.setString(1, nameField.getText());
            st.setDate(2, Date.valueOf(dobPicker.getValue()));
            st.execute();
            showUpcoming();
        } catch (Exception e) { e.printStackTrace(); }
    }

    void updateBirthday() {
        try {
            String name = nameField.getText();
            PreparedStatement st = conn.prepareStatement(
                    "UPDATE birthdays SET dob=? WHERE name=?"
            );
            st.setDate(1, Date.valueOf(dobPicker.getValue()));
            st.setString(2, name);
            st.execute();
            showUpcoming();
        } catch (Exception e) { e.printStackTrace(); }
    }

    void deleteBirthday() {
        try {
            PreparedStatement st = conn.prepareStatement(
                    "DELETE FROM birthdays WHERE name=?"
            );
            st.setString(1, nameField.getText());
            st.execute();
            showUpcoming();
        } catch (Exception e) { e.printStackTrace(); }
    }

    void searchBirthday() {
        try {
            String s = searchField.getText();
            listView.getItems().clear();

            PreparedStatement st = conn.prepareStatement("""
                    SELECT name, dob FROM birthdays
                    WHERE name LIKE ? OR MONTH(dob)=?
                """);
            st.setString(1, "%" + s + "%");

            int monthNum = switch (s.toLowerCase()) {
                case "january","১","জানুয়ারি" -> 1;
                case "february","ফেব্রুয়ারি" -> 2;
                case "march","মার্চ" -> 3;
                default -> 0;
            };
            st.setInt(2, monthNum);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                listView.getItems().add(
                        rs.getString("name") + " - " + rs.getDate("dob")
                );
            }
        } catch (Exception e) { e.printStackTrace(); }
    }

    void showUpcoming() {
        try {
            listView.getItems().clear();
            ResultSet rs = conn.createStatement().executeQuery("""
                SELECT name, dob
                FROM birthdays
                ORDER BY MONTH(dob), DAY(dob)
            """);
            while (rs.next()) {
                listView.getItems().add(
                        rs.getString("name") + " - " + rs.getDate("dob")
                );
            }
        } catch (Exception e) { e.printStackTrace(); }
    }

    void checkTodayBirthday() {
        try {
            LocalDate today = LocalDate.now();
            PreparedStatement st = conn.prepareStatement("""
                SELECT name FROM birthdays
                WHERE MONTH(dob)=? AND DAY(dob)=?
            """);
            st.setInt(1, today.getMonthValue());
            st.setInt(2, today.getDayOfMonth());

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("আজকের জন্মদিন");
                alert.setHeaderText("🎉 আজ জন্মদিন!");
                alert.setContentText(rs.getString("name") + " এর আজ জন্মদিন!");
                alert.show();
            }
        } catch (Exception ignored) {}
    }

    public static void main(String[] args) {
        launch();
    }
}
