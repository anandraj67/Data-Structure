package ds.linkedlist.singly;

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
		public void begnning(Type dataIn) 
		{
			Node<Type> newNode = new Node<Type>(dataIn);
		    newNode.next = head;
		    if( isEmpty() )
		    	last = newNode;
		    head = newNode;
		}
	
		public void end(Type dataIn) 
		{
			Node<Type> newNode = new Node<Type>(dataIn);
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

	public int length()
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

	public void printLL()
	{
		Node<Type> iter = this.head;
		while(iter != null)
		{
			System.out.print(iter.data +" ");
			iter = iter.next;
		}
		System.out.println(" ");
	}
	
	// detectAndRemoveLoop;
	
	
}
