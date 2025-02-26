package ReentrantLockExample;

public class ReentrantLockWithCondition {

    public static void main(String[] args) {
        ConditionalSharedResource resource = new ConditionalSharedResource(2);
        Thread even = new Thread(() -> {
            resource.produce();
        });
        even.setName("Even");

        Thread odd = new Thread(() -> {
            resource.produce();
        });
        odd.setName("Odd");
        even.start();
        odd.start();

    }
}
