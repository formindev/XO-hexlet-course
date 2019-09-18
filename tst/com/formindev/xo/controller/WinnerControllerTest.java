package com.formindev.xo.controller;

import com.formindev.xo.model.Field;
import com.formindev.xo.model.Figure;
import com.formindev.xo.model.exceptions.AlreadyOccupiedException;
import com.formindev.xo.model.exceptions.InvalidPointException;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class WinnerControllerTest {

    @Test
    public void getWinnerWhenHasRowWinner() throws AlreadyOccupiedException, InvalidPointException {
        final Field inputField = new Field();

        final WinnerController winnerController = new WinnerController();

        final Figure expectedFigure = Figure.X;

        inputField.setFigure(new Point(0, 0), Figure.X);
        inputField.setFigure(new Point(0, 1), Figure.X);
        inputField.setFigure(new Point(0, 2), Figure.X);
        inputField.setFigure(new Point(1, 2), Figure.O);
        inputField.setFigure(new Point(1, 0), Figure.O);

        final Figure actualFigure = winnerController.getWinner(inputField);

        assertEquals(expectedFigure, actualFigure);
    }

    @Test
    public void getWinnerWhenHasColWinner() throws AlreadyOccupiedException, InvalidPointException {
        final Field inputField = new Field();

        final WinnerController winnerController = new WinnerController();

        final Figure expectedFigure = Figure.X;

        inputField.setFigure(new Point(0, 0), Figure.X);
        inputField.setFigure(new Point(1, 0), Figure.X);
        inputField.setFigure(new Point(2, 0), Figure.X);
        inputField.setFigure(new Point(1, 2), Figure.O);
        inputField.setFigure(new Point(1, 1), Figure.O);

        final Figure actualFigure = winnerController.getWinner(inputField);

        assertEquals(expectedFigure, actualFigure);
    }

    @Test
    public void getWinnerWhenHasRightDiagonalWinner() throws AlreadyOccupiedException, InvalidPointException {
        final Field inputField = new Field();

        final WinnerController winnerController = new WinnerController();

        final Figure expectedFigure = Figure.X;

        inputField.setFigure(new Point(0, 0), Figure.X);
        inputField.setFigure(new Point(1, 1), Figure.X);
        inputField.setFigure(new Point(2, 2), Figure.X);
        inputField.setFigure(new Point(1, 2), Figure.O);
        inputField.setFigure(new Point(2, 1), Figure.O);
        inputField.setFigure(new Point(2, 0), Figure.O);

        final Figure actualFigure = winnerController.getWinner(inputField);

        assertEquals(expectedFigure, actualFigure);
    }

    @Test
    public void getWinnerWhenHasLeftDiagonalWinner() throws AlreadyOccupiedException, InvalidPointException {
        final Field inputField = new Field();

        final WinnerController winnerController = new WinnerController();

        final Figure expectedFigure = Figure.X;

        inputField.setFigure(new Point(0, 2), Figure.X);
        inputField.setFigure(new Point(1, 1), Figure.X);
        inputField.setFigure(new Point(2, 0), Figure.X);
        inputField.setFigure(new Point(1, 2), Figure.O);
        inputField.setFigure(new Point(2, 1), Figure.O);
        inputField.setFigure(new Point(2, 2), Figure.O);

        final Figure actualFigure = winnerController.getWinner(inputField);

        assertEquals(expectedFigure, actualFigure);
    }

    @Test
    public void getWinnerWhenNolWinner() throws AlreadyOccupiedException, InvalidPointException {
        final Field inputField = new Field();

        final WinnerController winnerController = new WinnerController();

        inputField.setFigure(new Point(0, 2), Figure.X);
        inputField.setFigure(new Point(0, 1), Figure.X);
        inputField.setFigure(new Point(1, 2), Figure.O);
        inputField.setFigure(new Point(2, 1), Figure.O);
        inputField.setFigure(new Point(2, 2), Figure.O);

        final Figure actualFigure = winnerController.getWinner(inputField);

        assertNull(actualFigure);
    }

}