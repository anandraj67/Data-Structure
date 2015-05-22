package ds.linkedlist.Doubly;

public class DoublyLinkedList <Type>
{
	public Node<Type> head;
	public Node<Type> last;
	
	public insert insert;
	public delete delete;
	
	public DoublyLinkedList()
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
		    else
		    	head.prev = newNode;
		    head = newNode;
		}
	
		// delete at a point
		
		public void end(Type dataIn) 
		{
			Node<Type> newNode = new Node<Type>(dataIn);
			if( isEmpty() )
				head  = newNode;
			else
			{
				// OR last.next= newNode; last.prev = newNode;
				Node<Type> iterator = head;
				while(iterator.next != null)
					iterator = iterator.next;
				iterator.next = newNode;
				newNode.prev = iterator;
			}
			last = newNode;
		}
	}

	public class delete // TO-DO : free memory in c++
	{
		public void begnning() 
		{
			if(!isEmpty())
			{
				head = head.next;
				head.prev = null;
				if(head == null)
					last = null;
			}
		}
		
		//delete at a point
		
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
				iterator.next.prev = null;
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

	
}
