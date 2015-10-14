package thread.producerConsumer;

public class ProducerConsumerMainRunnner {
	
	// syncronised fun in product class common to both
	// inter thread communication : wait() and notify() 
	public static void main(String [] argv)
	{
		Product product = new Product(15);
		Consumer consumer1 = new Consumer(product,"raju");
		Consumer consumer2 = new Consumer(product,"mohan");
		Producer producer = new Producer(product,"baniya bhaiya") ;
		
		producer.produce();
		
		consumer1.consume();
		consumer2.consume();
	}
	

}
