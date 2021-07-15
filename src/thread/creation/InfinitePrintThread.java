package thread.creation;

public class InfinitePrintThread extends Thread {
	public InfinitePrintThread(String name) {
		super(name);
	}

	@Override
	public void run() {
		while(true)
		{
			System.out.println(Thread.currentThread().getName());
			try {
				Thread.sleep(900);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
