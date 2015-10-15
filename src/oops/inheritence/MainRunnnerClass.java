
package oops.inheritence;

interface ac
{
	int s=10;	
}

class aaa
{
	static final int aa=10;
	aaa()
	{ 	}
}

class base1 implements ac
{
	 int x = 10;;
	 base1()
	 {
		 //System.out.println("abstract class base.");
		 x=20;
	 }
	 public void foo()
	 {
		 System.out.println(s);
	 }	 
}
class derived1 extends base1
{
	public derived1() {
		super ();
		x = 1;
		
		System.out.println(x);
	}
	
	
}
 class base 
{
//	public int a;
//	private int b;
//	protected int c;
//	int d;
	//public    abstract void fooo();
	 
	 public void f1()
	 {
		 System.out.println("base wala");
	 }
	
}

class derived extends  base
{
	
//	public void foo()
//	{
//		int f = c;
//	}
	public void f1()
	 {
		 System.out.println("deri wala");
	 }
	
}
abstract class testAbstract
{
	abstract void foo();
}
public class MainRunnnerClass 
{	
	public static void main(String argv[])
	{
//		derived baseRef = new derived();
//		base b = new base();
//		System.out.println(b.x);
		
		//base bb = new derived();
		
		//derived d =new base(); // error remote
		
		
		
		//base b;
		//b = new derived();
		//b.f1();   
		//b = new base(); 
		
		
		//b.f1();
		//int xx = bb.c;
		
		base1 h = new base1();
		System.out.println(h.x);
		
	}

}
