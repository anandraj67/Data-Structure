package prob.fk.tree;

import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.LinkedList;
 

class Node
{
	public int data;
	public Node left;
	public Node right;

	public Node(int data)
	{
		this.data = data;
		left = right = null;
	}
	public void print() {
		System.out.println(this.data+" ");
	}
}


public class Solution
{
	public static Node makeTreeFromSpecialArray()
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Node [] nodeArr = new Node[n];
		for(int i=0;i<n;i++)
		{
			nodeArr[i] = new Node(i);
		}
		int parent;
		Node root = null;
		for(int i=0;i<n;i++)
		{
			parent = in.nextInt();
			if(parent == -1)
			{
				root = nodeArr[i];
			}
			else
			{
				if(nodeArr[parent].left ==null)
				{
					nodeArr[parent].left = nodeArr[i];
				}
				else
				{
					nodeArr[parent].right = nodeArr[i];
				}
			}
		}
		
		return root;
	}

	public static void reverseLevelOrder(Node root) {
        Stack<Node> stack = new Stack();
        Queue<Node> queue = new LinkedList();
        queue.add(root);
        queue.add(null);
 
        while (queue.isEmpty() == false) 
        {
            Node removedNode = queue.remove();
            stack.push(removedNode);
            if(removedNode == null)
            {
            	if(!queue.isEmpty())
					queue.add(null);
            }
            else
            {
	            if (removedNode.right != null) {
	                queue.add(removedNode.right); 
	            }
	            if (removedNode.left != null) {
	                queue.add(removedNode.left);
	            }
            }
        }
        stack.pop();
        while (stack.empty() == false) 
        {
            Node node = stack.pop();
            if(node == null)
            	System.out.println();
            else
            	System.out.print(node.data + " ");
        }
    }
	public static void main(String[] args)
	{
		Node root = makeTreeFromSpecialArray();
		reverseLevelOrder(root);
		
	}
}
