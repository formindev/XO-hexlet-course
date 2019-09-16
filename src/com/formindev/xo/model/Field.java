package com.formindev.xo.model;

public class Field {

    private final int FIELD_SIZE = 3;

    private final int MIN_COORD = 0;

    private final int MAX_COORD = FIELD_SIZE;

    private final Figure[][] field = new Figure[FIELD_SIZE][FIELD_SIZE];

    public int getSize() {
        return FIELD_SIZE;
    }

    public Figure getFigure(Point point) {
        return field[point.x][point.y];
    }

    public void setFigure(Point point, Figure figure) {
        field[point.x][point.y] = figure;
    }
}