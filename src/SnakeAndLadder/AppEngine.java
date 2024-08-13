package SnakeAndLadder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppEngine {
    private Board board;
    private List<String> players;
    private int currentPlayer;
    private int noOfPlayers;

    public AppEngine(Board board, int noOfPlayers) {
        this.board = board;
        this.currentPlayer = 0;
        this.noOfPlayers = noOfPlayers;
    }

    protected void setupPlayers(Scanner sc) {
        this.players = new ArrayList<>();
        for (int i = 0; i < noOfPlayers; i++) {
            System.out.print(String.format("Enter player %s name: ",(i+1)));
            players.add(sc.nextLine());
        }
    }

    public Board getBoard() {
        return board;
    }

    public List<String> getPlayers() {
        return players;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void moveTONextPlayer() {
        currentPlayer++;
        currentPlayer = currentPlayer%players.size();
    }

    public int getNoOfPlayers() {
        return noOfPlayers;
    }
}
