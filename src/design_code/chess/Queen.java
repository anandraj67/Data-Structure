package prob.fk.chess;

public class Queen extends Piece 
{
	public static final String nameCode = "Q";
	public Queen(String colorCode) 
	{
		super(colorCode, nameCode);
	}
	
	@Override
	public boolean validate(int toX,int toY, int fromX,int  fromY,Board board) 
	{
		
		return false;
	}

}
