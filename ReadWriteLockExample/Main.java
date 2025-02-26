package ReadWriteLockExample;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {

    public static void main(String[] args) {
        SharedResource resource1 = new SharedResource();
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        Thread th1 = new Thread(() -> {
            resource1.produce(readWriteLock);
        });

        Thread th2 = new Thread(() -> {
            resource1.produce(readWriteLock);
        });

        SharedResource resource2 = new SharedResource();
        Thread th3 = new Thread(() -> {
            resource2.consume(readWriteLock);
        });

        th1.start();
        th2.start();
        th3.start();
    }
}
