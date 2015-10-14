package thread.printer;

public class Printer {

	
	public Printer() {
		
	}
	
	 public void print()
	{
		 synchronized(this)
		 {
			for(int i=1; i<= 10; i++)
			{
				System.out.println(Thread.currentThread().getName() + " " +  i);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		 }
	}

}
