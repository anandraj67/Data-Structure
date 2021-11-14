package thread.creation.countdown_print_runnable;

public class MainRunner {
    public static void main(String[] args) {
        CountdownPrinter countdownPrinter = new CountdownPrinter(5);
		Thread thread = new Thread(countdownPrinter, "Anand");
		thread.start();
    }
}
