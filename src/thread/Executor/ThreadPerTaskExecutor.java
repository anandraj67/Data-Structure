package thread.Executor;

import java.util.concurrent.Executor;

class ThreadPerTaskExecutor implements Executor {
    public void execute(Runnable r) {
        Thread t = new Thread(r);
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}