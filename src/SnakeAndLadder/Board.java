package tiktactoe;

public abstract class Board {
    protected int maxLen;
    protected int maxWidth;
    protected Cell[][] cells;
    protected String winer;

    public Board(int maxLen, int maxWidth) {
        this.maxLen = maxLen;
        this.maxWidth = maxWidth;
        cells = new Cell[maxLen][maxWidth];
    }

    public abstract GameResults getGameResult();

    public void setCellValue(int row, int col, String value) throws Exception {
        if (row < 0 || row >= maxLen || col < 0 || col >= maxWidth) {
            throw new IllegalArgumentException("Cell position out of bounds");
        }
        if (cells[row][col] == null) {
            cells[row][col] = new Cell(value);
        } else {
            throw new IllegalStateException("Cell already occupied");
        }
    }

    public boolean isBoardFull() {
        for (int i = 0; i < maxLen; i++) {
            for (int j = 0; j < maxWidth; j++) {
                if (cells[i][j] == null) {
                    return false;
                }
            }
        }
        return true;
    }

    public void printBoard() {
        for (int i = 0; i < maxLen; i++) {
            for (int j = 0; j < maxWidth; j++) {
                System.out.print((cells[i][j] == null ? '-' : cells[i][j].getValue()) + " ");
            }
            System.out.println();
        }
    }
}
