package CompletableFutureExample;

import java.util.concurrent.*;

public class CompletableFutureMain {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1,2,
                1, TimeUnit.HOURS, new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());

        CompletableFuture<String> asyncTask1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Task Completed";
        },executor);

        try {
            System.out.println(asyncTask1.get());
            System.out.println("Main method executing");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}

