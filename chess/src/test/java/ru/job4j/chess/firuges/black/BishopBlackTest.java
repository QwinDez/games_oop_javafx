package ru.job4j.chess.firuges.black;

import org.junit.Assert;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class BishopBlackTest {

    @Test
    public void whenPosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.F8);
        Cell cell = bishopBlack.position();
        assertThat(cell, is(Cell.F8));
    }

    @Test
    public void whenCopy() {
        BishopBlack bishopBlack = new BishopBlack(Cell.F8);
        BishopBlack black = new BishopBlack(bishopBlack.copy(Cell.A6).position());
        assertThat(black.position(), is(Cell.A6));
    }

    @Test
    public void whenWayC1ThenG5() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] result = bishopBlack.way(Cell.G5);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        Assert.assertArrayEquals(expected, result);
    }

    @Test
    public void whenNotDiagonal() {
        new BishopBlack(Cell.C1).isDiagonal(Cell.C1, Cell.G5);
    }

}