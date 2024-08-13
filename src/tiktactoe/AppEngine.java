package tiktactoe;

import java.util.Scanner;

public class AppEngine {
	/*
 	https://workat.tech/machine-coding/practice/design-tic-tac-toe-smyfi9x064ry 
	*/
	
	Board board = new TicTacToeBoard(3, 3);
	
	public void startGame() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter player 1 name: ");
		String player1 = sc.nextLine();
		System.out.println();
		System.out.print("Enter player 2 name: ");
		System.out.println();
		String player2 = sc.nextLine();
		String gameStatus = getGameStatus();
		boolean isPlayerOneMove = true;
		while (gameStatus.equalsIgnoreCase(GameStatus.NOT_OVER.toString())) {
			System.out.println("Enter row:");
			int row = sc.nextInt();
			System.out.println("Enter col:");
			int col = sc.nextInt();
			try {
				makeAMove(row, col, isPlayerOneMove?player1:player2);
				isPlayerOneMove = !isPlayerOneMove;				
			} catch (Exception e) {
				e.printStackTrace();
				System.err.print("Invalid move!! try again");
			}
			gameStatus = getGameStatus();
		}
		GameResults gameResult =  board.getGameResult();
		if(gameResult.getStatus().toString().equalsIgnoreCase(GameStatus.OVER.toString())) {
			System.out.println("Yeehh!! Player "+gameResult.getWiner()+" won !!!");
		}else {
			System.out.println("Game Draw!");
		}
	}
	
	private String getGameStatus() {
		return board.getGameResult().getStatus().toString();
	}
	
	private void makeAMove(int row, int col, String playerId) throws Exception {
		board.setCellValue(row, col, playerId);
	}
	
	
	
	
}
