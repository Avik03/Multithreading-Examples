package StampedLockExample;

import java.util.concurrent.locks.StampedLock;

public class OptimisticSharedResource {

    int a = 10;

    StampedLock lock = new StampedLock();

    public void producer(){
        System.out.println("Producer called");
        long stamp = lock.tryOptimisticRead();
        System.out.println("Stamp: "+ stamp);
        try{
            System.out.println("Taken optimistic read");
            a = 11;
            Thread.sleep(6000);
            if(lock.validate(stamp)){


                System.out.println("Updated value successfully");
            }else{
                System.out.println("Roll back work");
            }
        }catch (Exception e){

        }
    }

    public void consume(){
        long stamp = lock.writeLock();
        System.out.println("Write lock acquired by: " + Thread.currentThread().getName());

        try{
            System.out.println("performing work");
        }catch (Exception e){

        }finally {
            System.out.println("Write lock release by: " + Thread.currentThread().getName());
            lock.unlockWrite(stamp);
        }


    }
}
