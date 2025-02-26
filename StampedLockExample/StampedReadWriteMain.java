package StampedLockExample;

public class StampedReadWriteMain {

    public static void main(String[] args) {

        SharedResource sharedResource = new SharedResource();

        Thread th1 = new Thread(() -> {
           sharedResource.producer();
        });
        Thread th2 = new Thread(() -> {
            sharedResource.producer();
        });
        Thread th3 = new Thread(() -> {
            sharedResource.consume();
        });

        th3.start();
        th1.start();
        th2.start();

    }
}
