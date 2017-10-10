package ds.linkedlist.singly;

public class MainRunner {

	public static void getIntersectionPointRunner()
	{
		SingleLinkedList<Integer> ll1 = new SingleLinkedList<Integer>();
		ll1.insert_end(new Node<Integer>(1));
		ll1.insert_end(new Node<Integer>(2));
		ll1.insert_end(new Node<Integer>(3));
		ll1.insert_end(new Node<Integer>(4));
		ll1.insert_end(new Node<Integer>(5));
		ll1.insert_end(new Node<Integer>(6));

		SingleLinkedList<Integer> ll2 = new SingleLinkedList<Integer>();
		ll2.insert_end(new Node<Integer>(10));
		ll2.insert_end(new Node<Integer>(20));
		ll2.head.next.next=ll1.head.next.next.next.next;
		ll1.getIntersectionPoint( ll2).print();

	}
	public static void detectAndRemoveLoopRunner()
	{
		SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<Integer>();
		singleLinkedList.insert_end(new Node<Integer>(1));
		singleLinkedList.insert_end(new Node<Integer>(2));
		singleLinkedList.insert_end(new Node<Integer>(3));
		singleLinkedList.insert_end(new Node<Integer>(4));
		singleLinkedList.insert_end(new Node<Integer>(5));
		singleLinkedList.insert_end(new Node<Integer>(6));
		singleLinkedList.insert_end(new Node<Integer>(7));
		singleLinkedList.head.next.next.next.next.next.next.next  = singleLinkedList.head.next.next.next;

		boolean result = singleLinkedList.detectAndRemoveLoop();
		System.out.println(result);
		singleLinkedList.print();

	}
	public static void cloneWithoutHashMapRunner() {
		SingleLinkedList<Integer> llRandom = new SingleLinkedList<Integer>();
		llRandom.insert_end(new Node<Integer>(1)); 		llRandom.insert_end(new Node<Integer>(2));
		llRandom.insert_end(new Node<Integer>(3)); 		llRandom.insert_end(new Node<Integer>(4));
		llRandom.insert_end(new Node<Integer>(5));
		llRandom.head.random = llRandom.head.next.next;
		llRandom.head.next.next.random = llRandom.head.next.next.next.next;
		llRandom.head.next.next.next.next.random = llRandom.head.next.next.next;
		llRandom.head.next.next.next.random = llRandom.head.next;
		llRandom.head.next.random = null;
		llRandom.print(); //NormalOrder
		llRandom.printRandomOrder();
		SingleLinkedList<Integer> clonedLL = llRandom.cloneWithoutHashMap();
		clonedLL.print(); //NormalOrder
		clonedLL.printRandomOrder();

	}
	public static void cloneWithHashMapHelpRunner() {
		SingleLinkedList<Integer> llRandom = new SingleLinkedList<Integer>();
		llRandom.insert_end(new Node<Integer>(1)); 		llRandom.insert_end(new Node<Integer>(2));
		llRandom.insert_end(new Node<Integer>(3)); 		llRandom.insert_end(new Node<Integer>(4));
		llRandom.insert_end(new Node<Integer>(5));
		llRandom.head.random = llRandom.head.next.next;
		llRandom.head.next.next.random = llRandom.head.next.next.next.next;
		llRandom.head.next.next.next.next.random = llRandom.head.next.next.next;
		llRandom.head.next.next.next.random = llRandom.head.next;
		llRandom.head.next.random = null;
		llRandom.print(); //NormalOrder
		llRandom.printRandomOrder();
		SingleLinkedList<Integer> clonedLL = llRandom.cloneWithHashMapHelp();
		clonedLL.print(); //NormalOrder
		clonedLL.printRandomOrder();

	}
	public static void  reverseIterationRunner() {
		SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<Integer>();
		singleLinkedList.insert_end(new Node<Integer>(1));
		singleLinkedList.insert_end(new Node<Integer>(2));
		singleLinkedList.insert_end(new Node<Integer>(3));
		singleLinkedList.insert_end(new Node<Integer>(4));
		singleLinkedList.insert_end(new Node<Integer>(5));
		singleLinkedList.insert_end(new Node<Integer>(6));
		singleLinkedList.insert_end(new Node<Integer>(7));
		singleLinkedList.print();
		singleLinkedList.reverseIteration();
		System.out.println("After reversal");
		singleLinkedList.print();
	}
	public static void  reverseRecurssionRunner() {
		SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<Integer>();
		singleLinkedList.insert_end(new Node<Integer>(1));
		singleLinkedList.insert_end(new Node<Integer>(2));
		singleLinkedList.insert_end(new Node<Integer>(3));
		singleLinkedList.insert_end(new Node<Integer>(4));
		singleLinkedList.insert_end(new Node<Integer>(5));
		singleLinkedList.insert_end(new Node<Integer>(6));
		singleLinkedList.insert_end(new Node<Integer>(7));
		singleLinkedList.print();
		singleLinkedList.reverseRecurssion();
		System.out.println("After reversal");
		singleLinkedList.print();
	}
	public static void  reverseInChunkIterIterRunner() {
		SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<Integer>();
		singleLinkedList.insert_end(new Node<Integer>(1));
		singleLinkedList.insert_end(new Node<Integer>(2));
		singleLinkedList.insert_end(new Node<Integer>(3));
		singleLinkedList.insert_end(new Node<Integer>(4));
		singleLinkedList.insert_end(new Node<Integer>(5));
		singleLinkedList.insert_end(new Node<Integer>(6));
		singleLinkedList.insert_end(new Node<Integer>(7));
		singleLinkedList.insert_end(new Node<Integer>(8));
		singleLinkedList.print();
		singleLinkedList.reverseInChunkIterIter(3);;
		System.out.println("After reversal");
		singleLinkedList.print();
	}

    public static void merge_sorted_linked_lists_runner() {
        SingleLinkedList<Integer> ll1 = new SingleLinkedList<Integer>();
        ll1.insert_end(new Node<Integer>(2));
        ll1.insert_end(new Node<Integer>(4));
        ll1.insert_end(new Node<Integer>(6));

        SingleLinkedList<Integer> ll2 = new SingleLinkedList<Integer>();
        ll2.insert_end(new Node<Integer>(3));
        ll2.insert_end(new Node<Integer>(5));
        ll2.insert_end(new Node<Integer>(7));
        ll2.insert_end(new Node<Integer>(9));

        SingleLinkedList<Integer> ll = SingleLinkedList.merge_sorted_linked_lists(ll1, ll2);
        ll.print();
    }

    public static void main(String[] args)
	{
        merge_sorted_linked_lists_runner();
	}
}
