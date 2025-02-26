package MonitorLockEample;

public class ConsumerTask implements Runnable{

    SharedResource sharedResource;

    public ConsumerTask(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        System.out.println("Coumer Thread run method called on: "  + Thread.currentThread().getName());
        sharedResource.consumeItem();
    }
}
