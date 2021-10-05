import snl.*;
import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class GameTest {
    @Test
    public void shouldSetPositionCorrectlyOnSnakeBite() {
        Board board = new Board(Collections.singletonList(new Snake(14, 7)));
        Player player = mock(Player.class);
        when(player.getCurrentPosition()).thenReturn(14);
        Game game = new Game(board, player, new Dice());
        //when
        game.play();
        //then
        verify(player).setCurrentPosition(eq(7));
    }

    @Test
    public void shouldSetPositionCorrectlyOnGreenSnakeBite() {
        Board board = new Board(Collections.singletonList(new GreenSnake(14, 7)));
        Player player = mock(Player.class);
        when(player.getCurrentPosition()).thenReturn(14);
        Game game = new Game(board, player, new Dice());
        //when
        game.play();
        //then
        verify(player).setCurrentPosition(eq(7));

        game.play();
        //then
        verify(player).setCurrentPosition(eq(14));

    }

    @Test
    public void whenSnakeIsNotFoundPlayerShouldStayAtPosition() {
        Board board = new Board(Collections.singletonList(new Snake(14, 7)));
        Player player = mock(Player.class);
        when(player.getCurrentPosition()).thenReturn(15);
        Game game = new Game(board, player, new Dice());
        //when
        game.play();
        //then
        verify(player, times(0)).setCurrentPosition(anyInt());
    }

    @Test
    public void testMultipleRuns() {
        Board board = new Board(Collections.singletonList(new Snake(9, 7)));
        Dice dice = mock(Dice.class);
        when(dice.roll()).thenReturn(5).thenReturn(4);
        Player player = new Player();
        Game game = new Game(board, player, dice);

        //when
        game.play();
        //then
        assertEquals(5, player.getCurrentPosition());

        //when
        game.play();
        //then
        assertEquals(7, player.getCurrentPosition());
    }

    @Test
    public void shouldReturnCorrectlyWhenDiceIsCrooked() {
        Board board = new Board(Collections.singletonList(new Snake(9, 7)));
        Dice dice = mock(CrookedDice.class);
        when(dice.roll()).thenReturn(4).thenReturn(2);
        Player player = new Player();
        Game game = new Game(board, player, dice);

        //when
        game.play();
        //then
        assertEquals(4, game.getPlayer().getCurrentPosition());

        //when
        game.play();
        //then
        assertEquals(6, game.getPlayer().getCurrentPosition());
    }
}
