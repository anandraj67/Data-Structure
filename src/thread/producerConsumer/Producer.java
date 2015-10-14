package thread.producerConsumer;

public class Producer implements Runnable{

	public Thread t;
	public Product product;
	
	public Producer(Product product,String name) {
		t = new Thread(this,name);
		this.product = product;
	}
	
	@Override
	public void run() {
		for (int i=0;i<10;i++)
		{
			this.product.increaseQuantity();
		}
	}

	public void produce()
	{
		t.start();
	}
	
}
