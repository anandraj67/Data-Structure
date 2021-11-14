package thread.communication.producer_consumer_with_quantity;

public class Product {

	int quantity;

	public Product(int quantity) {
		this.quantity = quantity;
	}

	synchronized public void reduceQuantity() throws InterruptedException
	{
		if(this.quantity <= 0) {
			System.out.println(Thread.currentThread().getName() + "  Insufficient quantity to consume");
			wait();
		}
		Thread.sleep(200);
		this.quantity --;
		System.out.println(Thread.currentThread().getName() + " " + "After reducing, Quantity = "+ this.quantity);
	}

	synchronized public void increaseQuantity() throws InterruptedException{
		Thread.sleep(250);
		this.quantity++;
		System.out.println(Thread.currentThread().getName() + " " + "After increasing Quantity = "+ this.quantity);
		if(this.quantity == 1) notify();
	}
}
