package ds.linkedlist.singly;

import java.util.HashMap;
import java.util.Map;

public class SingleLinkedList<Type> {
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
	public static int size(Node head){
		Node iterator = head;
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

}
