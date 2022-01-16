package ds.tree;

public class TreeNode<Type>
{
	public Type data;
	public TreeNode<Type> left;
	public TreeNode<Type> right;

	public TreeNode<Type> levelRight;
	public TreeNode<Type> inOrdSucc;

	public TreeNode(Type data)
	{
		this.data = data;
		left = right = inOrdSucc = levelRight = null;
	}

}

