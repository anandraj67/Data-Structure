package ds.tree;

import ds.linkedlist.Doubly.DoublyLinkedList;
import ds.linkedlist.singly.SingleLinkedList;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class Tree<Type> {
	public Node<Type> root;

	public Tree(){
		root = null;
	}
	public Node<Type> createTree() {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter node's data ");
		Node<Type> treeNodeRef = new Node(in.nextInt());
		if(root == null)
		{
			root = treeNodeRef;
		}
		System.out.print("Is Left node present(yes = ' no = all other) ");
		if(in.next().compareTo("'") == 0)
		{
			treeNodeRef.left  = createTree();
		}

		System.out.print("Is Right node present ");
		if(in.next().compareTo("'") == 0)
		{
			treeNodeRef.right  = createTree();
		}
		//in.close();
		return treeNodeRef;
	}
	public int size(Node<Type> root) {
		if (root==null)
			return 0;
		else
			return 1+ size(root.left) + size(root.right);
	}
	private int height(Node<Type> root) {
	   if (root==null)
           return 0;
	   else
	   {
           return Math.max(height(root.left), height(root.right))+1;
	   }
	}
	public int countLeaves(Node<Type> root) {
		if(root==null)
			return 0;
		if(root.left == null && root.right ==null)
			return 1;
		else
			return countLeaves(root.left) + countLeaves(root.right);
	}
    public boolean isPresent(Node<Integer> root,Integer key) {
        if(root==null)
            return false;
        if(root.data == key)
            return true;
        return isPresent(root.left, key) || isPresent(root.right, key);
    }
    public boolean isIdentical(Node<Type> root1,Node<Type> root2) {
        if(root1 == null && root2== null)
            return true;
        if(root1 != null && root2 != null)
            return ( (root1.data == root2.data) && isIdentical(root1.left,root2.left) && isIdentical(root2.right,root2.right));
        return false;
    }
	public void inOrderRecur(Node<Type> root) {
		if(root!= null)
		{
			inOrderRecur(root.left);
			System.out.print(root.data + " ");
			inOrderRecur(root.right);
		}
	}
	public void postOrderRecur(Node<Type> root) {
		if(root!= null)
		{
			postOrderRecur(root.left);
			postOrderRecur(root.right);
			System.out.print(root.data + " ");
		}
	}
	public void preOrderRecur(Node<Type> root) {
        if(root!= null)
        {
            System.out.print(root.data + " ");
            preOrderRecur(root.left);
            preOrderRecur(root.right);
        }
    }
	// With nested while loop
	public List <Integer> inOrderIterative(Node<Type> root) {
		List < Integer > res = new ArrayList < > ();

		if(root == null) return res;
			Stack<TreeNode> stack = new Stack<TreeNode>();
			stack.add(root);
		while(!stack.isEmpty())
		{
		    while(stack.peek().left != null){
			stack.push(stack.peek().left);
		    }

		    while(!stack.isEmpty()){
			TreeNode popedTreeNode = stack.pop();
			res.add(popedTreeNode.val);
			if(popedTreeNode.right != null){
			    stack.push(popedTreeNode.right);
			    break;
			}
		    }

		}
		return res;
	}
	// With flag to add or remove
	public List<Integer> inOrderIterative_2(TreeNode root) {
		List < Integer > res = new ArrayList < > ();

		if(root == null) return res;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.add(root);
		boolean add_new = (stack.peek().left!=null);
		while(!stack.isEmpty())
		{
			if(add_new){
				stack.push(stack.peek().left);
				add_new = (stack.peek().left!=null);
			}
			else{
				TreeNode popedTreeNode = stack.pop();
				res.add(popedTreeNode.val);
				if(popedTreeNode.right != null){
				    stack.push(popedTreeNode.right);
				    add_new = (stack.peek().left!=null);
				}else{
				    add_new = false;
				}

			}
		}
		return res;
	}
	
	public void inOrderIterativeMorrisTraversal(Node<Type> root){
	//inorder without recursion and without stack page 6
	//MorrisTraversal
	//http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/
	}
	public void preOrderIterative(Node<Type> root) {
		Stack<Node<Type>> stack = new Stack<Node<Type>>();
		stack.push(root);
		while(!stack.isEmpty())
		{
			Node<Type> popedTreeNode = stack.pop();
			System.out.print(popedTreeNode.data + " ");
			if(popedTreeNode.right != null)
				stack.push(popedTreeNode.right);
			if(popedTreeNode.left != null)
				stack.push(popedTreeNode.left);
		}
	}
	public void postOrderIterative(Node<Type> root) {
		Stack<Node<Type>> unProcessedStack = new Stack<Node<Type>>();
		Stack<Node<Type>> processedStack = new Stack<Node<Type>>();
		unProcessedStack.push(root);
		while(!unProcessedStack.isEmpty())
		{
			Node<Type> popedTreeNode = unProcessedStack.pop();
			processedStack.push(popedTreeNode);
			if(popedTreeNode.left != null)
				unProcessedStack.push(popedTreeNode.left);
			if(popedTreeNode.right != null)
				unProcessedStack.push(popedTreeNode.right);
		}
		while(!processedStack.isEmpty())
		{
			System.out.print(processedStack.pop().data + " " );
		}
	}
	public void levelOrderIterative(Node<Type> root) {
		Queue<Node<Type>> queue = new LinkedList<Node<Type>>();
		queue.add(root);
		while(!queue.isEmpty())
		{
			Node<Type> removedNoded = queue.remove();
			System.out.print(removedNoded.data + " ");
			if(removedNoded.left != null)
			{
				queue.add(removedNoded.left);
			}
			if(removedNoded.right != null)
			{
				queue.add(removedNoded.right);
			}
		}
	}
	private void _oneLevelRecursive(Node<Type> root, int level, int levelToPrint) {
        // called from levelOrderRec
		if(levelToPrint == level)
			System.out.print(root.data);
		else
		{
			if(root.left != null)
				_oneLevelRecursive(root.left, level + 1, levelToPrint);
			if(root.right != null)
				_oneLevelRecursive(root.right, level + 1, levelToPrint);
		}
	}
	public void levelOrderRec(Node<Type> root) {
		for (int i=0;i<height(root);i++)
		{
			_oneLevelRecursive(root, 0, i);
		}
	}
    public void spiralOrder(Node<Type> root) {
        Stack<Node<Type>> stack1 = new Stack<Node<Type>>();//LR
        Stack<Node<Type>> stack2 = new Stack<Node<Type>>();//RL
        stack1.push(root);

        while( !stack1.isEmpty() || !stack2.isEmpty() )
        {
            while(!stack1.isEmpty())
            {
                Node<Type> popedNode = stack1.pop();
                System.out.print(popedNode.data + " ");
                if(popedNode.right!= null)
                    stack2.push(popedNode.right);
                if(popedNode.left!= null)
                    stack2.push(popedNode.left);
            }
            while(!stack2.isEmpty())
            {
                Node<Type> popedNode = stack2.pop();
                System.out.print(popedNode.data + " ");
                if(popedNode.left!= null)
                    stack1.push(popedNode.left);
                if(popedNode.right!= null)
                    stack1.push(popedNode.right);
            }
        }
    }
    public int width(Node<Type> root) {
        // With dummy node
        if (root ==  null)
            return 0;
        int width = 1;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()){
            Node removedNode = queue.remove();
            if (removedNode == null){
                width = Math.max(width, queue.size());
                if(!queue.isEmpty()){
                    queue.add(null);
                }
            }else {
                if(removedNode.left != null){
                    queue.add(removedNode.left);
                }
                if(removedNode.right != null){
                    queue.add(removedNode.right);
                }
            }
        }
        return width;
    }
    private int _diameter2(Node<Type> root,Integer [] maxDiameter) {
        if(root==null)
            return 0;
        if(root.left == null && root.right ==null)
            return 1;
        int retLeft=0;
        if(root.left != null)
            retLeft = _diameter2(root.left, maxDiameter);
        int retRight=0;
        if(root.right != null)
            retRight = _diameter2(root.right, maxDiameter);
        if( (retRight+ retLeft+1) > maxDiameter[0])
            maxDiameter[0] = (retRight+ retLeft+1);
        if (retRight> retLeft)
            return retRight+1;
        else
            return retLeft+1;
    }
    public int diameter2(Node<Type> root) {
        Integer []maxDiameter = new Integer[1];
        maxDiameter[0] = 0;
        _diameter2(root, maxDiameter);
        return maxDiameter[0];
    }
    private int[] _diameter(Node<Type> root) {
        // returns height and diameter
        if(root==null)
        {
            int []ret = {0,0};
            return ret;
        }
        int []leftRet = _diameter(root.left);
        int []rightRet = _diameter(root.right);

        int []toRet = new int[2];

        if(leftRet[0] > rightRet[0])
            toRet[0] = leftRet[0]+1;
        else
            toRet[0] = leftRet[0]+1;

        toRet[1] = Integer.max(Integer.max(leftRet[1],rightRet[1]),(leftRet[0]+rightRet[0]+1));

        return toRet;
    }
    public int diameter(Node<Type> root) {
        return _diameter(root)[1];
    }
	public boolean isSubTree(Node<Type> rootS, Node<Type> rootM) {
		if(rootS == null)
			return true;
		if(rootM == null)
			return false;
		if(rootS.data == rootM.data)
		{
			return isIdentical(rootS, rootM);
		}
		return isSubTree(rootS, rootM.left) || isSubTree(rootS, rootM.right);
	}
	private boolean _isHeightBalanced(Node<Type> root,int heightNow,int [] heightAvg) {
		if(root==null)
			return true;
		if(root.left == null && root.right == null)
		{
			if(heightAvg[0] == -1 )
				heightAvg[0] = heightNow;
			else
				if(Math.abs( heightNow - heightAvg[0]) > 1)
					return false;
			return true;
		}
		return ( _isHeightBalanced(root.left,heightNow+1, heightAvg) && _isHeightBalanced(root.right,heightNow+1, heightAvg));
	}
	public boolean isHeightBalanced(Node<Type> root) {
        // every node sud be almost(diff of one) equal distance from root
		int []heightAvg = new int[1];
		heightAvg[0]= -1;
		return _isHeightBalanced(root,0,heightAvg);
	}
	public boolean isCompleteTree(Node<Type> root) {
		if(root == null)
			return true;
		Queue<Node<Type>> queue = new LinkedList<Node<Type>>();
		queue.add(root);
		queue.add(null);

		boolean halfFilled = false;
		while(!queue.isEmpty())
		{
			Node<Type> removedNode = queue.remove();
			if(removedNode == null)
			{
				if(!queue.isEmpty())
					queue.add(null);
			}
			else
			{
				if(removedNode.left != null && !halfFilled)
				{
					queue.add(removedNode.left);
				}
				else if(removedNode.left == null && !halfFilled)
				{
					halfFilled = true;
				}
				else if(removedNode.left != null && halfFilled)
				{
					return false;
				}

				if(removedNode.right != null && !halfFilled)
				{
					queue.add(removedNode.right);
				}
				else if(removedNode.right == null && !halfFilled)
				{
					halfFilled = true;
				}
				else if(removedNode.right != null && halfFilled)
				{
					return false;
				}
			}
		}
		return true;
	}
	public Node<Type> mirror(Node<Type> root) {
		if(root == null)
			return root;

		Node<Type> temp = root.left;
		root.left = mirror(root.right);
		root.right = mirror(temp);
		return root;
	}
    public boolean isChildrenSumProperty(Node<Integer> root) {
        //every node sum of its children nodes
        if(root == null || (root.left==null && root.right == null))
            return true;
        int sum =0;
        if(root.left != null)
            sum+= root.left.data;
        if(root.right != null )
            sum+= root.right.data;
        return isChildrenSumProperty(root.left) && isChildrenSumProperty(root.right) && (root.data == sum);
    }
	public void leftView(Node<Type> root) {
		// can be done with 1 queue with dummy node
		Queue<Node<Type>> queue1 = new LinkedList<Node<Type>>();
		Queue<Node<Type>> queue2 = new LinkedList<Node<Type>>();
		queue1.add(root);
		boolean flag = true;
		while( !queue1.isEmpty() || !queue2.isEmpty() )
		{
			while(!queue1.isEmpty())
			{
				Node<Type> removedNode = queue1.remove();
				if(flag)
				{
					System.out.print(removedNode.data + " ");
					flag = false;
				}
				if(removedNode.left!= null)
					queue2.add(removedNode.left);
				if(removedNode.right!= null)
					queue2.add(removedNode.right);
			}
			while(!queue2.isEmpty())
			{

				Node<Type> removedNode = queue2.remove();
				if(!flag)
				{
					System.out.print(removedNode.data + " ");
					flag = true;
				}
				if(removedNode.left!= null)
					queue1.add(removedNode.left);
				if(removedNode.right!= null)
					queue1.add(removedNode.right);
			}
		}
	}
    boolean _checkAllLeafAtSameLevel(Node<Type> root, int level, AtomicReference<Integer> leafLevel) {
        if (root == null)
            return true;
        if (root.left == null && root.right == null){
            if (leafLevel.get() == 0) {
                leafLevel.set(level);
                return true;
            }
            return (level == leafLevel.get());
        }
        return _checkAllLeafAtSameLevel(root.left, level+1, leafLevel) &&
                _checkAllLeafAtSameLevel(root.right, level+1, leafLevel);
    }
    boolean checkAllLeafAtSameLevel(Node<Type> root) {
        AtomicReference leafLevel = new AtomicReference();
        leafLevel.set(0);
        return _checkAllLeafAtSameLevel(root, 0, leafLevel);
    }
	boolean _isBST(Node<Integer> root,int min,int max) {

		if(root==null)
			return true;
		if(root.data > min && root.data <max)
		{
			return ( _isBST(root.left, min, root.data) && _isBST(root.right, root.data, max));
		}
		return false;
	}
	public boolean isBST(Node<Integer> root)
	{
		return _isBST(root,-999,999);
	}
	public Node<Integer> findInBST(Node<Integer> root,Integer key) {
		if(root==null)
			return null;
		if(root.data == key)
		{
			return root;
		}
		else if(root.data > key)
		{
			return findInBST(root.left, key);
		}
		else// if(root.data < key)
		{
			return findInBST(root.right, key);
		}

	}
	public Node<Integer> minimumInBST(Node<Integer> root) {
        // can be also by iteration by stack
		if(root == null)
			return null;
		if(root.left == null)
			return root;
		return minimumInBST(root.left);
	}
	public Node<Integer> maximumInBST(Node<Integer> root) {
        // can be also by recursion by stack
		if(root == null)
			return null;
		while(root.right != null)
		{
			root = root.right;
		}
		return root;
	}
	public Node<Integer> ceilInBST(Node<Integer> root,Integer key) {
		if(root==null)
			return null;
		if(root.data == key)
			return root;
		else if(root.data < key)
			return ceilInBST(root.right, key);
		else// if(root.data > key)
		{
			Node<Integer> retLeft = ceilInBST(root.left, key);
			if(retLeft == null)
				return root;
			else
				return retLeft;
		}
	}
	public Node<Integer> inOrderSuccessorBST (Node<Integer> root,Integer value) {
		if(root == null)
			return null;
		Node<Integer> rem = null;
		while(root!=null && root.data != value)
		{
			if(root.data < value)
			{
				root = root.right;
			}
			else if(root.data > value)
			{
				rem = root;
				root = root.left;
			}
		}
		if(root==null)// value itself is not present
			return null;
		if(root.right == null)
			return rem;
		root = root.right;
		while(root.left != null)
		{
			root = root.left;
		}

		return root;
	}
	public Node<Type> kSmallestElementInBST (Node<Type> root,Integer k) {
        // iterative approach to inorder.
		Stack<Node<Type>> leftProcessedStack = new Stack<Node<Type>>();
		Stack<Node<Type>> leftUnProcessedStack = new Stack<Node<Type>>();
		leftUnProcessedStack.push(root);

		Node<Type> ans = null;
		while(!leftProcessedStack.isEmpty() || !leftUnProcessedStack.isEmpty())
		{
			if(!leftUnProcessedStack.isEmpty())
			{
				Node<Type> popedTreeNode = leftUnProcessedStack.pop();
				leftProcessedStack.push(popedTreeNode);
				if(popedTreeNode.left != null)
					leftUnProcessedStack.push(popedTreeNode.left);
			}
			else
			{
				k--;
				Node<Type> popedTreeNode = leftProcessedStack.pop();
				if(k == 0)
					ans = popedTreeNode;
				if(popedTreeNode.right != null)
					leftUnProcessedStack.push(popedTreeNode.right);
			}
		}
		return ans;
	}
	private Integer[]  _largestBSTSubtreeSizeInBinaryTree (Node<Integer> root) {
		Integer[] arrToRet = new Integer[4];
		if(root == null)
		{
			arrToRet[0] = 0; arrToRet[1] = 0; arrToRet[2] = 0; arrToRet[3] = 0;
			return arrToRet;
		}
		if(root.left == null && root.right == null)
		{
			arrToRet[0] = 0; arrToRet[1] = root.data; arrToRet[2] = root.data; arrToRet[3] = 1;
			return arrToRet;
		}

		Integer [] leftArr = new Integer[4];
		Integer [] righttArr = new Integer[4];

		leftArr = _largestBSTSubtreeSizeInBinaryTree(root.left);
		righttArr = _largestBSTSubtreeSizeInBinaryTree(root.right);

		if(( leftArr[0] == 0 && leftArr[2] < root.data ) && ( righttArr[0] == 0 && righttArr[1] > root.data ) )
		{
			arrToRet[0] = 0;
			arrToRet[1] = leftArr[1];
			arrToRet[2] = righttArr[2];
			arrToRet[3] = leftArr[3]+ righttArr[3] + 1;
		}
		else
		{
			arrToRet[0] = -1;
			arrToRet[1] = -1;
			arrToRet[2] = -1;
			arrToRet[3] = Integer.max(leftArr[3], righttArr[3]);
		}

		return arrToRet;
	}
	public int largestBSTSubtreeSizeInBinaryTree (Node<Integer> root) {

		Integer[] arrRec = new Integer[4];
		arrRec = _largestBSTSubtreeSizeInBinaryTree(root);
		return arrRec[3];
	}
	public boolean isAllNodeHaving1ChildBSTpreOrd(int [] arr) {
        //2 8 4 3 9
		int max = 999,min = -999;
		boolean toRet = true;
		for(int i=1;i<arr.length;i++)
		{
			if(arr[i] < min || arr[i] > max)
			{
				toRet = false;
				break;
			}
			if(arr[i] > arr[i-1]) // increasing
			{
				min = arr[i-1];
			}
			else
			{
				max = arr[i-1];
			}

		}

		return toRet;
	}
	private void _rootToLeafPath(Node<Type> root,SingleLinkedList<Node<Type>> path) {
		if(root!=null)
		{
			path.insert_end(new ds.linkedlist.singly.Node<Node<Type>>(root));
			if(root.left == null && root.right == null)
			{
				ds.linkedlist.singly.Node<Node<Type>> iterator = path.head;
				while(iterator != null)
				{
					System.out.print(iterator.data.data + " ");
					iterator=iterator.next;
				}
				System.out.println("");
			}
			_rootToLeafPath(root.left, path);
			_rootToLeafPath(root.right, path);
			path.delete_end();
		}
	}
	public void rootToLeafPath() {
		SingleLinkedList<Node<Type>> path = new SingleLinkedList<Node<Type>>();
		_rootToLeafPath(root,path );
	}
	private int _treePathsSum(Node<Integer> root, int val) {
	    if (root == null)  return 0;

	    val = val*10 + root.data;

	    if (root.left==null&& root.right==null)
	       return val;

	    return _treePathsSum(root.left, val) +
	           _treePathsSum(root.right, val);
	}
	int treePathsSum(Node<Integer> root) {
	    // Pass the initial value as 0 as there is nothing above root
	    return _treePathsSum(root, 0);
	}
	public boolean printAncestor(Node<Type> root,Type key) {
		if(root == null)
			return false;
		if(root.data == key)
		{
			return true;
		}
		if(printAncestor(root.left, key))
		{
			System.out.print(root.data);
			return true;
		}
		if(printAncestor(root.right, key))
		{
			System.out.print(root.data);
			return true;
		}
		return false;
	}
 	public Node<Integer> lowestCommonAncestorInBST(Node<Integer> root,Integer a, Integer b) {
		if(a > b || root == null)
			return null;
		if(root.data > b)
		{
			return lowestCommonAncestorInBST(root.left, a, b);
		}
		else if(root.data < a)
		{
			return lowestCommonAncestorInBST(root.right, a, b);
		}
		else// if(root.data >= a && root.data <= b)
		{
			return root;
		}

	}
 	private Node<Integer> __lowestCommonAncestor(Node<Integer> root,Integer a, Integer b) {
		if(root == null)
			return null;
		if(root.data == a || root.data == b)
			return root;
		Node<Integer> retLeft = __lowestCommonAncestor(root.left, a, b);
		Node<Integer> retRight  = __lowestCommonAncestor(root.right, a, b);
		if(retRight != null && retLeft != null)
			return root;
		if(retLeft == null)
			return retRight;
		else//if(retRight == null)
			return retLeft;
	}
	private ArrayList<Object> _lowestCommonAncestor(Node<Integer> root,Integer a, Integer b) {
		if(root == null)
			return null;
		if(root.data == a )
		{
			if(isPresent(root,b))
			{
				ArrayList<Object> toRet = new ArrayList<Object>();
				toRet.add(root);toRet.add(-1);
				return toRet;
			}
			else
			{
				ArrayList<Object> toRet = new ArrayList<Object>();
				toRet.add(null);toRet.add(b);
				return toRet;
			}
		}
		if(root.data == b )
		{
			if(isPresent(root,a))
			{
				ArrayList<Object> toRet = new ArrayList<Object>();
				toRet.add(root);toRet.add(-1);
				return toRet;
			}
			else
			{
				ArrayList<Object> toRet = new ArrayList<Object>();
				toRet.add(null);toRet.add(a);
				return toRet;
			}
		}

		ArrayList<Object> retLeft = _lowestCommonAncestor(root.left, a, b);
		ArrayList<Object>  retRight  = _lowestCommonAncestor(root.right, a, b);
		if(retRight.get(0) != null && retLeft.get(0) != null)
		{
			ArrayList<Object> toRet = new ArrayList<Object>();
			toRet.add(root);toRet.add(-1);
			return toRet;
		}
		if(retLeft.get(0) == null)
			return retRight;
		else//if(retRight == null)
			return retLeft;
	}
	public Node<Integer> lowestCommonAncestor(Node<Integer> root,Integer a, Integer b) {
		return (Node<Integer>)_lowestCommonAncestor(root, a, b).get(0);
//		if(isPresent(root, a) && isPresent(root, b))
//			return __lowestCommonAncestor(root, a, b);
//		else
//			return null;
	}
	public void convertToChildrenSumProperty(Node<Integer> root){
        //convertToChildrenSumProp // http://www.geeksforgeeks.org/convert-an-arbitrary-binary-tree-to-a-tree-that-holds-children-sum-property/
    }
    public void convertToChildrenSumPropWithIncrOnly(Node<Integer> root) {
        return;
	}
 	void convertTree(Node<Integer> node) {
        // This function changes a tree to to hold children sum property
	    int left_data = 0,  right_data = 0, diff;

          /* If tree is empty or it's a leaf node then return true */
        if (node == null ||(node.left == null && node.right == null))
            return;
        else
        {
            /* convert left and right subtrees  */
            convertTree(node.left);
            convertTree(node.right);

            /* If left child is not present then 0 is used as data of left child */
            if (node.left != null)
              left_data = node.left.data;

            /* If right child is not present then 0 is used as data of right child */
            if (node.right != null)
              right_data = node.right.data;

            /* get the diff of node's data and children sum */
            diff = left_data + right_data - node.data;

            /* If node's children sum is greater than the node's data */
            if (diff > 0)
               node.data = node.data + diff;

            /* THIS IS TRICKY -. If node's data is greater than children sum, then increment subtree by diff */
            if (diff < 0)
                _incrementSubtree(node, -diff);  // -diff is used to make diff positive
        }
	}
	private void _incrementSubtree(Node<Integer> node, int diff) {
        /* This function is used to increment subtree by diff */
	    if(node.left != null) // first try left
	    {
	        node.left.data = node.left.data + diff;
	        _incrementSubtree(node.left, diff);
	    }
	    else if (node.right != null) // Else increment right child
	    {
	        node.right.data = node.right.data + diff;
	        _incrementSubtree(node.right, diff);
	    }
	}
	public void printKdistantNodesDown(Node<Integer> root,int k) {
		if(root == null || k < 0)
			return;

		if(0 == k)
		{
			System.out.print(root.data + " ");
			return;
		}
		else
		{
			printKdistantNodesDown(root.left, k-1);
			printKdistantNodesDown(root.right, k-1);
		}
	}
	public int printAllKdistantNodesFromTarget(Node<Integer> root,int k,int target) {
		if(root == null || k < 0)
			return -1;
		if(target == root.data)
		{
			printKdistantNodesDown(root.left,k-1);
			printKdistantNodesDown(root.right,k-1);
			return k;
		}
		int leftRet = printAllKdistantNodesFromTarget(root.left,k,target);
		if(leftRet != -1)
		{
			if(leftRet-1 == 0)
				System.out.print(root.data + " ");
			printKdistantNodesDown(root.right,leftRet-2);
			return leftRet-1;
		}
		int rightRet = printAllKdistantNodesFromTarget(root.right,k,target);
		if(rightRet != -1)
		{
			if(rightRet-1 == 0)
				System.out.print(root.data + " ");
			printKdistantNodesDown(root.right,rightRet-2);
			return rightRet-1;
		}
		return -1;
	}
	private int _searchIndex(Integer [] arr,int key,int start,int end) {
		for(int i=start ; i<= end ; i++)
		{
			if(arr[i] == key)
				return i;
		}
		return -1;
	}
	private Node<Integer> _makeTreeFromInOrderAndPreOrder(Integer [] inOrder,Integer [] preOrder, int startInOrder, int endInOrder,AtomicReference<Integer> preOrderIndexRef) {
		if( preOrderIndexRef.get() > preOrder.length-1)
			return null;
		int index = _searchIndex(inOrder, preOrder[preOrderIndexRef.get()], startInOrder, endInOrder);
		if(index == -1  )
			return null;
		Node<Integer> newNode = new Node<Integer>(preOrder[preOrderIndexRef.get()]);
		preOrderIndexRef.set(preOrderIndexRef.get()+1);
		newNode.left = _makeTreeFromInOrderAndPreOrder(inOrder, preOrder, startInOrder, index-1, preOrderIndexRef);
		newNode.right = _makeTreeFromInOrderAndPreOrder(inOrder, preOrder, index+1, endInOrder, preOrderIndexRef);

		return newNode;
	}
	public Tree<Integer> makeTreeFromInOrderAndPreOrder(Integer [] inOrder,Integer [] preOrder) {
		Tree<Integer> treeRef = new Tree<Integer>();
		AtomicReference<Integer> preOrderIndexRef = new AtomicReference<Integer>();
		preOrderIndexRef.set(0);
		treeRef.root =  _makeTreeFromInOrderAndPreOrder(inOrder, preOrder, 0, inOrder.length-1,preOrderIndexRef);
		return treeRef;
	}
	private Node<Integer> _makeTreeFromPreOrderRec(int [] pre,AtomicReference<Integer> index,int max,int min) {
        //10, 5, 1, 7, 40, 50
		if(index.get() >= pre.length )
			return null;
		if( pre[index.get()] < max && pre[index.get()] > min )
		{
			Node<Integer> newNode = new Node<Integer>(pre[index.get()]);
			index.set(index.get()+1);

			newNode.left = _makeTreeFromPreOrderRec(pre, index, newNode.data,min);
			newNode.right = _makeTreeFromPreOrderRec(pre, index , max, newNode.data);
			return newNode;
		}
		else
		{
			return null;
		}
	}
	public Node<Integer> makeTreeFromPreOrderRec(int [] pre) {
		//Other approach O(n^2) recursion: root : all less than root is left AND rest is right.
		// Iterative O(n) :
        AtomicReference<Integer> index = new AtomicReference<Integer>();
		index.set(0);
		if(pre != null)
			return _makeTreeFromPreOrderRec(pre, index,999,-999);
		else
			return null;
	}
	public Node<Integer> makeTreeFromPreOrderIter(int [] pre) {
		if(pre.length == 0 )
			return null;

		int index = 0;
		Node<Integer> root = new Node<Integer>(pre[index++]);
		Stack<Node<Integer>> stk = new Stack<Node<Integer>>();
		stk.push(root);
		while(index < pre.length)
		{
			Node<Integer> newNode = new Node<Integer>(pre[index]);
			if(pre[index] < stk.peek().data)
			{
				 stk.peek().left = newNode;
				 stk.push(newNode);
			}
			else
			{
				Node<Integer> popedNode = null;
				while(!stk.isEmpty() && stk.peek().data < pre[index] )
				{
					popedNode = stk.pop();
				}
				if(popedNode != null)
				{
					popedNode.right = newNode;
					stk.push(newNode);
				}
			}
			index++;
		}

		return root;
	}
	public void convertToDoubleTree(Node<Integer> root) {
		if(root!=null)
		{
			Node<Integer> remNode = root.left;
			Node<Integer> newNode = new Node<Integer>(root.data);
			root.left = newNode;
			newNode.left = remNode;
			convertToDoubleTree(remNode);
			convertToDoubleTree(root.right);
		}
	}
	private boolean _isFoldableTree(Node<Type> root1,Node<Type> root2) {
		if(root1 == null && root2 == null)
			return true;
		if(root1!=null && root2!=null )
			return _isFoldableTree(root1.left, root2.right) && _isFoldableTree(root1.right, root2.left);
		return false;
	}
	public boolean isFoldableTree(Node<Type> root)
	{
		return _isFoldableTree(root, root);
	}
	public void connectNodesAtSameLevelIterr(Node<Type> root) {
		Queue<Node<Type>> queue = new LinkedList<Node<Type>>();
		queue.add(root);
		queue.add(null);
		Node<Type> preRemovedNode = null;
		while(!queue.isEmpty())
		{
			Node<Type> removedNoded = queue.remove();
			if(removedNoded == null) // dummy node for indentifying a level
			{
				if(!queue.isEmpty())
					queue.add(null);
			}
			else
			{
				if(removedNoded.left != null)
					queue.add(removedNoded.left);
				if(removedNoded.right != null)
					queue.add(removedNoded.right);
			}
			if(preRemovedNode != null)
				preRemovedNode.levelRight = removedNoded;
			preRemovedNode =  removedNoded;
		}
	}
	private Node<Type> _sortedArrayToBalancedBST(Integer [] arr,int start ,int end) {
		if(start > end)
			return null;
		int mid = ( start + end )/2;
		Node<Type> newNode = new Node(arr[mid]);
		newNode.left = _sortedArrayToBalancedBST(arr, start, mid-1);
		newNode.right = _sortedArrayToBalancedBST(arr, mid+1, end);
		return newNode;
	}
	public void sortedArrayToBalancedBST(Integer[] arr)
	{
		this.root =  _sortedArrayToBalancedBST(arr,0,arr.length-1);
	}
	private Node<Type> _sortedArrayToCompleteBST(Integer [] arr,int start ,int end) {
		if(start > end)
			return null;
		if(start == end)
		{
			Node<Type> newNode = new Node(arr[start]);
			return newNode;
		}

		double levelD = Math.log10(end-start+1 + 1)/Math.log10(2) ;
		int left =  (int) Math.pow( 2, (Math.floor(levelD -1 ) )) -1 ;

		int extra = (end-start+1) -  ((int) Math.pow( 2, Math.floor(levelD) ) - 1);

		if( extra / (Math.pow(2, (int)levelD -1 ) ) == 0)
		{
			left += extra;
		}
		else
		{
			left += Math.pow(2, (int)levelD -1);
		}

		int mid = start + left;

		Node<Type> newNode = new Node(arr[mid]);
		newNode.left = _sortedArrayToCompleteBST(arr, start, mid-1);
		newNode.right = _sortedArrayToCompleteBST(arr, mid+1, end);
		return newNode;
	}
	public void sortedArrayToCompleteBST(Integer[] arr) {
        // recurrsion on 2^n-1 size
		this.root =  _sortedArrayToCompleteBST(arr,0,arr.length-1);
	}
	
	// recurssion with multi return type
	private Node<Type>[]  _connectInOrderSuccessorLink(Node<Type> root) {	// Every node returning min' and max'and link is made.
		if(root==null)
		{
			Node<Type> [] arr = new Node[2];
			arr[0] = null;	arr[1] = null;
			return arr;
		}

		Node<Type> [] arrToRet = new Node[2];
		if(root.left == null)
		{
			arrToRet[0] = root;
		}
		else
		{
			Node<Type> [] leftRet = _connectInOrderSuccessorLink(root.left);
			leftRet[1].inOrdSucc = root;
			arrToRet[0] = leftRet[0];
		}
		if(root.right == null)
		{
			arrToRet[1] = root;
		}
		else
		{
			Node<Type> [] rightRet =  _connectInOrderSuccessorLink(root.right);
			root.inOrdSucc = rightRet[0];
			arrToRet[1] = rightRet[1];
		}
		return arrToRet;
	}
	// recurssion with global variable
	private void __connectInOrderSuccessorLink(Node<Type> root, AtomicReference<Node<Type>> prev) {
		if(root == null) return;
		__connectInOrderSuccessorLink(root.left, toBelinked);
		if (prev.get()!=null) prev.get().inOrdSucc = root;
		prev.get() = root;
		__connectInOrderSuccessorLink(root.right, toBelinked);
	}
	public void connectInOrderSuccessorLink(Node<Type> root) {
		//_connectInOrderSucessorLink(root); // own
	        AtomicReference<Node<Type>> prev = new AtomicReference<Node<Type>>();
		prev.set(null);
		__connectInOrderSuccessorLink(root, holder);
	}
	private void _verticalSum(Node<Integer> root,int where, ds.linkedlist.Doubly.Node<Integer> node,DoublyLinkedList<Integer> dLL ) {
		if(root == null)
			return;
		if( node ==  null )
		{
			if( where == -1 || where == 0)
			{
				dLL.insert.begnning(root.data);
				node = dLL.head;
			}
			if(where == 1)
			{
				dLL.insert.end(root.data);
				node = dLL.last;
			}
		}
		else
		{
			node.data += root.data;
		}
		_verticalSum(root.left, -1 , node.prev, dLL);
		_verticalSum(root.right, 1 , node.next, dLL);
	}
	public  void verticalSum(Node<Integer> root) {
		DoublyLinkedList<Integer> dLL = new DoublyLinkedList<Integer>();
		_verticalSum(root,0,null,dLL);
		ds.linkedlist.Doubly.Node<Integer> iter = dLL.head;
		while(iter != null)
		{
			System.out.print(iter.data +  " ");
			iter = iter.next;
		}
	}
	private void _makeWithArr(Node<Integer> root,int [] arr,AtomicReference<Integer> index) {
		if(root!= null)
		{
			_makeWithArr(root.left,arr,index);
			root.data = arr[index.get()];
			index.set(index.get()+1);
			_makeWithArr(root.right,arr,index);
		}
	}
	private void _fillArray(Node<Integer> root,int [] arr,AtomicReference<Integer> index) {
		if(root!= null)
		{
			_fillArray(root.left,arr,index);
			arr[index.get()] = root.data;
			index.set(index.get()+1);
			_fillArray(root.right,arr,index);
		}
	}
	public void convertToBST(Node<Integer> root) {
		int size = this.size((Node<Type>) root);
		int []arr = new int[size];
        AtomicReference<Integer> index = new AtomicReference<Integer>();
		index.set(0);
		_fillArray(root, arr, index);
		Arrays.sort(arr);
		index.set(0);
		_makeWithArr(root, arr, index);
	}
	private void _binaryTreeToDLLInPlace(Node<Type> root,AtomicReference<Node<Type>> toLink) {
		if (root == null)
			return;
		_binaryTreeToDLLInPlace(root.right, toLink);
		root.right = toLink.get();
		if(toLink.get() != null)
			toLink.get().left = root;
		toLink.set(root);
		_binaryTreeToDLLInPlace(root.left, toLink);
	}
	public Node<Type> binaryTreeToDLLInPlace(Node<Type> root) {
        AtomicReference<Node<Type>> toLink = new AtomicReference<Node<Type>>();
        toLink.set(null);
		_binaryTreeToDLLInPlace(root, toLink);
		return toLink.get();
	}
	// binaryTreeToCircularDLLInPlace()
	// similar. extra is we make circular every time in recursion or at last.
    // Avl tree // page 4
    // merge two avl // page 4
    // vertical sum to hash map/print only
    // http://www.geeksforgeeks.org/vertical-sum-in-a-given-binary-tree/
    // hast map
    //print a tree vertically each element
    //http://codereview.stackexchange.com/questions/36799/printing-a-binary-tree-top-down-column-wise
    //http://www.geeksforgeeks.org/print-binary-tree-vertical-order/
    //Given binary tree, connect all the nodes which are in same column.
    //hash int => list ; and traverse level order.
}
