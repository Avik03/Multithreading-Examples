package MonitorLockEample;

import javax.swing.plaf.TableHeaderUI;

public class SharedResource {

    boolean itemAvailable = false;

    public synchronized void addItem(){
        itemAvailable = true;
        System.out.println("Item added by: " + Thread.currentThread().getName());
        notifyAll();
    }

    public synchronized void consumeItem(){
        System.out.println("Consume item invoked by thread: " + Thread.currentThread().getName());

        //to avoid spurious wake up call use the while loop
        while (!itemAvailable){
            try {
                System.out.println("Thread " + Thread.currentThread().getName() + "is waiting");
                wait(); // it releases the monitor locks
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Item consumed by thread : " + Thread.currentThread().getName());
        itemAvailable = false;
    }
}
