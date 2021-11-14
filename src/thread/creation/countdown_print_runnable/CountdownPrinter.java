package thread.creation.countdown_print_runnable;

public class CountdownPrinter implements Runnable {

	int count;
	public CountdownPrinter(int count) {
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
