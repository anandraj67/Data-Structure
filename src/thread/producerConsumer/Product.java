package thread.producerConsumer;

public class Product {

	int quantity;
	public Product(int quantity) {
		this.quantity = quantity;
	}
	synchronized public void reduceQuantity()
	{
		if(this.quantity <= 0)
		{
			System.out.println("koi produce karo bhai...");
			try{wait();}catch(Exception e){}
		}
		System.out.println(Thread.currentThread().getName() + " " + "Quantity = "+ this.quantity);
		this.quantity --;
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
		
	}
	synchronized public void increaseQuantity()
	{
		System.out.println(Thread.currentThread().getName() + " " + "Quantiti = "+ this.quantity);
		this.quantity++;
		notify();
		try {
			Thread.sleep(700);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
