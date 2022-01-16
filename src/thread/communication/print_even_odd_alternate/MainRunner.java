package thread.communication.print_even_odd_alternate;

public class MainRunner {
    public static void main(String[] args) throws  InterruptedException{
        Screen screen = new Screen(1);

        Thread odd = new Thread(()->{
            try {
                for(int i=1;i<=9;i+=2) {// This can be separate class(Odd Printer)
                    screen.print(i);
                }
            } catch (InterruptedException e) {
                    e.printStackTrace();
            }
        }, "Odd");

        Thread even = new Thread(()->{
            try {
                for(int i=2;i<=10;i+=2){ // This can be separate class(Even Printer)
                    screen.print(i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Even");

        odd.start();
        even.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        odd.start();
        even.start();

    }


}
