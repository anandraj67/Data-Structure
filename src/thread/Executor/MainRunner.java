package thread.Executor;

public class MainRunner {
    public static void main(String[] args) {
        // This is nothing but callable
        // execute many times
        ThreadPerTaskExecutor executor = new ThreadPerTaskExecutor();

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println("Done");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        executor.execute(r1);
        executor.execute(r1);
    }
}
