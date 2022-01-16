package thread.creation.$2implement_runnable;

public class MyRunnable implements Runnable {

	public MyRunnable() {
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " Start");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " End");
	}
}
