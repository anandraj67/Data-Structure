package prob.fk.chess;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Simulator 
{
	public static void main(String[] args)
	{
		File file = new File("src/com/fk/chess/Input.file");
		Scanner in = null;
		try {
			in = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Cell [][] matrix  = new Cell[8][8];
	
		for(int i =0 ; i< 8;i++)
		{
			for(int j=0;j<8;j++)
			{
				String key = in.next();
				String []arr =  key.split("_");
				Cell cell =null;
				Piece piece = null;
				if(! arr[0].equals("-"))
				{
					piece = getPieceFromCode(arr[1],arr[0]);
				}
				matrix[i][j] = new Cell(piece); 
			}
		}
		Board board = new Board(8, matrix);
		
		// Rook
		System.out.println(isValidMove(7, 6, 7, 7, board));
		//System.out.println(isValidMove(4, 7, 7, 7, board));
		//System.out.println(isValidMove(-1, 7, 7, 7, board));
		
		// Bishop 
		//System.out.println(isValidMove(0, 5, 2, 7, board));
	}
	public static boolean isValidMove( int toX,int toY, int fromX,int  fromY,Board board)
	{
		Piece piece = getPieceFromCode(board.getMatrix()[fromX][fromY].getPiece().getNameCode(),
										board.getMatrix()[fromX][fromY].getPiece().getColorCode());
		return (piece==null)? false : piece.validate(toX, toY, fromX, fromY, board);
	}
	public static Piece getPieceFromCode(String code,String color)
	{
		Piece piece = null; 
		if("R".equals(code))
			piece = new Rook(color);
		if("B".equals(code))
			piece = new Bishop(color);
		if("H".equals(code))
			piece = new Horse(color);
		if("K".equals(code))
			piece = new King(color);
		if("Q".equals(code))
			piece = new Queen(color);
		if("P".equals(code))
			piece = new Pawn(color);
		return piece;
	}
	
}
