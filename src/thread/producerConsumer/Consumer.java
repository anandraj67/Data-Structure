package thread.producerConsumer;

public class Consumer implements Runnable{

	public Thread t;
	public Product product;
	
	public Consumer(Product product,String name) {
		t = new Thread(this,name);
		this.product = product;
	}
	
	@Override
	public void run() {
		for (int i=0;i<10;i++)
		{
			this.product.reduceQuantity();
		}
	}

	public void consume()
	{
		t.start();
	}
	
}
