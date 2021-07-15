package thread.creation;

public class MainRunner {

	public static void main(String[] args) throws Exception {
//		MyRunnableAndThread myRunnableAndThread =  new MyRunnableAndThread("Prady");
//		myRunnableAndThread.start();
//
//		InfinitePrintRunnable infinitePrintRunnable = new InfinitePrintRunnable();
//		Thread thread = new Thread(infinitePrintRunnable, "Anand");
//		thread.start();
//
//		Thread thread1 = new InfinitePrintThread("Prady");
//		//thread1.run(); // Runs in main contex;  thread name : main
//		thread1.start(); // new thread : thread name : Prady

//		FinitePrintRunnable finitePrintRunnable = new FinitePrintRunnable(5);
//		Thread thread2 = new Thread(finitePrintRunnable, "Jaksaniya");
//		thread2.start();
//
//		FinitePrintRunnable finitePrintRunnable1 = new FinitePrintRunnable(10);
//		Thread thread3 = new Thread(finitePrintRunnable1, "Prady");
//		thread3.start();
//
//		thread2.join();
//		thread3.join();
//
//		System.out.println("Anand");

		InfinitePrintWithStopRunnable infinitePrintWithStopRunnable = new InfinitePrintWithStopRunnable();
		Thread thread4 = new Thread(infinitePrintWithStopRunnable, "a");
		thread4.start();
		Thread.sleep(3000);
		infinitePrintWithStopRunnable.doStop();


	}

}
