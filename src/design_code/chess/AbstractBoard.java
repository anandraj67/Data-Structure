package prob.fk.chess;

import java.util.HashMap;

public abstract class AbstractBoard 
{
	private int size;
	private Cell [][] matrix;
	
	public AbstractBoard(int size, Cell[][] matrix) {
		super();
		this.size = size;
		this.matrix = matrix;
	}

	public int getSize() {
		return size;
	}


	public Cell[][] getMatrix() {
		return matrix;
	}
}
