import java.util.List;
import java.util.Scanner;

public class UserInputApp {

    public static void main(String[] args) {

        System.out.print("Enter name: ");
        Scanner inputScanner = new Scanner(System.in);
        String userName = inputScanner.nextLine();

        StudentService studentService = new StudentService();
        studentService.insertIntoDatabase(userName);

        List<Student> studentList = studentService.readFromDatabase();

        if (studentList != null) {
            for (Student student : studentList) {
                System.out.println(student.getId() + " " + student.getName());
            }
        }
    }
}
