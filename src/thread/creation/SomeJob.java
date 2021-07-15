package thread.creation;

public class SomeJob implements Runnable {
	Thread thread;
	public SomeJob(String name) {
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
