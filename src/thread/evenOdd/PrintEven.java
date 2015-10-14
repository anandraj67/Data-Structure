package thread.evenOdd;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.tree.TreeNode;

public class PrintEven implements Runnable{

	public Lock lock;
	public Thread t;
	public PrintEven(Lock lock) {
		this.lock = lock;
		t = new Thread(this,"Even");
	}
	@Override
	public void run() {
		this.printSync();
	}
	
	public void printSync()
	{
		synchronized (lock) {
			for (int i=2;i<=20;i+=2)
			{
				if(this.lock.turnOdd == true)
				{
					try { this.lock.wait(); } catch (InterruptedException e1) {}
					
				}
				System.out.println(i);
				try { Thread.sleep(200); } catch(Exception e) {}
				this.lock.turnOdd = true;
				this.lock.notify();
			}
		}
	}
	
	public void print()
	{
		t.start();
	}
}
