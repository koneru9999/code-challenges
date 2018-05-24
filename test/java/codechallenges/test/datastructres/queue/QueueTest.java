package codechallenges.test.datastructres.queue;

import codechallenges.datastructures.queue.Queue;

public class QueueTest {

    public static void testEnQueue() {
        Queue<String> queue = getNewInstance();
        queue.print();

        queue.enQueue("abc");
        queue.enQueue("def");
        queue.enQueue("ghi");

        queue.print();
    }

    public static void testDeQueue() {
        Queue<String> queue = getNewInstance();
        queue.print();

        queue.enQueue("abc");
        queue.enQueue("def");
        queue.enQueue("ghi");

        queue.print();

        System.out.println(queue.deQueue().getData());

        queue.print();
    }

    public static <T> Queue<T> getNewInstance() {
        return new Queue<>();
    }

    public static void main(String[] args) {
        // testEnQueue();
        testDeQueue();
    }
}
