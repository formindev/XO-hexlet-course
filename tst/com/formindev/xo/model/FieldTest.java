package com.formindev.xo.model;

import com.formindev.xo.model.exceptions.AlreadyOccupiedException;
import com.formindev.xo.model.exceptions.InvalidPointException;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class FieldTest {

    @Test
    public void getSize() {
        final Field field = new Field();
        final int exceptedValue = 3;
        final int actualValue = field.getSize();

        assertEquals(exceptedValue, actualValue);

    }

    @Test
    public void getFigure() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(1, 0);
        final Figure inputFigure = Figure.O;
        field.setFigure(inputPoint, inputFigure);

        final Figure actualFigure = field.getFigure(inputPoint);

        assertEquals(inputFigure, actualFigure);
    }

    @Test
    public void getFigureWhenInputMinusXPoint() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(-1, 0);
        try {
             field.getFigure(inputPoint);
             fail();
        } catch (final InvalidPointException e) {}
    }

    @Test
    public void getFigureWhenInputMinusYPoint() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(2, -1);
        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {}
    }

    @Test
    public void getFigureWhenInputOutSizeXPoint() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(55, 0);
        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {}
    }

    @Test
    public void getFigureWhenInputOutSizeYPoint() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(2, 99);
        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {}
    }

    @Test
    public void getFigureWhenNullField() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(2, 0);
        final Figure actualFigure = field.getFigure(inputPoint);

        assertNull(actualFigure);
    }

    @Test
    public void setFigure() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(2, 2);
        final Figure inputFigure = Figure.X;
        field.setFigure(inputPoint, inputFigure);

        final Figure actualFigure = field.getFigure(inputPoint);

        assertEquals(inputFigure, actualFigure);
    }

    @Test
    public void setFigureWhenInputMinusXPoint() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(-2, 2);
        final Figure inputFigure = Figure.X;

        try {
            field.setFigure(inputPoint, inputFigure);
            fail();
        } catch (final InvalidPointException e) {}
    }

    @Test
    public void setFigureWhenInputMinusYPoint() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(0, -2);
        final Figure inputFigure = Figure.X;

        try {
            field.setFigure(inputPoint, inputFigure);
            fail();
        } catch (final InvalidPointException e) {}
    }

    @Test
    public void setFigureWhenInputOutSizeXPoint() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(55, 0);
        final Figure inputFigure = Figure.X;
        try {
            field.setFigure(inputPoint, inputFigure);
            fail();
        } catch (final InvalidPointException e) {}
    }

    @Test
    public void setFigureWhenInputOutSizeYPoint() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(2, 76);
        final Figure inputFigure = Figure.X;
        try {
            field.setFigure(inputPoint, inputFigure);
            fail();
        } catch (final InvalidPointException e) {}
    }

    @Test
    public void setFigureWhenInputOutSizeXYPoint() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(22, 76);
        final Figure inputFigure = Figure.X;
        try {
            field.setFigure(inputPoint, inputFigure);
            fail();
        } catch (final InvalidPointException e) {}
    }
}