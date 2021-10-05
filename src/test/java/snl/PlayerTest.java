package snl;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {
    @Test
    public void shouldMoveToNextPositionBasedOnDiceRoll() {
        Player player = new Player();
        assertEquals(0, player.getCurrentPosition());

        //when
        player.move(10);
        //then
        assertEquals(10, player.getCurrentPosition());
    }
}
