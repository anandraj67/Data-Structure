package thread.creation.$2implement_runnable;

public class MainRunner {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
		Thread thread = new Thread(myRunnable, "Anand");
		thread.start();
        System.out.println("Main");
        // PITFALL: Runs in main contex only
        // countdownPrinter.run();
    }
}
