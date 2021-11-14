package thread.creation.countdown_print_runnable_with_thread;

public class MainRunner {
    public static void main(String[] args) {
        CountdownPrinter countdownPrinter =  new CountdownPrinter("Prady");
        countdownPrinter.start();
    }
}
