package DaemonThread;

public class DaemonThreadExample {

    public static void main(String[] args) {

        System.out.println("Main thread started execution");

        Thread deamonThread = new Thread(() -> {
            System.out.println("Running Daemon Thread");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Daemon thread exiting");
        });

        deamonThread.setDaemon(true);

        deamonThread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        System.out.println("Main thread completed execution");
    }
}
