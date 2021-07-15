package thread.creation;

public class MainRunner {

	public static void main(String[] args) throws Exception {
//		SomeJob someJob =  new SomeJob("Prady");
//		someJob.start();

		MyRunnable myRunnable = new MyRunnable();
		Thread thread = new Thread(myRunnable, "Anand");
		thread.start();

		MyThread myThread = new MyThread("Prady");
		//myThread.run(); // Runs in main contex;  thread name : main
		myThread.start(); // new thread : thread name : Prady

	}

}
