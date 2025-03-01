package FutureExample;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class RunnableFutureMain {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1,2,
                1, TimeUnit.HOURS, new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());

        List<Integer> output = new ArrayList<>();
        output.add(1);
        output.add(2);

        Future<List<Integer>> future = executor.submit(new MyRunnable(output), output);
        try {
            System.out.println("Return value: " + future.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
