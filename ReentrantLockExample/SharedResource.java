package ReentrantLockExample;

import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {

    boolean isAvailable = false;

    public void produce(ReentrantLock reentrantLock){
        try{
            reentrantLock.lock();
            System.out.println("Lock Acquired by: " + Thread.currentThread().getName());
            isAvailable  = true;
            Thread.sleep(4000);

        }catch (Exception e){

        }finally {
            System.out.println("Lock Released by: " + Thread.currentThread().getName());
            reentrantLock.unlock();

        }
    }
}
