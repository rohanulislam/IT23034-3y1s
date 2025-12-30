import java.util.PriorityQueue;

/*
 * Stack implementation using PriorityQueue.
 * The element with the highest priority (latest inserted) comes first.
 */
public class PriorityQueueStack {

    static class StackElement {
        int value;
        int priority;

        StackElement(int value, int priority) {
            this.value = value;
            this.priority = priority;
        }
    }

    static int counter = 0;

    static PriorityQueue<StackElement> stack =
            new PriorityQueue<>((a, b) -> b.priority - a.priority);

    public static void push(int value) {
        stack.add(new StackElement(value, counter++));
    }

    public static int pop() {
        return stack.poll().value;
    }

    public static void main(String[] args) {
        push(10);
        push(20);
        push(30);

        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
    }
}
