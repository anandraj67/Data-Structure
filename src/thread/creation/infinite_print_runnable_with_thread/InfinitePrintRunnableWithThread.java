package thread.creation.infinite_print_runnable_with_thread;

public class InfinitePrintRunnableWithThread implements Runnable {
	Thread thread;
	public InfinitePrintRunnableWithThread(String name) {
		thread = new Thread(this,name);
	}
	@Override
	public void run() {
		while(true)
		{
			System.out.println(thread.getName());
			try {
				thread.sleep(800);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void start() {
		thread.start();
	}
}
