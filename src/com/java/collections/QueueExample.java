package com.java.collections;

import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueExample {
    static void main() {
        Queue<String> queue = new PriorityQueue<>();
        queue.add("Apple");
        queue.add("Banana");
        queue.add("Cherry");
        System.out.println("Queue elements: " + queue);
        System.out.println("Removing element: " + queue.poll());
        System.out.println("Queue after removal: " + queue);
        queue.add("Elderberry");
        System.out.println("Queue after adding Elderberry: " + queue);
        System.out.println("Removing element: " + queue.poll());
        System.out.println("Queue after removal: " + queue);
        queue.add("Date");
        System.out.println("Final Queue: " + queue);

//        Deque example
        Deque<String> deque = new java.util.ArrayDeque<>();
        deque.addFirst("First");
        deque.addLast("Last");
        System.out.println("Deque elements: " + deque);
        System.out.println("Removing last element: " + deque.pollLast());
        System.out.println("Deque after removing last: " + deque);
        System.out.println("Removing first element: " + deque.pollFirst());
        System.out.println("Deque after removing first: " + deque);

    }
}
