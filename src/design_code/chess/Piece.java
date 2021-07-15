package design_code.chess;

public abstract class Piece
{
	private String nameCode;
	private String colorCode;
	
	
	public Piece(String nameCode, String colorCode) 
	{
		super();
		this.nameCode = nameCode;
		this.colorCode = colorCode;
	}


	public String getNameCode() {
		return nameCode;
	}


	public String getColorCode() {
		return colorCode;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((colorCode == null) ? 0 : colorCode.hashCode());
		result = prime * result
				+ ((nameCode == null) ? 0 : nameCode.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Piece other = (Piece) obj;
		if (colorCode == null) {
			if (other.colorCode != null)
				return false;
		} else if (!colorCode.equals(other.colorCode))
			return false;
		if (nameCode == null) {
			if (other.nameCode != null)
				return false;
		} else if (!nameCode.equals(other.nameCode))
			return false;
		return true;
	}

	public boolean isVirtical(int toX,int toY, int fromX,int  fromY)
	{
		return (toX == fromX && toY != fromY);
	}
	
	public boolean isHorizontal(int toX,int toY, int fromX,int  fromY)
	{
		return (toY == fromY && toX != fromX);
	}
	
	public boolean isDiagonal(int toX,int toY, int fromX,int  fromY)
	{
		return ( (toY - fromY) == (toX  - fromX));
	}
	
	public boolean isFinalPayable( int toX,int  toY,Board board)
	{
		Piece piece = board.getMatrix()[toX][toY].getPiece();
		return (piece == null || ! piece.getColorCode().equals(this.getColorCode() ));
	}
	
	public boolean isValidPosition(int x,int y,Board board)
	{
		return (x >= 0 && x < board.getSize() && y >= 0 && y < board.getSize() );
	}
	
	public int stepSize(int toX,int toY, int fromX,int  fromY)
	{
		return (toX == fromX)? Math.abs(toY - fromY) :Math.abs(toX - fromX);  
	}
	
	public boolean isVirticalPathClear( int toX,int toY, int fromX,int  fromY,Board board)
	{
		int startY = (toY > fromY)?fromY : toY;
		int endY = (toY > fromY)?fromY : toY;
		return true;
	}
	
	public boolean isHorizontalPathClear( int toX,int toY, int fromX,int  fromY,Board board)
	{
		return true;
	}
	
	public boolean isDiagonalPathClear( int toX,int toY, int fromX,int  fromY,Board board)
	{
		return true;
	}
	
	

	public abstract boolean validate(int toX,int toY, int fromX,int  fromY,Board board);
}
