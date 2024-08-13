package tiktactoe;

import java.util.Scanner;

public class TicTacToeAppEngine extends AppEngine{

    private static int n = 3;
    private int maxSize = n*n;

    public TicTacToeAppEngine() {
        super(new TicTacToeBoard(n, n),2);
    }

    public void startGame() {
        try (Scanner sc = new Scanner(System.in)) {
            setupPlayers(sc);
            printBoard();
            playGame(sc);
        }
    }

    protected void playGame(Scanner sc) {
        int count = 0;
        while (true) {
            System.out.println("Enter row (1-3):");
            int row = sc.nextInt() - 1;
            System.out.println("Enter col (1-3):");
            int col = sc.nextInt() - 1;
            sc.nextLine(); // Consume newline

            if (processMove(row, col)) {
                printBoard();
                GameResults result = getBoard().getGameResult();
                if (result.getStatus() == GameStatus.OVER) {
                    announceResult(result);
                    break;
                }
                if (getBoard().isBoardFull()) {
                    System.out.println("Game Draw!");
                    break;
                }
                moveTONextPlayer();
            } else {
                System.out.println("Invalid move! Try again.");
            }
            if(count>=maxSize){
                System.out.println("Match Draw !!");
                break;
            }
            count++;
        }
    }

    protected boolean processMove(int row, int col) {
        String currentPlayer = getPlayers().get(getCurrentPlayer());
        try {
            getBoard().setCellValue(row, col, currentPlayer);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
