package prob.fk.chess;

public class Bishop extends Piece 
{
	public static final String nameCode = "B";
	public Bishop(String colorCode) 
	{
		super(colorCode, nameCode);
	}
	
	public boolean validate(int toX,int toY, int fromX,int  fromY,Board board) 
	{
		return ( isValidPosition( toX,toY,board)
				&& isValidPosition( fromX,fromY,board)
				&& isFinalPayable( toX,toY,board) 
				&& (isDiagonal(toX, toY, fromX, fromY))
				&& isDiagonalPathClear(toX, toY, fromX, fromY, board));
		//Hc .is valid
	}


}

// inter
//	isDia
//	isPath