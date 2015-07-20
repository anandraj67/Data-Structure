package ds.linkedlist.random;

import ds.linkedlist.random.Node;
public class MainRunner {

	public static void main(String[] args)
	{
		LinkedListWithRandomPointer<Integer> llRandom = new LinkedListWithRandomPointer<Integer>();
		llRandom.insert.end(new Node<Integer>(1)); 		llRandom.insert.end(new Node<Integer>(2));
		llRandom.insert.end(new Node<Integer>(3)); 		llRandom.insert.end(new Node<Integer>(4));
		llRandom.insert.end(new Node<Integer>(5));
		llRandom.head.random = llRandom.head.next.next;
		llRandom.head.next.next.random = llRandom.head.next.next.next.next;
		llRandom.head.next.next.next.next.random = llRandom.head.next.next.next;
		llRandom.head.next.next.next.random = llRandom.head.next;
		llRandom.head.next.random = null;
		llRandom.printNormalOrder();
		llRandom.printRandomOrder();

		//LinkedListWithRandomPointer<Integer> clonedLL = llRandom.clone();
		LinkedListWithRandomPointer<Integer> clonedLL = llRandom.cloneWithoutExtraSpace();
		clonedLL.printNormalOrder();
		clonedLL.printRandomOrder();

		/*
		 * The linked list in normal order is :
			1 2 3 4 5
			The linked list in Random order is :
			1 3 5 4 2
		 */
	}
}
