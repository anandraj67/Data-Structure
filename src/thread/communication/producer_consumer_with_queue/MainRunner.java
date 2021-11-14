package thread.communication.producer_consumer_with_queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MainRunner {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue(6);
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        producer.produce();
        consumer.consume();

    }
}
