package StampedLockExample;

import java.util.concurrent.locks.StampedLock;

public class SharedResource {

    boolean isAvailable = false;

    StampedLock stampedLock = new StampedLock();

    public void producer(){
        System.out.println("Thread : " + Thread.currentThread().getName() + "trying to acquired read lock");
        long stamp = stampedLock.tryReadLock(); // if we use readLock() then the if block not needed
        System.out.println("Stamp: " + stamp);
        if(stamp != 0L){
        try{
            System.out.println("Read Lock acquired by : " + Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(6000);

        }catch (Exception e){

        }finally {
            System.out.println("read Lock released by : " + Thread.currentThread().getName());
            stampedLock.unlockRead(stamp);

        }
        }
    }

    public void consume(){
        long stamp = stampedLock.writeLock();

        try{
            System.out.println("Write Lock acquired by : " + Thread.currentThread().getName());
            Thread.sleep(8000);
        }catch (Exception e){

        }finally {
            System.out.println("Write Lock released by : " + Thread.currentThread().getName());
            stampedLock.unlockWrite(stamp);
        }
    }
}
