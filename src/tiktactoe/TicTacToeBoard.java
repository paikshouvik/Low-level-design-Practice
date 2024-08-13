package tiktactoe;

public class TicTacToeBoard extends Board {
	
    public TicTacToeBoard(int maxLen, int maxWidth) {
        super(maxLen, maxWidth);
    }

    @Override
    public GameResults getGameResult() {
        boolean checkRows = checkRows();
        if (checkRows() || checkColumns() || checkDiagonals()) {
            return new GameResults(GameStatus.OVER, getWinerPlayer());
        }
        return new GameResults(GameStatus.NOT_OVER, "-");
    }

    private boolean checkRows() {
        for (int i = 0; i < maxLen; i++) {
            if (checkLine(cells[i])) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumns() {
        for (int j = 0; j < maxWidth; j++) {
            Cell[] column = new Cell[maxLen];
            for (int i = 0; i < maxLen; i++) {
                column[i] = cells[i][j];
            }
            if (checkLine(column)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonals() {
        Cell[] diagonal1 = new Cell[maxLen];
        Cell[] diagonal2 = new Cell[maxLen];
        for (int i = 0; i < maxLen; i++) {
            diagonal1[i] = cells[i][i];
            diagonal2[i] = cells[i][maxWidth - 1 - i];
        }
        return checkLine(diagonal1) || checkLine(diagonal2);
    }

    private boolean checkLine(Cell[] line) {
        if (line[0] == null) return false;
        String firstValue = line[0].getValue();
        for (Cell cell : line) {
            if (cell == null || !cell.getValue().equals(firstValue)) {
                return false;
            }
        }
        winer = firstValue;
        return true;
    }

    private String getWinerPlayer() {
        return this.winer;
    }
}
