package prob.ola.bowling;

public class Set {
	public static int maxpins = 10;
	RollFirst rollFirst;
	RollSecond rollSecond;
	int points;
	
	public Set() {
		this.points = 0;
	}

	public void roll()
	{
		this.rollFirst = new RollFirst();
		this.rollFirst.roll( ( (int)Math.random() )% (Set.maxpins + 1) );
		
		if (this.rollFirst.isStrike() )
		{
			points = rollFirst.getPoints(); 
		}
		else
		{
			rollSecond = new RollSecond(rollFirst.getPinsLeft());
			rollSecond.roll(( (int)Math.random() )% (rollFirst.getPinsLeft() + 1));
			points += rollSecond.getPoints();
		}
	
	}

	public int getPoints() {
		return points;
	}
	
	
}
