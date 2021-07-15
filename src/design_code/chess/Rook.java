package prob.fk.chess;

public class Rook extends Piece 
{
	public static final String nameCode = "R";
	public Rook(String colorCode) 
	{
		super(colorCode, nameCode);
	}
	
	@Override
	public boolean validate(int toX,int toY, int fromX,int  fromY,Board board) 
	{
		return ( isValidPosition( toX,toY,board)
				&& isValidPosition( fromX,fromY,board)
				&& isFinalPayable( toX,toY,board) 
				&& (isHorizontal(toX, toY, fromX, fromY) && isHorizontalPathClear(toX, toY, fromX, fromY, board)
						|| isVirtical(toX, toY, fromX, fromY) && isVirticalPathClear(toX, toY, fromX, fromY, board)));
	}

}
