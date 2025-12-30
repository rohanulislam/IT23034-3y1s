import java.util.HashMap;

/*
 * This program maps employee IDs to their departments using HashMap.
 */
public class EmployeeDepartmentMap {

    public static void main(String[] args) {
        HashMap<Integer, String> employeeMap = new HashMap<>();

        employeeMap.put(1001, "HR");
        employeeMap.put(1002, "IT");
        employeeMap.put(1003, "Finance");

        System.out.println("Employee Department Mapping:");
        System.out.println(employeeMap);
    }
}
