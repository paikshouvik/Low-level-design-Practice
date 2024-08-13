package tiktactoe;

public class TicTacToeBoard extends Board{

	public TicTacToeBoard(int maxLen, int maxWidth) {
		super(maxLen, maxWidth);
	}

	@Override
	GameResults getGameResult() {
		for (int i = 0; i < cells.length; i++) {
			boolean isGameOver = true;
			for (int j = 0; j < cells[i].length; j++) {
				if(cells[i][j]==null || cells[i][0]==null || !(cells[i][j].value).equalsIgnoreCase(cells[i][0].value)) {
					isGameOver = false;
					break;
				}
			}
			if(isGameOver) {
				return new GameResults(GameStatus.OVER,cells[i][0].getValue());
			}
		}
		
		for (int j = 0; j < cells[0].length; j++) {
			boolean isGameOver = true;
			for (int i = 0; i < cells.length; i++) {
				if(cells[i][j]==null || cells[0][j]==null || !(cells[i][j].value).equalsIgnoreCase(cells[0][j].value)) {
					isGameOver = false;
					break;
				}
			}
			if(isGameOver) {
				return new GameResults(GameStatus.OVER,cells[0][j].getValue());
			}
		}
		boolean isGameOverDiagonal = true;
		boolean isGameOverRevDiagonal = true;
		
		for (int i = 0; i < cells.length; i++) {
			if(cells[i][i]==null ||!(cells[i][i].value).equalsIgnoreCase(cells[0][0].value)) {
				isGameOverDiagonal = false;
			}
			if(cells[i][maxWidth-i-1]==null || cells[0][maxWidth-1]==null || !(cells[i][maxWidth-i-1].value).equalsIgnoreCase(cells[0][maxWidth-1].value)) {
				isGameOverRevDiagonal = false;
			}
		}
		if(isGameOverDiagonal) {
			return new GameResults(GameStatus.OVER,cells[0][0].getValue());
		}
		if(isGameOverRevDiagonal) {
			return new GameResults(GameStatus.OVER,cells[0][maxWidth-1].getValue());
		}
		return new GameResults(GameStatus.NOT_OVER,"-");
	}

}
