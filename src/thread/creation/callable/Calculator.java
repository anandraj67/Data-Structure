package thread.creation.callable;

import java.util.concurrent.Callable;

public class Calculator implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        Thread.sleep(1000);
        return 2;
    }


}
