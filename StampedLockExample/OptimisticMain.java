package StampedLockExample;

public class OptimisticMain {

    public static void main(String[] args) {
        OptimisticSharedResource resource = new OptimisticSharedResource();

        Thread th1 = new Thread(() -> {
            resource.producer();
        });
        th1.setName("Th1");

        Thread th2 = new Thread(() -> {
            resource.consume();
        });
        th2.setName("Th2");

        th1.start();
        th2.start();
    }
}
