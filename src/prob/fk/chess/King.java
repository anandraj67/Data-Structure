package prob.fk.chess;

public class King extends Piece 
{
	public static final String nameCode = "K";
	public King(String colorCode) 
	{
		super(colorCode, nameCode);
	}
	
	@Override
	public boolean validate(int toX,int toY, int fromX,int  fromY,Board board) 
	{
		
		return false;
	}

}
