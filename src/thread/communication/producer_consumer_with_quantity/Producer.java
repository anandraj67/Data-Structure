package thread.communication.producer_consumer_with_quantity;

public class Producer implements Runnable{

	private Thread t;
	private Product product;
	private int toProduce;
	private String name;

	public Producer(Product product, String name, int toProduce) {
		this.t = new Thread(this, name);
		this.product = product;
		this.toProduce = toProduce;
	}

	@Override
	public void run() {
		while (toProduce > 0) {
			try {
				this.product.increaseQuantity();
				toProduce--;
				Thread.sleep(150);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void produce() {
		t.start();
	}

	
}
