package thread.printer;

public class PrinterJob implements Runnable{

	public Thread t;
	public Printer printer;
	public PrinterJob(String name,Printer printer ) {
		this.t = new Thread(this,name );
		this.printer = printer;
	}
	@Override
	public void run() {
		printer.print();
	}
	
	public void print()
	{
		t.start();
	}

}
