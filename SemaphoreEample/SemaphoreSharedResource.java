package SemaphoreEample;

import java.util.concurrent.Semaphore;

public class SemaphoreSharedResource {

    boolean isAvailable = false;
    Semaphore semaphoreLock = new Semaphore(2);

    public void produce(){

        try{
            semaphoreLock.acquire();
            System.out.println("Lock acquired by: " + Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(4000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            System.out.println("Lock release by: " + Thread.currentThread().getName());
            semaphoreLock.release();
        }
    }
}
