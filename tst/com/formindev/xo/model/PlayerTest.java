package com.formindev.xo.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void getName() {
        final String inputNameValue = "Feodor";

        final Player player = new Player(inputNameValue, null);

        final String actualNameValue = player.getName();

        assertEquals(inputNameValue, actualNameValue);
    }

    @Test
    public void getFigure() {
        final Figure inputFigure = Figure.X;

        final Player player = new Player(null, inputFigure);

        final Figure actualFigure = player.getFigure();

        assertEquals(inputFigure, actualFigure);
    }
}