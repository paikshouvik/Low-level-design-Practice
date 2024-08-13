package tiktactoe;


public abstract class Board {
	int maxLen, maxWidth;
	Cell cells[][];
	
	public Board(int maxLen, int maxWidth) {
		super();
		this.maxLen = maxLen;
		this.maxWidth = maxWidth;
		cells = new Cell[maxLen][maxWidth];
	}
	
	abstract GameResults getGameResult();
	void setCellValue(int row, int col, String value) throws Exception {
		if(row<1 || row>maxLen || col<1 || col>maxWidth) {
			throw new NoSuchFieldError();
		}
		if(cells[row-1][col-1]==null) {
			cells[row-1][col-1] = new Cell(value);
			return;
		}
		System.out.println("row: "+row+"  ::  col: "+col+"  :: value: "+value);
		throw new Exception();
	}
	
	
}
