package ds.linkedlist.singly;

import java.util.HashMap;
import java.util.Map;

// java has its own in java.util
// SingleLinkedList<Integer> linkedList = new SingleLinkedList<Integer>();
public class SingleLinkedList<Type>
{
	public Node<Type> head;

	public SingleLinkedList(){
		head = null;
	}
    public void insert_beginning(Node<Type> newNode){
        newNode.next = head;
        head = newNode;
    }
    public void insert_end(Node<Type> newNode){
        newNode.next = null;
        if( isEmpty() )
            head = newNode;
        else
        {
            // OR last.next= newNode; last = newNode;
            Node<Type> iterator = head;
            while(iterator.next != null)
                iterator = iterator.next;
            iterator.next = newNode;
        }
    }
    public void insert_after(Node<Type> newNode,Node<Type> after){
        //todo
    }
    public void insert_at_position(int position, Node<Type> newNode){
        if(position > SingleLinkedList.this.size())
            return;
        if(position==0){
            newNode.next = head;
            head = newNode;
        }else{
            Node<Type> iter = head;
            while (position>1){
                iter = iter.next;
                position--;
            }
            newNode.next = iter.next;
            iter.next = newNode;
        }
    }
    public void delete_beginning(){
        if(!isEmpty())
            head = head.next;
    }
    public void delete_end(){
        if( head == null || head.next == null)
        {
            head = null;
        }
        else
        {
            Node<Type> iterator = head;
            while(iterator.next.next != null)
                iterator = iterator.next;
            iterator.next = null;
        }
    }
    public void delete_node(Node<Type> node){
        //todo
    }
    public void delete_at_position(int position){
        //todo
    }
	public int size(){
		Node<Type> iterator = head;
		int len= 0 ;
		while(iterator != null)
		{
			len++;
			iterator=iterator.next;
		}
		return len;
	}
	public boolean isEmpty(){
		return (head == null);
	}
	public void print(){
		Node<Type> node = this.head;
		while(node != null)
		{
			node.print();
			node = node.next;
		}
		System.out.println(" ");
	}
    public void printRandomOrder(){
        System.out.println("The linked list in Random order is : ");
        Node<Type> iter = this.head;
        while(iter != null)
        {
            System.out.print(iter.data +" ");
            iter = iter.random;
        }
        System.out.println(" ");
    }
    /**
     * @Sawal
     * 	Reverse a linked list with iteration
     * @Jawab
     * 	Take three pointer to null first and second
     * 	Reverse pointer of first and second
     *	Increment all three.
     */
    public void reverseIteration() {
        Node<Type> first = null;
        Node<Type> second = this.head;
        Node<Type> third;

        while(second !=null) 		// because connection of second and
        {							// first is to be reversed
            third = second.next;
            second.next = first;

            first = second;		// Increment
            second = third;
        }
        this.head = first;
    }
    /**
     * @Sawal
     * 	Reverse a linked list with Recursion
     * @Jawab
     * 	Base case : null or single node.
     * 	Recursively call for next node.
     *	After returning link reversed last to node
     *		and  node to null.
     *	Every recursive step is returning head of reversed.
     */
    private Node<Type> reverseRecurssion_(Node<Type> node) {
        if(node == null || node.next == null) 	// Base case
            return node;
        Node<Type> nodeReturned = reverseRecurssion_(node.next);
        node.next.next = node;
        node.next =null;
        return nodeReturned;
    }
    public void reverseRecurssion() {
        this.head = reverseRecurssion_(this.head);
    }
	/**
	 * @Sawal
	 * 1->2->3->4->5->6
	 *       <---------
	 * If loop is present in the linked list remove it.
	 * @Jawab
	 * 	Move one pointer slow and one fast,
	 *		If loop is there both pointers will meet somewhere in the loop.
	 *		If not then the second pointer will leave the list.
	 * 	For removal of loop:
	 * 		First count the nodes in the loop.Say d.
	 * 		Keep a distance d between two pointers ,move both 1,
	 * 		 they will meet at merge point.
	 * 		Unlink the previous node.
	 */
	boolean detectAndRemoveLoop(){
		Node<Type> first = this.head;
		Node<Type> second = this.head;
		while(second != null && second.next != null )
		{
			first = first.next; // Moves one step
			second = second.next.next; // Moves two step
			if(first == second) // Now first and second both are
			{					//at same position somewhere in the loop
				Node<Type> third = this.head;
				do		 // length of loop
				{
					second = second.next;
					third = third.next;  // to point d dis away from head
				}while(second != first);

				first = this.head;
				while(first != third) // Both will meet a merger point
				{
					first = first.next;
					third = third.next;
				}
				while(third.next != first) // iterate to one node prev to mergerpoint.
				{
					third = third.next;
				}
				third.next = null ; // unlinking the loop
				return true; // loop was there which is removed
			}
		}
		return false; // No loop is there
	}
	/**
	 * @Sawal
	 *  Write a function to get the intersection point of two Linked Lists.
	 * @Jawab
	 *  Find the difference in length of two list,say d.</br>
	 *  keep 1 pointer d distance away in longer list.
	 *  Both will meet at intersection point.
	 */
	Node<Type> getIntersectionPoint(SingleLinkedList<Type> ll2){
		Node<Type> iterBig = null;
		Node<Type> iterSmall = null;
		int lenght1 = this.size();
		int lenght2 = ll2.size();
		if(lenght1 > lenght2)
		{
			iterBig = this.head;
			iterSmall = ll2.head;
		}
		else
		{
			iterBig = ll2.head;
			iterSmall = this.head;
		}
		int diff = Math.abs(lenght1- lenght2);
		while(diff !=0)
		{
			iterBig = iterBig.next;
			diff--;
		}
		while(iterBig != iterSmall)
		{
			iterBig = iterBig.next;
			iterSmall = iterSmall.next;
		}
		return iterBig;
	}
	/**
	 * @Sawal
	 * 	Makes a copy of the random pointer linked list.
	 * @Jawab
	 * 	Copy the normal pointer and keep the
	 * 		mapping of original to  new node in Hash map.
	 * 	Then iterate again and fix the random pointer.
	 */
	public SingleLinkedList<Type> cloneWithHashMapHelp(){
		Node<Type> originalNode = this.head;
		SingleLinkedList<Type> clonedList = new SingleLinkedList<Type>();
		Map<Node<Type>, Node<Type>> map = new HashMap<Node<Type>, Node<Type>>();
		Node<Type> clonedNode = null;

		// Loop for normal pointer and saving the map
		while(originalNode!=null)
		{
			clonedNode = new Node<Type>(originalNode.data);
			clonedList.insert_end(clonedNode);
			map.put(originalNode, clonedNode);
			originalNode = originalNode.next;
		}

		originalNode = this.head;
		// Loop for random pointer
		while(originalNode != null)
		{
			map.get(originalNode).random = map.get( originalNode.random );
			originalNode = originalNode.next;
		}
		return clonedList;
	}
	/**
	 * @Sawal
	 * 	Makes a copy of the random pointer linked list.
	 * @Jawab
	 * 	Copy the normal pointer and keep the
	 * 		mapping of original to  new node by connecting
	 * 		next of 1st list and random of 2nd list with each other.
	 * 	Then iterate again and fix the
	 * 		random pointer of 2nd list and
	 * 		the next pointer of first list.
	 */
	public SingleLinkedList<Type> cloneWithoutHashMap(){
		Node<Type> iter = this.head;
		SingleLinkedList<Type> clonedList = new SingleLinkedList<Type>();
		Node<Type> clonedNode = null;

		// Loop in original list and linking the two list
		while(iter!=null)
		{
			clonedNode = new Node<Type>(iter.data);
			clonedList.insert_end(clonedNode);
			Node<Type> nextNode = iter.next;
			iter.next = clonedNode;
			clonedNode.random = iter;
			iter = nextNode;
		}

		iter = clonedList.head;
		// Loop in cloned list and link the random pointer
		while(iter != null)
		{
			iter.random.next = (iter.next!=null)?iter.next.random:null;
			iter.random = (iter.random.random!=null)?iter.random.random.next:null;
			iter = iter.next;
		}
		return clonedList;
	}
	/**
	 * @Sawal
	 *  Reverse linked list in chunk
	 * @Jawab
	 *  3 pointers for internal reversal.
	 *  At the end of 2nd chunk. 1st and 2nd will be connected.
	 *  So keeping 2 chunkVariables.
	 */
	public void reverseInChunkIterIter(int chunkSize){
		Node<Type> first = null;
		Node<Type> second = this.head;
		Node<Type> third ;
		Node<Type> chunkFirst=this.head ;
		Node<Type> chunkSecond = null;
		int k = chunkSize;
		boolean isFirstPass = true;
		// (1 2 3) (4 5 6) (7 8 9 ) 8 3
		while(second != null)
		{
			third = second.next;
			second.next = first;
			first = second;
			second = third;
			k--;
			if(k==0 || second == null)
			{
				if(isFirstPass == true)
				{
					this.head = first;
					isFirstPass = false;
				}
				else
				{
					chunkFirst.next = first;
					chunkFirst = chunkSecond;
				}
				chunkSecond = second;
				k = chunkSize;
				first = null;
			}
		}
	}
    /**
     *
     * @Sawal
     * Merge to sorted linked list
     * ll1: 2 4
     * ll2: 1 3 5
     * @Jawab
     * Take a last pointer and 2 iterators
     * Move the iterator which is of lower value.
     */
    public  static SingleLinkedList<Integer>  merge_sorted_linked_lists(SingleLinkedList<Integer> ll1,SingleLinkedList<Integer> ll2){
        Node<Integer> iter1 = ll1.head;
        Node<Integer> iter2 = ll2.head;
        SingleLinkedList<Integer> ll = new SingleLinkedList<Integer>();
        if(iter1 == null || iter2 == null){
            ll.head = (iter1 == null ) ? iter2 : iter1;
        }else{
            ll.head = (iter1.data > iter2.data) ? iter2 : iter1;
        }
        ll1.head = null;
        ll2.head = null;
        Node<Integer> last = null;
        while (iter1!=null && iter2!=null){
            if(iter1.data < iter2.data){
                if (last!=null)
                    last.next = iter1;
                last = iter1;
                iter1 = iter1.next;
            }else if(iter2.data < iter1.data) {
                if (last!=null)
                    last.next = iter2;
                last = iter2;
                iter2 = iter2.next;
            }
        }
        if(last!= null){
            last.next = (iter1==null)? iter2:iter1;
        }
        return ll;
    }
}
