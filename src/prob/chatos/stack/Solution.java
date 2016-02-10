package prob.chatos.stack;

import java.util.Scanner;
import java.util.Stack;

public class Solution
{
	public static void performOperationOnStack()
	{
		Stack<Integer> superStack = new Stack<Integer>();
		Scanner in = new Scanner(System.in);
		Object o = new Object();
		
		int n = in.nextInt();
		for(int i=0;i<n;i++)
		{
			String operation = in.next();
			if("push".equals(operation))
			{
				superStack.push(in.nextInt());
				System.out.println(superStack.peek());
			}
			else if("pop".equals(operation))
			{
				superStack.pop();
				if(superStack.isEmpty())
					System.out.println("EMPTY");
				else
					System.out.println(superStack.peek());
			}
			else if("inc".equals(operation))
			{
				int x = in.nextInt();
				int d = in.nextInt();
				int size = superStack.size();
				for (int j=0; j < x;j++)
				{
					int prev = superStack.get(j);
					superStack.set(j, prev+d);
				}
				System.out.println(superStack.peek());
			}
		}
	}

	public static void main(String[] args)
	{
		
		performOperationOnStack();
	}
}
