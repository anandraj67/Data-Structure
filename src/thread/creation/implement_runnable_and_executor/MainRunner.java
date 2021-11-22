package thread.creation.implement_runnable_and_executor;

public class MainRunner {
    public static void main(String[] args) {
        CountdownPrinter countdownPrinter = new CountdownPrinter(10);
        PerThreadExecutor executor = new PerThreadExecutor();
        executor.execute(countdownPrinter);
        System.out.println("Done");
    }
}
