package tiktactoe;

public class GameResults {
	GameStatus status;
	String winer;

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

	public GameResults(GameStatus status, String winer) {
		super();
		this.status = status;
		this.winer = winer;
	}

}
