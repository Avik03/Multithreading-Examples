package ProducerConsumerProblem;

public class ProducerConsumerMain {

    public static void main(String[] args) {
        SharedQueue sharedQueue = new SharedQueue();

        Thread producerThread = new Thread(() -> {
            System.out.println("Producer Thread run method called");
            for(int i=1; i<=6;i++){
                sharedQueue.produceItem(i);
            }

        });
        producerThread.setName("Producer");

        Thread consumerThread = new Thread(() -> {
            System.out.println("Consumer Thread run method called");
            for(int i=1;i<=6;i++){
                sharedQueue.consumeItem();
            }

        });

        consumerThread.setName("Consumer");

        producerThread.start();
        consumerThread.start();
    }
}
