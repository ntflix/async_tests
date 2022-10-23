## async tests

This is a simple example of using async in Java.

## Output
```
Calculating factorial of 5...
This is some code that comes after the async call!! :D
Magic!
Factorial of 5 is 120
This is some code that comes after the main thread sleep!!
```

## Explanation

The `async` keyword is used to mark a method as asynchronous. This means that the method will be executed in a separate thread. The method must return a `CompletableFuture` object. The `CompletableFuture` object is used to get the result of the asynchronous method.

The `CompletableFuture` object has a method called `get()` which will block the current thread until the result is available. This is why we have to call `get()` on the `CompletableFuture` object in the `main` method.

## Code

```java
import java.util.concurrent.CompletableFuture;

public class AsyncTest {
    public static void main(String[] args) throws Exception {
        System.out.println("Calculating factorial of 5...");
        CompletableFuture<Integer> future = factorial(5);
        System.out.println("This is some code that comes after the async call!! :D");
        System.out.println("Magic!");
        System.out.println("Factorial of 5 is " + future.get());
    }

    public static CompletableFuture<Integer> factorial(int n) {
        return CompletableFuture.supplyAsync(() -> {
            int result = 1;
            for (int i = 1; i <= n; i++) {
                result *= i;
            }
            return result;
        });
    }
}
```