package thread.creation.extending_thread;

public class MainRunner {
    public static void main(String[] args) {
        Thread thread1 = new InfinitePrintThread("Anand");
		//PITFALL: thread1.run(); // Runs in main contex;  thread name : main
		thread1.start(); // new thread : thread name : Prady

    }
}
