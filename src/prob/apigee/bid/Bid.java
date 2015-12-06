package prob.apigee.bid;

public class Bid 
{
	private User by;
	private int price;

	public Bid(User by, int price) {
		this.by = by;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Bid by " + this.by.toString() + " for price = " + this.price;  
	}

	public int getPrice() {
		return price;
	}
	
}
