package ds.main;

import ds.linkedlist.random.LinkedListRan;
import ds.linkedlist.random.Node;
import ds.tree.Tree;

public class MainRunner {

	public static void main(String[] args) 
	{
		Tree<Integer> treeRef = new Tree<Integer>();
		System.out.println("Create tree");
		treeRef.createTree();
		ds.tree.Node<Integer> iter = treeRef.binaryTreeToDLLInPlace(treeRef.root);
		while (iter!= null)
		{
			System.out.println(iter.data + " " );
			iter = iter.right;
		}
		//if (treeRef.lowestCommonAncestor(treeRef.root, 1, 2).data)
		//System.out.println(treeRef.lowestCommonAncestor(treeRef.root, 1, 2).data);
		//treeRef.connectInOrderSucessorLink(treeRef.root);
		//System.out.println(treeRef.root.inOrdSucc.data);
			
		//Integer [] in = {4,2,5,1,3};
	
			
		//		LinkedListRan<Integer> LL = new LinkedListRan<Integer>();
		//		LL.insert.end(1);	LL.insert.end(2);	LL.insert.end(3);
		//		LL.insert.end(4);	LL.insert.end(5);	
		//		
		//		LL.head.random = LL.head.next.next;//1->3
		//		LL.head.next.next.random = LL.head.next.next.next; // 3 -> 5
		//		LL.head.next.next.next.random = LL.head.next; // 5-> 2
		//		LL.head.next.random = LL.head.next.next.next; // 2-> 4
		//		LL.head.next.next.next.random =null;		
		//		LL.printLL();
				
		//	String [] inp = {	"0#0#0#0#1",
		//						"1#1#1#1#0",
		//						"1#1#1#1#1",
		//						"0#1#1#1#1",
		//						"1#0#1#1#0"
		//	};
		//	System.out.println(biggestSquare(inp));
		//System.out.println(smallestMultiple(3));
		//int [] arr = { 2 , 4 , 6 ,8, 10,12,19};
		//System.out.println(LAP(arr, arr.length-1, -1));
		
	}
}
