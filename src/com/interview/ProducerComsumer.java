package com.interview;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerComsumer {

    Queue<Integer> queue = new LinkedList<>();
    int CAPACITY = 5;

    public synchronized void produce(int value) throws InterruptedException {
        while (queue.size() == CAPACITY) wait();
        queue.add(value);
        notifyAll();
    }

    public synchronized int consume() throws InterruptedException {
        while (queue.isEmpty()) wait();
        int val = queue.poll();
        notifyAll();
        return val;
    }
}
