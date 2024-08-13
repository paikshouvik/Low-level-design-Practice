package SnakeAndLadder;

import java.util.List;
import java.util.Map;

public class SnakeLadderBoard extends Board{

    private Map<Integer,Integer> snakeLocations;
    private Map<Integer,Integer> ladderLocations;

    public SnakeLadderBoard(int maxLen, int maxWidth) {
        super(maxLen, maxWidth);
    }

    public Map getSnakeLocations() {
        return snakeLocations;
    }

    public void setSnakeLocations(Map snakeLocations) {
        this.snakeLocations = snakeLocations;
    }

    public Map getLadderLocations() {
        return ladderLocations;
    }

    public void setLadderLocations(Map ladderLocations) {
        this.ladderLocations = ladderLocations;
    }

    public int RePositionDueToSnake(int position){
        if(snakeLocations.containsKey(position)){
            return position - snakeLocations.get(position);
        }
        return position;
    }

    public int RePositionDueToLadder(int position){
        if(ladderLocations.containsKey(position)){
            return position + ladderLocations.get(position);
        }
        return position;
    }
}
