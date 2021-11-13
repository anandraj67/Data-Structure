package thread.creation.finite_print_runnable;

public class MainRunner {
    public static void main(String[] args) {
        FinitePrintRunnable finitePrintRunnable = new FinitePrintRunnable(5);
		Thread thread = new Thread(finitePrintRunnable, "Anand");
		thread.start();
    }
}
