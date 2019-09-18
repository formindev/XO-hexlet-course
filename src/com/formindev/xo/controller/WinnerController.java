package com.formindev.xo.controller;

import com.formindev.xo.model.Field;
import com.formindev.xo.model.Figure;
import com.formindev.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class WinnerController {

    public Figure getWinner(final Field field) throws InvalidPointException {

        for (int i = 0; i < field.getSize(); i++) {
            final Figure figure = field.getFigure(new Point(i, 0));
            if (figure == null) {
                continue;
            }
            if (checkRow(field, figure, i))
                return figure;
        }

        for (int i = 0; i < field.getSize(); i++) {
            final Figure figure = field.getFigure(new Point(0, i));
            if (figure == null) {
                continue;
            }
            if (checkCol(field, figure, i))
                return figure;
        }

        Figure figure = field.getFigure(new Point(0, 0));
        if (figure == field.getFigure(new Point(1, 1)) &&
                figure == field.getFigure(new Point(2, 2)))
            return figure;

        figure = field.getFigure(new Point(2, 0));
        if (figure == field.getFigure(new Point(1, 1)) &&
                figure == field.getFigure(new Point(0, 2)))
            return figure;

        return null;
    }

    private boolean checkCol(final Field field,
                             final Figure figure,
                             final int i) throws InvalidPointException {

        for (int j = 1; j < field.getSize(); j++) {
            if (figure != field.getFigure(new Point(j, i))) {
                return false;
            }
        }

        return true;
    }

    private boolean checkRow(final Field field,
                             final Figure figure,
                             final int i) throws InvalidPointException {

        for (int j = 1; j < field.getSize(); j++) {
            if (figure != field.getFigure(new Point(i, j))) {
                return false;
            }
        }

        return true;
    }


}
