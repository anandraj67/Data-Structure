package prob.apigee.bid;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Item {
	private static final long durationOfBid = 3*1000;
	private static final int bidLength = 5;
	
	private static int maxId = 0;
	public static ArrayList<Item> items = new ArrayList<Item>();
	
	private int id;
	private User createdBy;
	
	private long startTime;
	private long endTime;
	
	private  List<Bid> bids;
	
	Item (User createdBy)
	{
		synchronized (Item.class) {
			this.id = maxId;
			Item.maxId++;
			this.createdBy = createdBy;
			this.startTime = new Date().getTime();
			this.endTime = this.startTime + Item.durationOfBid;
			this.bids = new LinkedList<Bid>();
			Item.items.add(this);
		}
	}
	
	public synchronized List<Bid> getBids()
	{
		return this.bids;
	}
	
	public synchronized void putBid(User by)  
	{
		if( new Date().getTime() < this.endTime )
		{
			int maxBidNow = 1;
			if( this.bids != null && this.bids.size() > 0 )
			{
				maxBidNow = this.bids.get(0).getPrice();
			}
			Random rand  = new Random();
			int bidPrice = maxBidNow + rand.nextInt(5) + 1;
			
			Bid bid = new Bid(by, bidPrice);
			this.bids.add(0, bid);
			if(this.bids.size() > bidLength)
			{
				this.bids.remove(bidLength);
			}
			System.out.println(bid.toString() + " for " + this.toString());
		}
		else
		{
			System.out.println("Sorry, " + by.toString() + " the " + this.toString() + "is expired.");
		}
	}

	@Override
	public String toString() 
	{
		String status ="Active";
		if (new Date().getTime() > this.endTime)
			status = "Inactive";
		return "Item ( id = "  + this.id + ",Staus = " + status + ")";
	}
	
}