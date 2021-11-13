package thread.creation.finite_print_runnable;

public class FinitePrintRunnable implements Runnable {

	int count;
	public FinitePrintRunnable(int count) {
		this.count = count;
	}

	@Override
	public void run() {
		int i = count;
		while(i>=0) {
			System.out.println(Thread.currentThread().getName() + " " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			i--;
		}
	}
}
