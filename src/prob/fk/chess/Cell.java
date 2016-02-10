package prob.fk.chess;

public class Cell implements Cloneable
{
	private Piece piece;

	public Cell(Piece piece) 
	{
		super();
		this.piece = piece;
	}

	public Piece getPiece() {
		return piece;
	}
	public Object clone(){  
		return super.clone();  
	}  

	
}
