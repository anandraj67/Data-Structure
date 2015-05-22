package ds.linkedlist.random;

public class LinkedListRan <Type>
{
	public Node<Type> head;
	
	public insert insert;
	public delete delete;
	
	public LinkedListRan()
	{
		head = null;
		insert = new insert();
		delete = new delete();
	}
	
	public class insert
	{
		public void begnning(Type dataIn) 
		{
			Node<Type> newNode = new Node<Type>(dataIn);
		    newNode.next = head;
		    head = newNode;
		}
	
		public void end(Type dataIn) 
		{
			Node<Type> newNode = new Node<Type>(dataIn);
			newNode.next = null;
			if( !isEmpty() )
			{
				Node<Type> iterator = head;
				while(iterator.next != null)
					iterator = iterator.next;
				iterator.next = newNode; 
			}
			else
				head = newNode;
		}
	}

	public class delete // TO-DO : free memory in c++
	{
		public void begnning() 
		{
			if(!isEmpty())
				head = head.next; 
		}
	
		public void end() 
		{
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
	
	public void duplicate(Node<Type> head)
	{
		
	}
}
