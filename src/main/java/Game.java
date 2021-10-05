import snl.*;

import java.awt.geom.GeneralPath;
import java.util.Optional;

public class Game {
    private Board board;
    private Player player;
    private Dice dice;

    public Game(Board board, Player player, Dice dice) {
        this.board = board;
        this.player = player;
        this.dice = dice;
    }

    public Board getBoard() {
        return board;
    }

    public Player getPlayer() {
        return player;
    }

    public  void play() {
        int stepsToMove = dice.roll();
        player.move(stepsToMove);
        Optional<Snake> snakeEncountered = board.getSnakes()
                .stream()
                .filter(snake -> snake.getStartPosition() == player.getCurrentPosition())
                .findFirst();
        /*if (snakeEncountered.isPresent()){
            Snake snake = snakeEncountered.get();
            if (snake instanceof GreenSnake){

                if (((GreenSnake) snake).isBite()){
                    player.setCurrentPosition(snake.getStartPosition());
                }else {
                    player.setCurrentPosition(snake.getEndPosition());
                    ((GreenSnake) snake).setBite(true);
                }
            }else {
                player.setCurrentPosition(snake.getEndPosition());
            }
        }*/

        if (snakeEncountered.isPresent()){
            snakeEncountered.get().biteDecision(snakeEncountered.get());
            player.setCurrentPosition(snakeEncountered.get().getEndPosition());
        }

    }
}
