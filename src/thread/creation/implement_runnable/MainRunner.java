package thread.creation.implement_runnable;

public class MainRunner {
    public static void main(String[] args) {
        MyTask myTask = new MyTask();
		Thread thread = new Thread(myTask, "Anand");
		thread.start();
        System.out.println("Main");
        // PITFALL: Runs in main contex only
        // countdownPrinter.run();
    }
}
