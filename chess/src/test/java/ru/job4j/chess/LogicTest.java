package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

public class LogicTest {

    @Test(expected = ImpossibleMoveException.class)
    public void whenWayC1thenH5() throws FigureNotFoundException, OccupiedCellException {
        Logic logic = new Logic();
        BishopBlack black = new BishopBlack(Cell.C1);
        logic.add(black);
        black.way(Cell.H5);
        logic.move(Cell.C1, Cell.H5);
    }
}