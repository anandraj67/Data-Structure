package ds.tree;

import ds.tree.Tree;

public class MainRunner {

	public static void main(String[] args)
	{
		//connectInOrderSucc2Runner();
		//leftViewRunner();
		lowestCommonAncestorRunner();
	}

	private static void lowestCommonAncestorRunner()
	{
		Tree<Integer> treeRef = new Tree<Integer>();
		treeRef.createTree();
		treeRef.lowestCommonAncestor(treeRef.root,2,4);
		treeRef.lowestCommonAncestor(treeRef.root,2,3);
		treeRef.lowestCommonAncestor(treeRef.root,2,11);
	}
	private static void leftViewRunner()
	{
		Tree<Integer> treeRef = new Tree<Integer>();
		treeRef.createTree();
		
		treeRef.leftView(treeRef.root);
	}
	private static void connectInOrderSucc2Runner() {
		Tree<Integer> treeRef = new Tree<Integer>();
		treeRef.createTree();
		ds.tree.Node<Integer> iter = treeRef.connectInOrderSucessorLink2();
		while (iter!= null)
		{
			System.out.print(iter.data + " " );
			iter = iter.inOrdSucc;
		}
	}
}
