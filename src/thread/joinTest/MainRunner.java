package thread.joinTest;

import java.util.HashMap;

public class MainRunner {

	/**
	 * @param args
	 * @throws Exception
	 */
	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
//		Thread thread = new Thread(new Runnable() {
//			@Override
//			public void run() {
//				int value =10;
//				while(value >0)
//				{
//					System.out.print(Thread.currentThread().getName() +  " ");
//					System.out.println(value);
//					value--;
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//					}
//				}
//			}
//		},"Thread");
//		thread.start();
//		//thread.join();
//		int value =100;
//		while(value >90)
//		{
//			System.out.print(Thread.currentThread().getName());
//			System.out.println(value);
//			value--;
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//			}
//		}

//		SomeJob sj1 = new SomeJob("one");
//		sj1.start();
//
//		SomeJob sj2 = new SomeJob("two");
//		sj2.start();

		Thread t = new Thread("lkasj");
		t.start();



	}

}
