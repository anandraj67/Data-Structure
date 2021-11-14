package thread.communication.producer_consumer_with_queue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{
    private BlockingQueue queue;
    private Thread thread;

    public Producer(BlockingQueue queue) {
        this.queue = queue;
        this.thread = new Thread(this);
    }

    @Override
    public void run() {
        for(int i=0;i<11;i++){
            try {
                // queue.add(i); only put and take blocks, add and remove thorws exceptions
                queue.put(i);
                System.out.println("Added " + i);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void produce(){
        thread.start();
    }
}
