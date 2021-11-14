package thread.creation.callable;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class MainRunner {
    public static void main(String[] args) throws Exception {
        Calculator calculator = new Calculator();
        System.out.println("main 1");
        System.out.println(calculator.call());
        System.out.println("main 2");

    }
}
