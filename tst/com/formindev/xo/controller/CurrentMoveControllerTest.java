package com.formindev.xo.controller;

import com.formindev.xo.model.Field;
import com.formindev.xo.model.Figure;
import com.formindev.xo.model.exceptions.AlreadyOccupiedException;
import com.formindev.xo.model.exceptions.InvalidPointException;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class CurrentMoveControllerTest {

    @Test
    public void currentMoveWhenReturnO() throws AlreadyOccupiedException, InvalidPointException {
        final CurrentMoveController currentMoveController = new CurrentMoveController();

        final Figure expectedFigure = Figure.O;

        final Field inputField = new Field();

        inputField.setFigure(new Point(0, 0), Figure.X);
        inputField.setFigure(new Point(0, 2), Figure.O);
        inputField.setFigure(new Point(1, 0), Figure.X);

        final Figure actualFigure = currentMoveController.currentMove(inputField);

        assertEquals(expectedFigure, actualFigure);
    }

    @Test
    public void currentMoveWhenReturnX() throws AlreadyOccupiedException, InvalidPointException {
        final CurrentMoveController currentMoveController = new CurrentMoveController();

        final Figure expectedFigure = Figure.X;

        final Field inputField = new Field();

        inputField.setFigure(new Point(0, 0), Figure.X);
        inputField.setFigure(new Point(0, 2), Figure.O);
        inputField.setFigure(new Point(1, 0), Figure.X);
        inputField.setFigure(new Point(0, 1), Figure.O);

        final Figure actualFigure = currentMoveController.currentMove(inputField);

        assertEquals(expectedFigure, actualFigure);
    }

    @Test
    public void currentMoveWhenReturnNull() throws AlreadyOccupiedException, InvalidPointException {
        final CurrentMoveController currentMoveController = new CurrentMoveController();

        final Field inputField = new Field();

        inputField.setFigure(new Point(0, 0), Figure.X);
        inputField.setFigure(new Point(0, 1), Figure.O);
        inputField.setFigure(new Point(0, 2), Figure.X);
        inputField.setFigure(new Point(1, 0), Figure.O);
        inputField.setFigure(new Point(1, 1), Figure.X);
        inputField.setFigure(new Point(1, 2), Figure.O);
        inputField.setFigure(new Point(2, 0), Figure.X);
        inputField.setFigure(new Point(2, 1), Figure.X);
        inputField.setFigure(new Point(2, 2), Figure.O);

        final Figure actualFigure = currentMoveController.currentMove(inputField);

        assertNull(actualFigure);
    }

    @Test
    public void currentMoveWhenFieldNull() throws InvalidPointException {
        final CurrentMoveController currentMoveController = new CurrentMoveController();

        final Figure expectedFigure = Figure.X;

        final Field inputField = new Field();

        final Figure actualFigure = currentMoveController.currentMove(inputField);

        assertEquals(expectedFigure, actualFigure);
    }
}