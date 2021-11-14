package thread.communication.implement_blocking_queue;

public class MainRunner {
    public static void main(String[] args) throws InterruptedException {
        MyBlockingQueue<Integer> myBlockingQueue = new MyBlockingQueue<>(3);

        new Thread(()-> { // This is producer
            try {
                myBlockingQueue.enqueue(1);
                Thread.sleep(400);
                myBlockingQueue.enqueue(2);
                Thread.sleep(400);
                myBlockingQueue.enqueue(3);
                Thread.sleep(400);

                myBlockingQueue.enqueue(4);// wait
                Thread.sleep(400);
                myBlockingQueue.enqueue(5);

                Thread.sleep(3500);
                myBlockingQueue.enqueue(6);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()-> { // This is consumer
            try {
                Thread.sleep(2200);
                myBlockingQueue.dequeue();
                Thread.sleep(400);
                myBlockingQueue.dequeue();
                Thread.sleep(400);

                myBlockingQueue.dequeue();
                Thread.sleep(400);
                myBlockingQueue.dequeue();
                Thread.sleep(400);
                myBlockingQueue.dequeue();
                Thread.sleep(400);

                myBlockingQueue.dequeue();// wait

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


    }
}
