package ReadWriteLockExample;

import java.util.concurrent.locks.ReadWriteLock;

public class SharedResource {

    public void produce(ReadWriteLock lock){
        try{
            lock.readLock().lock();
            System.out.println("Read Lock acquired by : " + Thread.currentThread().getName());
            Thread.sleep(3000);
        }catch(Exception e){

        }finally {
            System.out.println("Read Lock will be released by : " + Thread.currentThread().getName());
            lock.readLock().unlock();

        }
    }

    public void consume(ReadWriteLock lock){
        try{
            lock.writeLock().lock();
            System.out.println("Write Lock acquired by : " + Thread.currentThread().getName());
        }catch (Exception e){

        }finally {
            System.out.println("Write Lock will be released by : " + Thread.currentThread().getName());
            lock.writeLock().unlock();

        }
    }
}
