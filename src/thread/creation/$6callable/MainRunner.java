package thread.creation.$6callable;

import java.util.concurrent.FutureTask;

public class MainRunner {
    public static void main(String[] args) throws Exception {
        MyTask myTask = new MyTask();
        // PITFALL: to multithreading : Runs in main function only
        // myTask.call();

        FutureTask<Integer> futureTask = new FutureTask(myTask);
        Thread t = new Thread(futureTask);
        t.start();
// …
        Integer result = futureTask.get(); // will wait for the async completion
        System.out.println(result);


    }
}
