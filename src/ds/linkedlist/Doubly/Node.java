package ds.linkedlist.Doubly;

public class Node<Type>
{
	public Type data;// TO-DO : make it generic
	public Node<Type> next;
	public Node<Type> prev;
	public Node(Type data) 
	{
		this.data = data;
		next = prev = null;		
	}
}
