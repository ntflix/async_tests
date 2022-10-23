package com.iron59;

import java.util.concurrent.CompletableFuture;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Integer toCalculateFactorial = 5;
        System.out.println("Calculating factorial of " + toCalculateFactorial + "...");
        
        AsyncThings asyncThings = new AsyncThings();
        CompletableFuture<Integer> futureResponse = asyncThings.getFactorial(toCalculateFactorial);
        futureResponse.whenComplete((result, exception) -> {
            if (exception != null) {
                System.out.println("Error calculating factorial: " + exception.getMessage());
            } else {
                System.out.println("Factorial of " + toCalculateFactorial + " is " + result);
            }
        });
        
        System.out.println("This is some code that comes after the async call!! :D");
        System.out.println("Magic!");

        // sleep for 10 seconds to demo different threads
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("This is some code that comes after the main thread sleep!!");
    
        // the 5 seconds elapses and the factorial is displayed. The 10 seconds does not affect the async process
        // as it is running in a different thread.

        try {
            futureResponse.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
