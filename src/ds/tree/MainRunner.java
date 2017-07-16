package ds.tree;

import java.awt.Window.Type;

import ds.tree.Tree;

public class MainRunner {

	public static void main(String[] args)
	{
		Tree<Integer> treeRef = new Tree<Integer>();
		treeRef.createTree();
        System.out.println(treeRef.width(treeRef.root));
	}


	private static void lowestCommonAncestorRunner(Tree<Integer> treeRef)
	{
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
}
