package ReentrantLockExample;

import java.util.concurrent.locks.ReentrantLock;

public class RenetrantLockMain {

    public static void main(String[] args) {

        SharedResource resource1 = new SharedResource();
        SharedResource resource2 = new SharedResource();
        ReentrantLock reentrantLock = new ReentrantLock();

        Thread t1 = new Thread(() -> {
           resource1.produce(reentrantLock);
        });
        t1.setName("t1");

        Thread t2 = new Thread(() -> {
            resource2.produce(reentrantLock);
        });
        t2.setName("t2");

        t1.start();
        t2.start();

    }
}
