package LE1.Ex2;

public class Main {

    public static void main(String[] args) {

        PriorityQueue queue = new PriorityQueue(5);

        queue.insert(3);
        queue.insert(5);
        queue.insert(4);
        queue.insert(2);
        queue.insert(5);

        queue.showQueue();

        queue.remove();
        System.out.println("\n");
        queue.showQueue();

    }
}
