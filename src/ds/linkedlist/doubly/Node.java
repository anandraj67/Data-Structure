package ds.linkedlist.doubly;

public class Node<Type> {
	public Type data;
	public Node<Type> next;
	public Node<Type> prev;
	public Node(Type data) 
	{
		this.data = data;
		next = prev = null;		
	}
}
