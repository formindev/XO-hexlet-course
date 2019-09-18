package com.formindev.xo.controller;

import com.formindev.xo.model.Field;
import com.formindev.xo.model.Figure;
import com.formindev.xo.model.exceptions.AlreadyOccupiedException;
import com.formindev.xo.model.exceptions.InvalidPointException;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class MoveControllerTest {

    @Test
    public void applyFigure() throws AlreadyOccupiedException, InvalidPointException {
        final Field inputField = new Field();

        final Figure inputFigure = Figure.O;

        final Point inputPoint = new Point(0, 1);

        final MoveController moveController = new MoveController();

        moveController.applyFigure(inputPoint, inputField, inputFigure);

        final Figure actualFigure = inputField.getFigure(inputPoint);

        assertEquals(inputFigure, actualFigure);
    }

    @Test
    public void applyFigureWhenAlreadyOccupied() throws AlreadyOccupiedException, InvalidPointException {
        final Field inputField = new Field();

        final Figure inputFigure = Figure.X;

        final Point inputPoint = new Point(2, 1);

        inputField.setFigure(inputPoint, inputFigure);

        final MoveController moveController = new MoveController();

        try {
            moveController.applyFigure(inputPoint, inputField, inputFigure);
            fail();
        } catch (AlreadyOccupiedException e) {}
    }

}