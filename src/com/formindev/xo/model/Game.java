package com.formindev.xo.model;

import java.util.Iterator;

public class Game implements Iterable<Player> {

    private final String name;

    private final Player[] players;

    private final Field field;

    public Game(String name, Player[] players, Field field) {
        this.name = name;
        this.players = players;
        this.field = field;
    }

    public String getName() {
        return name;
    }

    public Player[] getPlayers() {
        return players;
    }

    public Field getField() {
        return field;
    }

    @Override
    public Iterator<Player> iterator() {
        return new PlayerIterator();
    }

    private class PlayerIterator implements Iterator<Player> {

        private int index = 0;

        @Override
        public boolean hasNext() {
            return Game.this.players.length > index;
        }

        @Override
        public Player next() {
            return Game.this.players[index++];
        }
    }
}
