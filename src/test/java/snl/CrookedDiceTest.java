package snl;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CrookedDiceTest {
    @Test
    public void shouldReturnAlwaysEvenValue() {
        CrookedDice crookedDice = new CrookedDice();
        assertEquals(0, crookedDice.roll() % 2);
    }

    @Test
    public void shouldReturnTwoWhenRandomReturnOddInteger() {
        Random random = mock(Random.class);
        when(random.nextInt(eq(7))).thenReturn(1);
        CrookedDice crookedDice = new CrookedDice(random);
        assertEquals(2, crookedDice.roll());
    }

    @Test
    public void shouldReturnTwoWhenRandomReturnZero() {
        Random random = mock(Random.class);
        when(random.nextInt(eq(7))).thenReturn(0);
        CrookedDice crookedDice = new CrookedDice(random);
        assertEquals(2, crookedDice.roll());
    }
}
