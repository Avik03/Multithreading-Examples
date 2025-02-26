package ProducerConsumerProblem;

import java.util.AbstractQueue;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class SharedQueue {

    Queue<Integer> itemQueue = new ArrayDeque<>(3);

    public synchronized void produceItem(int item){
        System.out.println("Produce Item thread : " + Thread.currentThread().getName());
        try {
            while (itemQueue.size() == 3) {
                System.out.println("Producer is waiting as the queue is full");
                wait();
            }
            System.out.println("Producer produced : " + item);
            itemQueue.add(item);

            notifyAll();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void consumeItem(){
        System.out.println("Consume Item thread : " + Thread.currentThread().getName());
        try {
            while (itemQueue.isEmpty()) {
                System.out.println("Consumer thread on waiting as queue is empty");
                wait();
            }

            int item = itemQueue.poll();
            notifyAll();
            System.out.println("Consumer item consumed : " + item);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
