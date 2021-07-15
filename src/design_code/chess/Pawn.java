package prob.fk.chess;

public class Pawn extends Piece 
{
	public static final String nameCode = "P";
	public Pawn(String colorCode) 
	{
		super(colorCode, nameCode);
	}
	
	@Override
	public boolean validate(int toX,int toY, int fromX,int  fromY,Board board) 
	{
		
		return false;
	}

}
