package snl;

public class Snake {
    private int startPosition;
    private int endPosition;
    private boolean bite = false;

    public Snake(int startPosition, int endPosition) {
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }

    public int getStartPosition() {
        return startPosition;
    }

    public int getEndPosition() {
        return endPosition;
    }

    public void setEndPosition(int endPosition) {
        this.endPosition = endPosition;
    }

    public void biteDecision(Snake snake) {
        if (bite) {
            snake.setEndPosition(snake.getStartPosition());
        } else {
            snake.setEndPosition(snake.getEndPosition());
            bite=true;
        }
    }
}
