package ds.linkedlist.singly;

public class Node<Type>
{
	public Type data;// TO-DO : make it generic
	public Node<Type> next;
	public Node<Type> random;

	public Node(Type data)
	{
		this.data = data;
		next = random = null;
	}

	public void print() {
		System.out.print(this.data + " " );
	}
}
