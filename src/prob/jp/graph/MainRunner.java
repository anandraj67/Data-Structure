package prob.jp.graph;

import java.util.Scanner;
import java.util.Stack;

public class MainRunner {
	public static int maxIncomingEdges(int[]  edges, int n)
	{
		int [] incomingEdges = new int [n];
		int maxIncomingEdges = 0;
		for(int i=0;i<n;i++)
		{
			if(edges[i] >0)
			{
				incomingEdges[edges[i]] += 1;
				if(maxIncomingEdges < incomingEdges[edges[i]])
					maxIncomingEdges = incomingEdges[edges[i]];
			}
		}
		return maxIncomingEdges;
	}
	public static int largestCycle(int[] edges, int n) 
	{
		Stack<Integer> stack = new Stack<Integer>();
		boolean [] visited = new boolean [n];
		int largestCycle = -1;
		stack.push(0);
		visited[0] = true;
		while (!stack.isEmpty())
		{
			int peekedNode = stack.peek();
			if(edges[peekedNode] == -1) // leaf node
			{
				while(!stack.empty())
					stack.pop();
				pushNextNonVisited(n, stack, visited);
			}
			else if( !visited[ edges[peekedNode] ])
			{
				stack.push(edges[peekedNode]);
				visited[edges[peekedNode]] = true;
			}
			else if ( visited[ edges[peekedNode] ])
			{
				int currentCycle = 0;
				while( !stack.empty())
				{
					currentCycle ++;
					if (edges[peekedNode] == stack.pop())
					{
						if(currentCycle > largestCycle)
							largestCycle = currentCycle;
					}
				}
				pushNextNonVisited(n, stack, visited);
			}
		}
		return largestCycle;
	}
	private static void pushNextNonVisited(int n, Stack<Integer> stack,
			boolean[] visited) {
		int leastNonVisited = leastNonVisited(n, visited);
		if(leastNonVisited != -1)
		{
			stack.push(leastNonVisited);
			visited[leastNonVisited] = true;
		}
	}
	private static int leastNonVisited(int n, boolean[] visited) {
		int leastNonVisited = -1;
		for(int i=0;i<n;i++)
		{
			if(!visited[i])
			{
				leastNonVisited = i;
				break;
			}
		}
		return leastNonVisited;
	}

	public static int nearestMeetingCell(int[] edges, int n, int cell1, int cell2) 
	{
		int nearestMeetingCell = -1;
		boolean [] visited1 = new boolean [n]; 
		boolean [] visited2 = new boolean [n];
		
		int curr1 = cell1, curr2 = cell2;
		visited1[curr1] = visited2[curr2] = true;
		boolean one=true,two =true;
		while (true) 
		{
			if(curr1 != -1 && one)
			{
				if(edges[ curr1 ] != -1)
				{
					if( visited2[ edges[ curr1 ] ]  ) // meeting point
					{
						nearestMeetingCell = edges[ curr1 ] ;
						break;
					}
					if ( visited1[ edges [curr1] ] ) // cycle
					{
						one = false;
					}
					else
						visited1[ edges[ curr1 ] ] = true;
				}
				curr1 = edges[ curr1 ];
			}
			if(curr2 != -1 && two )
			{
				if(edges[ curr2 ] != -1)
				{
					if( visited1[ edges[ curr2 ] ]  ) // meeting point
					{
						nearestMeetingCell = edges[ curr2 ] ;
						break;
					}
					if ( visited2[ edges [curr2] ] ) // cycle
					{
						two = false;
					}
					else
						visited2[ edges[ curr2 ] ] = true;
				}
				curr2 = edges[ curr2 ];	
			}
			if( (curr1 == -1 || !one) && ( curr2 == -1 || !two) ) // negative case
				break;
		}
		return nearestMeetingCell;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int [] edges = new int[n]; 
		for(int i=0;i<n;i++)
		{
			edges[i] = in.nextInt();
		}
		int nmcInput1 = in.nextInt();
		int nmcInput2 = in.nextInt();
		
		int maxIncomingEdges = maxIncomingEdges(edges, n);
		System.out.println("maxIncomingEdges = " + maxIncomingEdges);
		
		int largestCycle = largestCycle(edges, n);
		System.out.println("largestCycle = " + largestCycle);
		
		int nearestMeetingCell = nearestMeetingCell(edges, n, nmcInput1,nmcInput2);
		System.out.println("nearestMeetingCell = " + nearestMeetingCell );
		
	}
}
