package ds.main;

import ds.linkedlist.random.LinkedListRan;
import ds.linkedlist.random.Node;
import ds.tree.Tree;

public class MainRunner {
	static int max(int a,int b)
	{
		if (a>=b)
			return a;
		else
			return b;
	}
	public static int LAP(int []arr,int n,int d)
	{
		if(d==-1)
		{
			if(n == 0)
				return 1;
			int max_val = -999;
			for(int i=n-1;i>=0;i--)
			{
				max_val = max(max_val, max(LAP(arr, i, arr[n] - arr[i])+1,LAP(arr,i,-1)));
			}
			return max_val;
		}
		else
		{
			for(int i=n-1;i>=0;i--)
			{
				if(arr[n]-arr[i] == d)
					return LAP(arr,i,d)+1;
				if(arr[n]-arr[i] >= d)
					break;
			}
			return 1;
		}
	}
	static String smallestMultiple(int a) 
	{
	    int len=0;
	    while(a>0)
	    {
	        a=a/10;
	        len++;
	    }
	    
	    
	    String toRet = "";
	    
	    
	    int num = 0;
	    
	    for(int i=len;i>=0;i--)
	    {
	        num += Math.pow(10,i);
	        toRet += "1";
	    }
	    
	    while( num % a != 0)
	    {
	        num = (num%a)*10 +1;
	        toRet += "1";
	    }
	       
	    return toRet;
	
	}
	public static String biggestSquare(String[] input1)
	{
		int len = input1.length;
		int [][]arr = new int [len][len];
		
		for (int i=0;i<len;i++)
		{
			String [] split =  input1[i].split("#");
			for (int j = 0; j< split.length ; j++)
			{
				arr[i][j] = Integer.parseInt(split[j]);
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		
		for (int i=1;i<len;i++)
		{
			for (int j=1;j<len;j++)
			{
				if(	arr[i][j] == 1 &&
					arr[i-1][j-1] >0 &&
					arr[i][j-1] >0 &&
					arr[i-1][j] >0
				  )
				{
					arr[i][j] = Math.min(Math.min(arr[i-1][j-1], arr[i][j-1]), arr[i-1][j] )+1;
					
				}
			}
		}
		
	//	System.out.println();
	//	for (int i=0;i<len;i++)
	//	{
	//		for (int j=0;j<len;j++)
	//		{
	//			System.out.print(arr[i][j]);
	//		}
	//		System.out.println();
	//	}
		
		int max = 0,m=0,n=0;
		for (int i=0;i<len;i++)
		{
			for (int j=0;j<len;j++)
			{
				if(arr[i][j] > max)
				{
					max = arr[i][j];
					m=i;
					n=j;
				}
			}
		}
		String toRet = "";
		
		for (int i=m-arr[m][n] + 1; i<= m; i++)
		{
			
			toRet += "(";
			for (int j=n-arr[m][n] + 1; j<= n; j++)
			{
				toRet += i;
				toRet += "#";
				toRet += j;
				if(j!=n)
					toRet += ",";
			}
			toRet += ")";
			if(i!=m)
				toRet += ",";
		}
		
		return toRet;
	}
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
