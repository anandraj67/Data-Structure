package ds.tree;

import ds.tree.Tree;

public class MainRunner {

	public static void main(String[] args)
	{
		connectInOrderSucc2Runner();
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
