import java.util.ArrayList;
import java.util.Collections;

public class KthSmallestElement {

    public static int findKthSmallest(ArrayList<Integer> list, int k) {
        Collections.sort(list); // Sort the ArrayList
        return list.get(k - 1); // k-th smallest element
    }

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(12);
        numbers.add(5);
        numbers.add(7);
        numbers.add(19);
        numbers.add(3);

        int k = 3;
        System.out.println("Kth smallest element: " + findKthSmallest(numbers, k));
    }
}
