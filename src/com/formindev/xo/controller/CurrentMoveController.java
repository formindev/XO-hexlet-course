package com.formindev.xo.controller;

import com.formindev.xo.model.Field;
import com.formindev.xo.model.Figure;
import com.formindev.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class CurrentMoveController {

    public Figure currentMove(final Field field) throws InvalidPointException {
        int countFigures = 0;
        for (int i = 0; i < field.getSize(); i++) {
            countFigures += countFiguresInRow(field, i);
        }

        if (countFigures == field.getSize() * field.getSize())
            return null;

        if (countFigures % 2 == 0)
            return Figure.X;

        return Figure.O;
    }

    private int countFiguresInRow(Field field, int row) throws InvalidPointException {
        int countFigures = 0;
        for (int i = 0; i < field.getSize(); i++) {
            if (field.getFigure(new Point(row, i)) != null)
                countFigures += 1;
        }

        return countFigures;
    }

}
