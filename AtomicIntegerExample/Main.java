package AtomicIntegerExample;

public class Main {

    public static void main(String[] args) {

        SharedResource sharedResource = new SharedResource();
        Thread t1 = new Thread(() -> {
            sharedResource.increment();
        });
        t1.setName("t1");
        Thread t2 = new Thread(() -> {
            sharedResource.increment2();
        });
        t2.setName("t2");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Value of counter: " + sharedResource.get());

    }
}
