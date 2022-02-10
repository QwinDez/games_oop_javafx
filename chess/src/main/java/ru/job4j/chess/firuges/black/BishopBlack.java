package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not way by diagonal from %s to %s", position, dest)
            );
        }
        int size = (int) Math.sqrt((Math.pow(dest.getX() - position().getX(), 2)));
        Cell[] steps = new Cell[size];
        int deltaX = position.getX();
        int deltaY = position.getY();
        int x = 1;
        int y = -1;
        for (int index = 0; index < size; index++) {
            x = (position.getX() < dest.getX() || position.getY() < dest.getY())
                    ? deltaX + 1 + index : deltaX - 1 - index;
            y = deltaY - 1 - index;
            steps[index] = Cell.findBy(x, y);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        boolean result = false;
        double x = Math.pow((dest.getX() - source.getX()), 2);
        double y = Math.pow((dest.getY() - source.getY()), 2);
        if (x == y && dest.getY() <= 8 && dest.getY() > 0
                && dest.getX() <= 8 && dest.getX() > 0) {
            result = true;
        }
        return result;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
