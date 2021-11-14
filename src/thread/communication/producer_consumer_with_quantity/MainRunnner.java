package thread.communication.producer_consumer_with_quantity;

public class MainRunnner {
	
	public static void main(String [] argv)
	{
		Product product = new Product(1);
		Consumer consumer1 = new Consumer(product,"raju",2);
		Consumer consumer2 = new Consumer(product,"mohan",3);
		Producer producer = new Producer(product,"Shopkeeper", 4) ;

		producer.produce();
		consumer1.consume();
		consumer2.consume();
	}
}
