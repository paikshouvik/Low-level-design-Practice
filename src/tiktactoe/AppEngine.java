package tiktactoe;

import java.util.Scanner;

public class AppEngine {
    private Board board;
    private String player1;
    private String player2;
    private boolean isPlayerOneMove = true;
    private int maxSize = 9;
    public AppEngine() {
        this.board = new TicTacToeBoard(3, 3);
    }

    public void startGame() {
        try (Scanner sc = new Scanner(System.in)) {
            setupPlayers(sc);
            printBoard();
            playGame(sc);
        }
    }

    private void setupPlayers(Scanner sc) {
        System.out.print("Enter player 1 name: ");
        player1 = sc.nextLine();
        System.out.print("Enter player 2 name: ");
        player2 = sc.nextLine();
    }

    private void printBoard() {
        board.printBoard();
    }

    private void playGame(Scanner sc) {
        int count = 0;
        while (true) {
            System.out.println("Enter row (1-3):");
            int row = sc.nextInt() - 1;
            System.out.println("Enter col (1-3):");
            int col = sc.nextInt() - 1;
            sc.nextLine(); // Consume newline

            if (processMove(row, col)) {
                printBoard();
                GameResults result = board.getGameResult();
                if (result.getStatus() == GameStatus.OVER) {
                    announceResult(result);
                    break;
                }
                if (board.isBoardFull()) {
                    System.out.println("Game Draw!");
                    break;
                }
                isPlayerOneMove = !isPlayerOneMove;
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

    private boolean processMove(int row, int col) {
        String currentPlayer = isPlayerOneMove ? player1 : player2;
        try {
            board.setCellValue(row, col, currentPlayer);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private void announceResult(GameResults result) {
        if (result.getStatus() == GameStatus.OVER) {
            String winner = result.getWiner();
            System.out.println("Congratulations! Player " + (winner.equals(player1) ? player1 : player2) + " won!");
        }
    }
}
