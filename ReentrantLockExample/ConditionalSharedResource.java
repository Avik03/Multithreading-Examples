package ReentrantLockExample;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionalSharedResource {

    ReentrantLock reentrantLock = new ReentrantLock();
    Condition even = reentrantLock.newCondition();
    Condition odd = reentrantLock.newCondition();

    int c;

    public ConditionalSharedResource(int c) {
        this.c = c;
    }
    int MAX = 10;

    public void produce(){

        while(c <= MAX){

            reentrantLock.lock();

            try{
                if(c%2 == 1 && Thread.currentThread().getName().equals("Even")){
                    even.await();
                }else if(c%2 == 0 && Thread.currentThread().getName().equals("Odd")){
                    odd.await();
                }else{

                    System.out.println("Current Thread Name : " + Thread.currentThread().getName());
                    c++;

                    if(c%2 ==0){
                        even.signal();
                    }else {
                        odd.signal();
                    }
                }
            }catch (Exception e){

            }finally {
                reentrantLock.unlock();
            }



        }
    }
}
