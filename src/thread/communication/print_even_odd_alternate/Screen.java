package thread.communication.print_even_odd_alternate;

public class Screen {
    int turn;

    public Screen(int turn) {
        this.turn = turn;
    }

    public void print(int i) throws InterruptedException {
        synchronized (this){
            if(i%2 != turn) this.wait();
            Thread.sleep(700);
            System.out.println(i);
            this.notify();
            turn = (i+1)%2;
        }
    }
}
