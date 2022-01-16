package thread.ExecutorService;

import java.util.concurrent.*;

public class MainRunner {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ExecutorService executorService1 = new ThreadPoolExecutor(10, 10, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
//        ExecutorService executorService3 = Executors.newFixedThreadPool(10);
        ExecutorService executorService2 = Executors.newSingleThreadExecutor();

        Future future =  executorService2.submit(()-> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Done");
        });

        future.get();

        System.out.println("Main");

        Future<String> future1 = executorService2.submit(()->{
            System.out.println("aaa");
            return "aaa";
        });

        String s = future1.get();

        executorService2.shutdownNow();

    }
}
