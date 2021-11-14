package thread.communication.implement_blocking_queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class MyBlockingQueue<T> {
    private Queue<T> queue;
    private int  limit;

    public MyBlockingQueue(int limit){
        this.limit = limit;
        queue = new ArrayDeque();
    }

    public void enqueue(T item) throws InterruptedException {
        synchronized (this){
            if(queue.size() == limit){
                System.out.println("To wait for queue to remove");
                this.wait();
            }
            queue.add(item);
            System.out.println("Added " + item);
            if(this.queue.size() == 1) this.notifyAll();
        }

    }

    public T dequeue() throws InterruptedException {
        T t;
        synchronized (this){
            if(queue.size() == 0){
                System.out.println("To wait for queue to add");
                this.wait();
            }
            t = queue.remove();
            System.out.println("Removed " + t);
            if(this.queue.size() == this.limit-1) this.notifyAll();
        }
        return t;
    }

}
