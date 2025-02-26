package SemaphoreEample;

public class SemaphoreLockMain {

    public static void main(String[] args) {
        SemaphoreSharedResource resource = new SemaphoreSharedResource();

        Thread th1 = new Thread(() -> {
            resource.produce();
        });
        th1.setName("th1");

        Thread th2 = new Thread(() -> {
            resource.produce();
        });
        th2.setName("th2");

        Thread th3 = new Thread(() -> {
            resource.produce();
        });
        th3.setName("th3");

        Thread th4 = new Thread(() -> {
            resource.produce();
        });
        th4.setName("th4");

        th1.start();
        th2.start();
        th3.start();
        th4.start();

    }
}
