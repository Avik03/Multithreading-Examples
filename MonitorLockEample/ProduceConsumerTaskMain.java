package MonitorLockEample;

public class ProduceConsumerTaskMain {

    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        Thread producerThread = new Thread(new ProduceTask(sharedResource));
        producerThread.setName("Producer Thread");

        Thread consumerThread = new Thread(new ConsumerTask(sharedResource));
        consumerThread.setName("Consumer Thread");

        producerThread.start();
        consumerThread.start();

        System.out.println("Main Thread end");
    }
}
