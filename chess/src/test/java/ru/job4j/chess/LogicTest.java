package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.QueenBlack;

public class LogicTest {

    @Test(expected = ImpossibleMoveException.class)
    public void whenWayC1thenH5() throws FigureNotFoundException, OccupiedCellException {
        Logic logic = new Logic();
        BishopBlack black = new BishopBlack(Cell.C1);
        logic.add(black);
        black.way(Cell.H5);
        logic.move(Cell.C1, Cell.H5);
    }

    @Test(expected = FigureNotFoundException.class)
    public void whenFigureNotFound() throws OccupiedCellException, FigureNotFoundException {
        Logic logic = new Logic();
        logic.move(Cell.A1, Cell.F3);
    }

    @Test(expected = OccupiedCellException.class)
    public void whenFigureNotFree() throws FigureNotFoundException, OccupiedCellException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.add(new QueenBlack(Cell.E3));
        logic.move(Cell.C1, Cell.G5);
    }
}