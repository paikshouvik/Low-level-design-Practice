package tiktactoe;

import SnakeAndLadder.GameStatus;

public class GameResults {
    private SnakeAndLadder.GameStatus status;
    private String winer;

    public GameResults(SnakeAndLadder.GameStatus status, String winer) {
        this.status = status;
        this.winer = winer;
    }

    public SnakeAndLadder.GameStatus getStatus() {
        return status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    public String getWiner() {
        return winer;
    }

    public void setWiner(String winer) {
        this.winer = winer;
    }
}
