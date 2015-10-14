package thread.evenOdd;

public class PrintOdd implements Runnable {

	public Lock lock;
	public Thread t;

	public PrintOdd(Lock lock) {
		this.lock = lock;
		t = new Thread(this, "Odd");
	}

	@Override
	public void run() {
		this.printSync();
	}

	public void printSync() {
		Lock [] l = new Lock[10];
		synchronized (l) {
			for (int i = 1; i <= 19; i += 2) {
				if (this.lock.turnOdd == false) {
					try {
						this.lock.wait();
					} catch (InterruptedException e1) {
					}
				}
				System.out.println(i);
				try {
					Thread.sleep(300);
				} catch (Exception e) {
				}
				this.lock.turnOdd = false;
				this.lock.notify();
			}
		}
	}

	public void print() {
		t.start();
	}
}
