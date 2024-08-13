package tiktactoe;

public class GameResults {
    private GameStatus status;
    private String winer;

    public GameResults(GameStatus status, String winer) {
        this.status = status;
        this.winer = winer;
    }

    public GameStatus getStatus() {
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
