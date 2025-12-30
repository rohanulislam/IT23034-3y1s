import java.util.PriorityQueue;

/*
 * Queue implementation using PriorityQueue.
 * The element with the lowest priority (earliest inserted) comes first.
 */
public class PriorityQueueQueue {

    static class QueueElement {
        int value;
        int priority;

        QueueElement(int value, int priority) {
            this.value = value;
            this.priority = priority;
        }
    }

    static int counter = 0;

    static PriorityQueue<QueueElement> queue =
            new PriorityQueue<>((a, b) -> a.priority - b.priority);

    public static void enqueue(int value) {
        queue.add(new QueueElement(value, counter++));
    }

    public static int dequeue() {
        return queue.poll().value;
    }

    public static void main(String[] args) {
        enqueue(10);
        enqueue(20);
        enqueue(30);

        System.out.println(dequeue());
        System.out.println(dequeue());
        System.out.println(dequeue());
    }
}
