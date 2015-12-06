package prob.apigee.bid;

import java.util.Date;
import java.util.List;
import java.util.Random;

public class User implements Runnable{
	private static int maxId = 1;
	
	int id;
	private Thread thread;
	
	public User() 
	{
		synchronized (User.class) {
			this.id = User.maxId;
			User.maxId++;
		}
		this.thread = new Thread(this, "User " + this.id);
	}
	
	public void startActivities()
	{
		this.thread.start();
	}
	
	@Override
	public String toString() {
		return "User ( id = "+ this.id +")";
	}

	@Override
	public void run() 
	{
		for (int i=0;i<5;i++)
		{
			seeBid();
			putBid();
		}
		for (int i=0;i<3;i++)
			createItem();
		for (int i=0;i<15;i++)
		{
			seeBid();
			putBid();
		}
	}
	private void createItem()
	{
		new Item(this);
		// Rest
		try {
			Thread.currentThread().sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void seeBid()
	{
		if( Item.items != null  && Item.items.size() > 1)
		{
			Random rand = new Random();
			int index = rand.nextInt(Item.items.size());
			List <Bid> bids = Item.items.get(index).getBids();
			if(bids != null)
			{
				System.out.println(this.toString() + " has requested for top 5 bids for " + Item.items.get(index).toString());
				for(Bid bid : bids )
				{
					System.out.println("\t" + bid.toString());
				}
			}
		}
	}
	private void putBid()
	{
		// bid for any item
		if( Item.items != null  && Item.items.size() > 1)
		{
			Random rand = new Random();
			int index = rand.nextInt(Item.items.size());
			Item.items.get(index).putBid(this);
			// Rest
			try {
				Thread.currentThread().sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
