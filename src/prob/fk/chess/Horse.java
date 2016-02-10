package prob.fk.chess;

public class Horse extends Piece 
{
	public static final String nameCode = "H";
	public Horse(String colorCode) 
	{
		super(colorCode, nameCode);
	}
	
	@Override
	public boolean validate(int toX,int toY, int fromX,int  fromY,Board board) 
	{
		
		return true;
	}

}
