package SynchronizedProbelm;

public class SharedRes {

    public synchronized void produce(){
        System.out.println("Lock acquired by Thread: " + Thread.currentThread().getName());

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Lock Released by Thread: " + Thread.currentThread().getName());
    }
}
