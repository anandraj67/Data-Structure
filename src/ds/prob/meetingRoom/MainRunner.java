package ds.prob.meetingRoom;

import java.util.ArrayList;

class Slot
{
	int start;
	int end;
	int meetingRoomNeeded;
	public Slot(int start, int end, int meetingRoomNeeded) {
		this.start = start;
		this.end = end;
		this.meetingRoomNeeded = meetingRoomNeeded;
	}

}

class Meeting
{
	int start;
	int end;
}


public class MainRunner {

	public int find(ArrayList<Slot> slots,int time)
	{
		int start = 0;
		int end = slots.size()-1;
		int mid;
		while(start<=end)
		{
			mid = (start+end)/2;
			if(slots.get(mid).start <= time &&  time <= slots.get(mid).end )
			{
				return mid-1;
			}
			else if (slots.get(mid).start > time )
			{
				end = mid-1;
			}
			else if (slots.get(mid).end < time
					&& slots.get(mid+1)!=null
					&& slots.get(mid+1).end < time)
			{
				start = mid+1;
			}
		}
		return end;
	}
	public int maximumMeetingRoomNeed(Meeting []meetings)
	{
		int maximumMeetingRoomNeed = 0;
		ArrayList<Slot> slots = new ArrayList<Slot>();
		for(Meeting meeting : meetings)
		{
			int startIndex = find(slots,meeting.start);
			//node creations

		}
		return 0;
	}

	public static void main(String[] args) {


	}

}
