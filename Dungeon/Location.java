package Dungeon;

public class Location 
{
	private int row;
	private int col;
	
	public Location(int row, int col)
	{
		this.row = row;
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}
	
	public boolean isValidLocation()
	{
		if(this.row < 0 || this.row > 4 || this.col < 0 || this.col > 4)
			return false;
		
		return true;
	}
	
	
}
