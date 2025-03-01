package CompletableFutureExample;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureThenCombine {

    public static void main(String[] args) {
        CompletableFuture<String> async1 = CompletableFuture.supplyAsync(() -> {
            return "Hello";
        });

        CompletableFuture<Integer> async2 = CompletableFuture.supplyAsync(() -> {
            return 50;
        });

        CompletableFuture<String> combinedAsync = async1.thenCombine(async2, (String val, Integer test) -> {
            return val + test;
        });

        try {
            System.out.println("return value : " + combinedAsync.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (
                ExecutionException e) {
            throw new RuntimeException(e);
        }
    }


}
