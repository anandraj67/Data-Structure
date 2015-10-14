package prob.ola.bowling;

import java.util.List;

public class RollFirst implements Strike{
	private int pinDown;
	public RollFirst() {
		this.pinDown = -1;
	}

	@Override
	public boolean isStrike() {
		if(this.pinDown == Strike.strikeValue)
		{
			return true;
		}
		return false;
	}
	
	void roll(int pinDown)
	{
		if(pinDown > Set.maxpins || pinDown < 0)
			throw new RuntimeException();
		this.pinDown = pinDown;
	}

	public int getPoints() {
		if(this.isStrike())
			return this.pinDown + Strike.strikeBonus;
		else
			return pinDown;
	}
	int getPinsLeft()
	{
		return Set.maxpins - this.pinDown;
	}
}
