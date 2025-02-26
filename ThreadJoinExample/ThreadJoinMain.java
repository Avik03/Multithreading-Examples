package ThreadJoinExample;

public class ThreadJoinMain {

    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        System.out.println("Main Thread Started");

        Thread t1 = new Thread(() -> {
            System.out.println("T1 calling produce");
            sharedResource.produce();
        });
        t1.setName("T1");
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Main thread finiishing");
    }
}
