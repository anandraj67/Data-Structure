package thread.creation.$3implement_runnable_with_thread;

public class CountdownPrinter implements Runnable {
	Thread thread;
	public CountdownPrinter(String name) {
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
