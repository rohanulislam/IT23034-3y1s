import java.util.Vector;

public class VectorCapacityDemo {

    public static void main(String[] args) {

        // Initial capacity = 10 (default)
        Vector<Integer> vector = new Vector<>();

        System.out.println("Initial Capacity: " + vector.capacity());

        // Add elements beyond capacity
        for (int i = 1; i <= 11; i++) {
            vector.add(i);
        }

        System.out.println("Capacity after exceeding initial limit: "
                + vector.capacity());
    }
}
