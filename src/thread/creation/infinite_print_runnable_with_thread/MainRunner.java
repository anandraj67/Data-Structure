package thread.creation.infinite_print_runnable_with_thread;

public class MainRunner {
    public static void main(String[] args) {
        InfinitePrintRunnableWithThread infinitePrintRunnableWithThread =  new InfinitePrintRunnableWithThread("Prady");
        infinitePrintRunnableWithThread.start();
    }
}
