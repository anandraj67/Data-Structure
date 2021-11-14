package thread.communication.producer_consumer_with_queue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
    private BlockingQueue<Integer> queue;
    private Thread thread;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
        this.thread = new Thread(this);
    }

    @Override
    public void run() {
        for(int i=0;i<11;i++){

            try {
                // Integer a = queue.remove(); only put and take blocks, add and remove thorws exceptions
                Integer a = queue.take();
                System.out.println("Removed " + a);
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void consume(){
        thread.start();
    }
}
