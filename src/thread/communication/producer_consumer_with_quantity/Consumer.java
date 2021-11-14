package thread.communication.producer_consumer_with_quantity;

public class Consumer implements Runnable{

	private Thread t;
	private Product product;
	private int toConsume;

	
	public Consumer(Product product, String name, int toConsume) {
		t = new Thread(this,name);
		this.product = product;
		this.toConsume = toConsume;
	}
	
	@Override
	public void run() {
		while (toConsume>0) {
			try {
				this.product.reduceQuantity();
				toConsume--;
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void consume() {
		t.start();
	}
	
}
