package ds.linkedlist.singly;

public class MainRunner {

	public static void getIntersectionPointRunner()
	{
		LinkedList<Integer> ll1 = new LinkedList<Integer>();
		ll1.insert.end(new Node<Integer>(1));
		ll1.insert.end(new Node<Integer>(2));
		ll1.insert.end(new Node<Integer>(3));
		ll1.insert.end(new Node<Integer>(4));
		ll1.insert.end(new Node<Integer>(5));
		ll1.insert.end(new Node<Integer>(6));

		LinkedList<Integer> ll2 = new LinkedList<Integer>();
		ll2.insert.end(new Node<Integer>(10));
		ll2.insert.end(new Node<Integer>(20));
		ll2.last.next=ll1.head.next.next.next.next;
		ll1.getIntersectionPoint( ll2).print();

	}
	public static void detectAndRemoveLoopRunner()
	{
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		linkedList.insert.end(new Node<Integer>(1));
		linkedList.insert.end(new Node<Integer>(2));
		linkedList.insert.end(new Node<Integer>(3));
		linkedList.insert.end(new Node<Integer>(4));
		linkedList.insert.end(new Node<Integer>(5));
		linkedList.insert.end(new Node<Integer>(6));
		linkedList.insert.end(new Node<Integer>(7));
		linkedList.last.next = linkedList.head.next.next.next;

		boolean result = linkedList.detectAndRemoveLoop();
		System.out.println(result);
		linkedList.print();

	}
	public static void cloneWithoutHashMapRunner() {
		LinkedList<Integer> llRandom = new LinkedList<Integer>();
		llRandom.insert.end(new Node<Integer>(1)); 		llRandom.insert.end(new Node<Integer>(2));
		llRandom.insert.end(new Node<Integer>(3)); 		llRandom.insert.end(new Node<Integer>(4));
		llRandom.insert.end(new Node<Integer>(5));
		llRandom.head.random = llRandom.head.next.next;
		llRandom.head.next.next.random = llRandom.head.next.next.next.next;
		llRandom.head.next.next.next.next.random = llRandom.head.next.next.next;
		llRandom.head.next.next.next.random = llRandom.head.next;
		llRandom.head.next.random = null;
		llRandom.print(); //NormalOrder
		llRandom.printRandomOrder();
		LinkedList<Integer> clonedLL = llRandom.cloneWithoutHashMap();
		clonedLL.print(); //NormalOrder
		clonedLL.printRandomOrder();

	}
	public static void cloneWithHashMapHelpRunner() {
		LinkedList<Integer> llRandom = new LinkedList<Integer>();
		llRandom.insert.end(new Node<Integer>(1)); 		llRandom.insert.end(new Node<Integer>(2));
		llRandom.insert.end(new Node<Integer>(3)); 		llRandom.insert.end(new Node<Integer>(4));
		llRandom.insert.end(new Node<Integer>(5));
		llRandom.head.random = llRandom.head.next.next;
		llRandom.head.next.next.random = llRandom.head.next.next.next.next;
		llRandom.head.next.next.next.next.random = llRandom.head.next.next.next;
		llRandom.head.next.next.next.random = llRandom.head.next;
		llRandom.head.next.random = null;
		llRandom.print(); //NormalOrder
		llRandom.printRandomOrder();
		LinkedList<Integer> clonedLL = llRandom.cloneWithHashMapHelp();
		clonedLL.print(); //NormalOrder
		clonedLL.printRandomOrder();

	}

	public static void  reverseIterationRunner() {
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		linkedList.insert.end(new Node<Integer>(1));
		linkedList.insert.end(new Node<Integer>(2));
		linkedList.insert.end(new Node<Integer>(3));
		linkedList.insert.end(new Node<Integer>(4));
		linkedList.insert.end(new Node<Integer>(5));
		linkedList.insert.end(new Node<Integer>(6));
		linkedList.insert.end(new Node<Integer>(7));
		linkedList.print();
		linkedList.reverseIteration();
		System.out.println("After reversal");
		linkedList.print();
	}

	public static void main(String[] args)
	{
		reverseIterationRunner();
	}
}
