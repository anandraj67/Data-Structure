package prob.ola.bowling;

public class RollSecond implements Spare{
	private int pinsAtStart;
	private int pinsDown;
	public RollSecond(int pinsAtStart) {
		this.pinsAtStart = pinsAtStart;
		this.pinsDown = -1;
	}
	@Override
	public boolean isSpare() {
		if(this.pinsDown + this.pinsAtStart == Spare.spareValue)
			return true;
		return false;
	}
	void roll(int pinsDown)
	{
		if(this.pinsAtStart < pinsDown)
			throw new RuntimeException("pinsAtStart < pinsDown");
		this.pinsDown = pinsDown;
	}
	public int getPoints() {
		if(this.isSpare())
			return pinsDown + Spare.spareBonus;
		return pinsDown;
	}
}
