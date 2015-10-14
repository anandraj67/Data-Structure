package thread.printer;

public class PrinterMainRunners {
	// Syncronised fun in printer class,
	//	which is common to both thread.
	public static void main(String [] argv)
	{
		Printer p = new  Printer();
		PrinterJob pj1 = new PrinterJob("pehla",p);
		PrinterJob pj2 = new PrinterJob("doosara",p);
		
		//p1.t.setPriority(Thread.MAX_PRIORITY);
		//p2.t.setPriority(Thread.MIN_PRIORITY);
		
		pj1.print();
		pj2.print();
		
	}
	

}
