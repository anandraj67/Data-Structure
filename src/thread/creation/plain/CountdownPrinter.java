package thread.creation.plain;

public class CountdownPrinter {
    int count;
    public CountdownPrinter(int count) {
        this.count = count;
    }

    public void print() {
        int i = count;
        while(i>=0) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i--;
        }
    }
}
