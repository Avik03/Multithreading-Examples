package CompletableFutureExample;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureThenApplyAsync {

    public static void main(String[] args) {
        CompletableFuture<String> async1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Thread in supplyAync: " + Thread.currentThread().getName());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "CONCEPT";
        }).thenApplyAsync((String value) -> {
            System.out.println("Thread in thenApply: " + Thread.currentThread().getName());
            return "And";
        });

        try {
            System.out.println("return value : " + async1.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
