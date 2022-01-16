package thread.creation.$4no_thread_and_runnable;

public class MainRunner {
    public static void main(String[] args) {
        CountdownPrinter countdownPrinter = new CountdownPrinter(10);
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                countdownPrinter.print();
//            }
//        }, "Countdown");
//        thread.start();

//        Thread thread = new Thread(()-> {
//            countdownPrinter.print();
//        },"Countdown");
//        thread.start();

//        Thread thread = new Thread(()->countdownPrinter.print(),"Countdown");
//        thread.start();

        new Thread(()-> countdownPrinter.print(),"Countdown").start();

    }
}
