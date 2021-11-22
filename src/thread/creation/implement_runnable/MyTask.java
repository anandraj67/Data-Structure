package thread.creation.implement_runnable;

public class MyTask implements Runnable {

	public MyTask() {
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
