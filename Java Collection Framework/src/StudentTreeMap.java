import java.util.TreeMap;

/*
 * This program stores student ID as key and student details as value.
 */
public class StudentTreeMap {

    static class Student {
        String name;
        int age;

        Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String toString() {
            return name + " (Age: " + age + ")";
        }
    }

    public static void main(String[] args) {
        TreeMap<Integer, Student> students = new TreeMap<>();

        students.put(101, new Student("Rafi", 21));
        students.put(102, new Student("Nila", 22));
        students.put(103, new Student("Arif", 20));

        System.out.println("Student Details:");
        System.out.println(students);
    }
}

