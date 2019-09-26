package com.formindev.xo.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void getName() {

        final String inputName = "XO";

        final Game game = new Game(inputName, null, null);

        final String actualName = game.getName();

        assertEquals(inputName, actualName);

    }

    @Test
    public void getPlayers() {

        final Player[] inputPlayers = new Player[] {new Player("Greg", Figure.O), new Player("Bob", Figure.X)};

        final Game game = new Game(null, inputPlayers, null);

        final Player[] actualPlayers = game.getPlayers();

        assertArrayEquals(inputPlayers, actualPlayers);

    }

    @Test
    public void getField() {

        final Field inputField = new Field();

        final Game game = new Game(null, null, inputField);

        final Field actualField = game.getField();

        assertEquals(inputField, actualField);
    }

    @Test
    public void checkPlayerIterator() {

        final Player[] inputPlayers = new Player[] {new Player("Greg", Figure.O), new Player("Bob", Figure.X)};

        final Game game = new Game(null, inputPlayers, null);

        int i = 0;

        for (Player player : game) {

            final String actualPlayer = player.getName();

            final String expectedPlayer = inputPlayers[i].getName();

            assertEquals(expectedPlayer, actualPlayer);

            i++;
        }
    }
}