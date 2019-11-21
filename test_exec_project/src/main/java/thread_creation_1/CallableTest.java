package thread_creation_1;

import java.util.concurrent.*;

public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        CustomCallable customCallable = new CustomCallable();
        Future<String> future = executorService.submit(customCallable);
        System.out.println(future.get());
        executorService.shutdown();
    }
}

class CustomCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "hello from callable";
    }
}
