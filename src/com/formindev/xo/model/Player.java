package com.formindev.xo.model;

import org.graalvm.compiler.virtual.phases.ea.PartialEscapeBlockState.Final;

public class Player {

    private final String name;

    private final Figure figure;

    public Player(final String name, final Figure figure) {
        this.name = name;
        this.figure = figure;
    }

    public String getName() {
        return name;
    }

    public Figure getFigure() {
        return figure;
    }    

}