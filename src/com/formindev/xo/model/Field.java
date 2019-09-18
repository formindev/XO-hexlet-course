package com.formindev.xo.model;

import com.formindev.xo.model.exceptions.AlreadyOccupiedException;
import com.formindev.xo.model.exceptions.InvalidPointException;

import java.awt.Point;

public class Field {

    private final int FIELD_SIZE = 3;

    private final int MIN_COORD = 0;

    private final int MAX_COORD = FIELD_SIZE;

    private final Figure[][] field = new Figure[FIELD_SIZE][FIELD_SIZE];

    public int getSize() {

        return FIELD_SIZE;
    }

    public Figure getFigure(Point point) throws InvalidPointException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }

        return field[point.x][point.y];
    }

    public void setFigure(Point point, Figure figure) throws InvalidPointException, AlreadyOccupiedException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }
        
        if (field[point.x][point.y] != null) {
            throw new AlreadyOccupiedException();
        }

        field[point.x][point.y] = figure;
    }

    private boolean checkPoint(final Point point) {
        return checkCoordinate(point.x) && checkCoordinate(point.y);
    }

    private boolean checkCoordinate(final int coord) {
        return coord >= MIN_COORD && coord < MAX_COORD;
    }

}