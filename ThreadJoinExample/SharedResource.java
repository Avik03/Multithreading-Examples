package ThreadJoinExample;

public class SharedResource {

    private boolean isLockAcquired = false;

    public synchronized void produce(){
        System.out.println("Lock acquired by thread: " + Thread.currentThread().getName());
        isLockAcquired = true;
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Lock released by thread: " + Thread.currentThread().getName());
    }
}
