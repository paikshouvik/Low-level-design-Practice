package SnakeAndLadder;

import java.util.*;

public class SnakeLadderAppEngine extends AppEngine{
    private static int n = 10;
    private int NoOfPlayerYetToReachFinalDestination;
    private List<Integer> playerPositions;
    private Map<Integer,Integer> playerFinishAtMap = new HashMap<Integer,Integer>();

    public SnakeLadderAppEngine(int noOfPlayers) {
        super(new SnakeLadderBoard(n,n), noOfPlayers);
        this.NoOfPlayerYetToReachFinalDestination = noOfPlayers;
    }

    protected void setupPlayers(Scanner sc) {
        super.setupPlayers(sc);
        for (int i = 0; i < getNoOfPlayers(); i++) {
            playerPositions.add(1);
        }
    }

    protected void startGame(){
        try (Scanner sc = new Scanner(System.in)) {
            setupPlayers(sc);
            playGame(sc);
        }
    }

    private void playGame(Scanner sc) {
        while (true) {
            int diceOutcome = rollDice(1,6);
            if (!getCurrentplayerReachFinalPosition()){
                int newPositionOnBoard = getCurrentplayerPosition() + diceOutcome;
                newPositionOnBoard =  calculateNewPositionBasedOnSnakeAndLadder(newPositionOnBoard);
                setCurrentplayerPosition(newPositionOnBoard);
                if(newPositionOnBoard==n*n){
                    playerFinishAtMap.put(getCurrentPlayer(),(n-NoOfPlayerYetToReachFinalDestination+1));
                    NoOfPlayerYetToReachFinalDestination--;
                }
            }
            moveTONextPlayer();
            if(NoOfPlayerYetToReachFinalDestination==0){
                playerFinishAtMap.forEach((player,position)->{System.out.println("The player "+player+" finished at position "+position);});
                break;
            }
        }
    }

    private int calculateNewPositionBasedOnSnakeAndLadder(int newPositionOnBoard) {
        // need add logic here
        return newPositionOnBoard;
    }


    private boolean getCurrentplayerReachFinalPosition() {
        return playerPositions.get(getCurrentPlayer())==n*n;
    }

    private int getCurrentplayerPosition() {
        return playerPositions.get(getCurrentPlayer());
    }

    private void setCurrentplayerPosition(int newPosition) {
        playerPositions.set(getCurrentPlayer(),newPosition);
    }

    Random random = new Random();
    private int rollDice(int min, int max) {
        return random.ints(min,max).findFirst().getAsInt();
    }
}
