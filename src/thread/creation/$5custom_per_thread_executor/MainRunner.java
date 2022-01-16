package thread.creation.$5custom_per_thread_executor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainRunner {
    public static void main(String[] args) {
        CountdownPrinter countdownPrinter = new CountdownPrinter(10);
        Executor executor = new PerThreadExecutor();

        executor.execute(()->{countdownPrinter.print();});
        System.out.println("Done");

        executor.execute(()->{countdownPrinter.print();});
        System.out.println("Done again");

        // Via inbuilt executor
        Executor executor1 = Executors.newSingleThreadExecutor();
        executor1.execute(()->{countdownPrinter.print();});

    }
}
