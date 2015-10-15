package ds.linkedlist.singly;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

// java has its own in java.util
// LinkedList<Integer> linkedList = new LinkedList<Integer>();
public class LinkedList <Type>
{
	public Node<Type> head;
	public Node<Type> last;

	public insert insert;
	public delete delete;

	public LinkedList()
	{
		head = last= null;
		insert = new insert();
		delete = new delete();
	}

	public class insert
	{
		public void begnning(Node<Type> newNode)
		{
		    newNode.next = head;
		    if( isEmpty() )
		    	last = newNode;
		    head = newNode;
		}

		public void end(Node<Type> newNode)
		{
			newNode.next = null;
			if( isEmpty() )
				head = last = newNode;
			else
			{
				// OR last.next= newNode; last = newNode;
				Node<Type> iterator = head;
				while(iterator.next != null)
					iterator = iterator.next;
				iterator.next = newNode;
				last = newNode;
			}
		}
	}

	public class delete // TO-DO : free memory in c++
	{
		public void begnning()
		{
			if(!isEmpty())
				head = head.next;
			if(isEmpty())
				last = null;
		}

		public void end()
		{
			if( head == null || head.next == null)
			{
				head = last = null;
			}
			else
			{
				Node<Type> iterator = head;
				while(iterator.next.next != null)
					iterator = iterator.next;
				iterator.next = null;
				last = iterator;
			}
		}
	}

	public int size()
	{
		Node<Type> iterator = head;
		int len= 0 ;
		while(iterator != null)
		{
			len++;
			iterator=iterator.next;
		}
		return len;
	}

	public boolean isEmpty()
	{
		return (head == null);
	}

	public void print()
	{
		Node<Type> node = this.head;
		while(node != null)
		{
			node.print();
			node = node.next;
		}
		System.out.println(" ");
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
	boolean detectAndRemoveLoop()
	{
		Node<Type> first = this.head;
		Node<Type> second = this.head;
		while(second != null && second.next != null )
		{
			first = first.next; // Moves one step
			second = second.next.next; // Moves teo step
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
	Node<Type> getIntersectionPoint(LinkedList<Type> ll2)
	{
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

	public void printRandomOrder()
	{
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
	 * 	Makes a copy of the random pointer linked list.
	 * @Jawab
	 * 	Copy the nornal pointer and keep the
	 * 		mapping of origianl to  new node in Hash map.
	 * 	Then iterate again and fix the random pointer.
	 */
	public LinkedList <Type> cloneWithHashMapHelp()
	{
		Node<Type> originalNode = this.head;
		LinkedList <Type> clonedList = new LinkedList<Type>();
		Map<Node<Type>, Node<Type>> map = new HashMap<Node<Type>, Node<Type>>();
		Node<Type> clonedNode = null;

		// Loop for normal pointer and saving the map
		while(originalNode!=null)
		{
			clonedNode = new Node<Type>(originalNode.data);
			clonedList.insert.end(clonedNode);
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
	public LinkedList <Type> cloneWithoutHashMap()
	{
		Node<Type> originalNode = this.head;
		LinkedList<Type> clonedList = new LinkedList<Type>();
		Node<Type> clonedNode = null;

		// Loop for normal pointer and linking the two list
		while(originalNode!=null)
		{
			clonedNode = new Node<Type>(originalNode.data);
			clonedList.insert.end(clonedNode);
			Node<Type> nextNode = originalNode.next;
			originalNode.next = clonedNode;
			clonedNode.random = originalNode;
			originalNode = nextNode;
		}

		originalNode = this.head;
		// Loop for linking random pointer
		while(originalNode != null)
		{
			originalNode.next.random = (originalNode.random!=null)?originalNode.random.next:null;
			originalNode.next = (originalNode.next!=null)?originalNode.next.next:null;
			originalNode = originalNode.random;
		}
		return clonedList;
	}

	/**
	 * @Sawal
	 * 	Reverse a linked list with iteration
	 * @Jawab
	 * 	Take three pointer to null first and second
	 * 	Reverse pointer of first and second
	 *	Increment all three.
	 */
	public void reverseIteration()
	{
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
	private Node<Type> reverseRecurssion_(Node<Type> node)
	{
		if(node == null || node.next == null) 	// Base case
			return node;
		Node<Type> nodeReturned = reverseRecurssion_(node.next);
		node.next.next = node;
		node.next =null;
		return nodeReturned;
	}
	public void reverseRecurssion()
	{
		this.head = reverseRecurssion_(this.head);
	}
	/**
	 * @Sawal
	 *  Reverse linked list in chunk
	 * @Jawab
	 *  3 pointers for internal reversal.
	 *  At the end of 2nd chunk. 1st and 2nd will be connected.
	 *  So keeping 2 chunkVariables.
	 */
	public void reverseInChunkIterIter(int chunkSize)
	{
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
	 * @Sawal
	 *  Reverse linked list in chunk with help of recurssion on both inner and outer
	 * @Jawab
	 *  Reverse internal , keep external and pass to next.
	 */
	private Node<Type> reverseInChunkRecrRecr_(Node<Type> node,int chunkSize, int lengthDone)
	{
		return null;
	}
	public void reverseInChunkRecrRecr( int chunkSize)
	{
		this.head = reverseInChunkRecrRecr_(this.head,chunkSize,0);
		
	}
	
}
