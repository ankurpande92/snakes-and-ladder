package snl;

public class Player {
    private int currentPosition = 0;

    public Player() {
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public void move(int newPosition) {
        setCurrentPosition(getCurrentPosition() + newPosition);
    }
}
