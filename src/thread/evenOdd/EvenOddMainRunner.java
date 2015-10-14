package thread.evenOdd;

public class EvenOddMainRunner {

	// Two different thread :no syncronized function
	// inter-thread communication : wait and notify
	public static void main(String[] args)
	{
		Lock lock = new Lock();
		PrintOdd printOdd = new PrintOdd(lock);
		PrintEven printEven = new PrintEven(lock);

		printOdd.print();
		printEven.print();


	}

	// another question
	// 1000 array sum
}
