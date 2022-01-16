package thread.creation.$6callable;

import java.util.concurrent.Callable;

public class MyTask implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        Thread.sleep(1000);
        return 2;
    }


}
