package ds.tree;

public class Node<Type>
{
	public Type data; 
	public Node<Type> left;
	public Node<Type> right;
	
	
	public Node<Type> levelRight;
	public Node<Type> inOrdSucc;
	
	public Node(Type data) 
	{
		this.data = data;
		left = right = null;
		
		inOrdSucc = levelRight = null;
	}

}

