package com.iron59;

import java.util.concurrent.CompletableFuture;

public class AsyncThings {
    public CompletableFuture<Integer> getFactorial(int n) {
        CompletableFuture<Integer> futureResponse = CompletableFuture.supplyAsync(() -> {
            // sleep for 5 seconds to demo async
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            // return the factorial
            Integer result = 1;
            for (int i = 1; i < n + 1; i++) {
                result *= i;
            }
            return result;
        });

        return futureResponse;
    }
}
