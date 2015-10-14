package ds.array.sorted;
public class OneNonRepeatedNumber {
	
	// This function assumes that the input array is sorted and all except 1 number is repeated.
	// We have to move to the side where 
	// 		> even no of elements with change
	// 		> odd no of element with out change
	public static int getIndexOfNonRepeatingNumber(int [] array)
	{
		if(array.length == 1)
			return 0;
		int start = 0;
		int end = array.length -1 ;
		int mid;
		while( end  >= start )
		{
			if ( end == start )
			{
				return start;
			}
			mid = (start + end) / 2;
			if( (mid - start)%2 == 0  ) //even
			{
				if ( array[mid-1] == array[mid] )
				{
					end = mid;
				}
				else if ( array[mid+1] == array[mid] )
				{
					start = mid;
				}
				else // both side are different
				{
					return mid;
				}
					
			}
			else if ((mid - start)%2 != 0 )// odd 1 1 2 2 3 4 4
			{
				if ( array[mid-1] != array[mid] )
				{
					end = mid -1;
				}
				else if ( array[mid+1] != array[mid] )
				{
					start = mid + 1;
				}
				else // both side are different 
				{
					return mid;
				}
			}			
		}
		return -1;
	}

	public static void main(String[] args) {
		//int [] array = {1,1,2,2,3,3,4,4,5,5,6,7,7};
		int [] array = {1,1,2,2,3};
		int index = getIndexOfNonRepeatingNumber(array);
		System.out.println(index);
	}

}
