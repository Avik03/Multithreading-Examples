package FutureExample;

import java.util.concurrent.*;

public class FutureMain {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1,2,
                1, TimeUnit.HOURS, new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());

        Future<?> future = executor.submit(() -> {
            System.out.println("Task with Callable");
            System.out.println("Task is performed by thread: " + Thread.currentThread().getName());
            Thread.sleep(5000);
            return "Completed";
        });

        Future<?> future2 = executor.submit(() -> {
            // Runnable as nothing is returned
            System.out.println("Task with Runnable");
        });

        /*try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
        try {
            System.out.println("Is future done: " + future.isDone());
            System.out.println("Output from future: " + future.get());
            System.out.println("Is future done: " + future.isDone());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        executor.shutdown();
    }
}
