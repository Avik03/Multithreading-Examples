package SynchronizedProbelm;

public class SyncProblemMain {


    public static void main(String[] args) {
        SharedRes resource1 = new SharedRes();
        SharedRes resource2 = new SharedRes();
        Thread t1 = new Thread(() -> {
            System.out.println("t1 calling produce on resource1");
            resource1.produce();
        });
        t1.setName("T1");
        Thread t2 = new Thread(() -> {
            System.out.println("t2 calling produce on resource1");
            resource2.produce();
        });
        t2.setName("T2");

        t1.start();
        t2.start();
    }
}
