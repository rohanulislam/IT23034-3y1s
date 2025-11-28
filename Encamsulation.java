
public class EncapsulationExample {

    // Private fields: hidden from outside access
    private String name;
    private int age;
    private String grade;

    // Constructor to initialize the object
    public EncapsulationExample(String name, int age, String grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for age
    public int getAge() {
        return age;
    }

    // Setter for age with validation
    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            System.out.println("Age must be positive!");
        }
    }

    // Getter for grade
    public String getGrade() {
        return grade;
    }

    // Setter for grade
    public void setGrade(String grade) {
        this.grade = grade;
    }

    // Method to display object information
    public void displayInfo() {
        System.out.println("Student Info:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Grade: " + grade);
    }

    // Main method to test encapsulation
    public static void main(String[] args) {
        // Create an EncapsulationExample object
        EncapsulationExample student = new EncapsulationExample("Rohan", 20, "A");

        // Display initial info
        student.displayInfo();

        // Update values using setters
        student.setAge(21);
        student.setGrade("A+");
        student.displayInfo();

        // Try setting invalid age
        student.setAge(-5); // Will show validation message
    }
}
