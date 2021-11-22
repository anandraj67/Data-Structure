package thread.creation.plain;

public class MainRunner {
    public static void main(String[] args) {
        CountdownPrinter countdownPrinter = new CountdownPrinter(10);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                countdownPrinter.print();
            }
        }, "Countdown");
        thread.start();
    }
}
