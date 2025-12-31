import java.lang.reflect.Field;
import java.util.ArrayList;

public class ArrayListCapacityDemo {

    // Method to get ArrayList capacity using reflection
    static int getCapacity(ArrayList<?> list) throws Exception {
        Field field = ArrayList.class.getDeclaredField("elementData");
        field.setAccessible(true);
        Object[] array = (Object[]) field.get(list);
        return array.length;
    }

    public static void main(String[] args) throws Exception {

        // Initial capacity = 10
        ArrayList<Integer> list = new ArrayList<>();

        System.out.println("Initial Capacity: " + getCapacity(list));

        // Add elements beyond capacity
        for (int i = 1; i <= 11; i++) {
            list.add(i);
        }

        System.out.println("Capacity after exceeding initial limit: "
                + getCapacity(list));
    }
}
