import java.util.LinkedList;

/*
 * This program checks whether two LinkedLists are equal.
 */
public class LinkedListEquality {

    public static void main(String[] args) {
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();

        list1.add(1);
        list1.add(2);
        list1.add(3);

        list2.add(1);
        list2.add(2);
        list2.add(3);

        if (list1.equals(list2)) {
            System.out.println("LinkedLists are equal");
        } else {
            System.out.println("LinkedLists are not equal");
        }
    }
}
