package snl;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int size = 100;
    private List<Snake> snakes = new ArrayList<>();

    public Board() {
        snakes.add(new Snake(14, 7));
        snakes.add(new GreenSnake(24,10));
    }

    public Board(List<Snake> snakes) {
        this.snakes = snakes;
    }

    public int getSize() {
        return size;
    }

    public List<Snake> getSnakes() {
        return snakes;
    }
}
