package ds.linkedlist.singly;

public class MainRunner {

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

    public static void main(String[] args)
	{
	}
}
