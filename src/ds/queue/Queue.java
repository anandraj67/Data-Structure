package ds.queue;

import ds.linkedlist.singly.LinkedList;

public class Queue<Type> 
{
	private LinkedList<Type> linkedListRef; 
	
	public Queue()
	{
		linkedListRef = new LinkedList<Type>();
	}
	
	public void insert(Type data)//front of queue
	{
		linkedListRef.insert.end(data);
	}
	
	public Type remove()
	{
		if(!isEmpty())
		{
			Type toReturn = linkedListRef.head.data; 
			linkedListRef.delete.begnning();
			return toReturn;
		}
		else
		{
			throw new NullPointerException();
		}
	}
	
	public Type peek()
	{
		if(!isEmpty())
		{
			return linkedListRef.head.data;
		}
		else
			throw new NullPointerException();
	}
	
	public boolean isEmpty()
	{
		if( linkedListRef.isEmpty() )
			return true;
		else
			return false;
	}
}
