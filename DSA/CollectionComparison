import java.util.*;

public class CollectionComparison {

    public static void main(String[] args) {

        // ----------- LinkedList -----------
        System.out.println("LinkedList:");
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(30);
        linkedList.add(10);
        linkedList.add(20);
        linkedList.addFirst(5);
        System.out.println(linkedList); // maintains insertion order

        // ----------- PriorityQueue -----------
        System.out.println("\nPriorityQueue:");
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(30);
        pq.add(10);
        pq.add(20);
        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " "); // sorted by priority
        }

        // ----------- Deque -----------
        System.out.println("\n\nDeque:");
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(10);
        deque.addLast(20);
        deque.addFirst(5);
        System.out.println(deque);
        System.out.println("Pop from front: " + deque.pollFirst());
        System.out.println("Pop from back: " + deque.pollLast());

        // ----------- HashMap -----------
        System.out.println("\nHashMap:");
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(3, "C");
        hashMap.put(1, "A");
        hashMap.put(2, "B");
        System.out.println(hashMap); // no order guarantee

        // ----------- TreeMap -----------
        System.out.println("\nTreeMap:");
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(3, "C");
        treeMap.put(1, "A");
        treeMap.put(2, "B");
        System.out.println(treeMap); // sorted by key

        // ----------- HashSet -----------
        System.out.println("\nHashSet:");
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(10);
        hashSet.add(5);
        hashSet.add(10); // duplicate ignored
        System.out.println(hashSet);
    }
}
