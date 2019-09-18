package com.formindev.xo;

import com.formindev.xo.controller.MoveController;
import com.formindev.xo.model.Field;
import com.formindev.xo.model.Figure;
import com.formindev.xo.model.Game;
import com.formindev.xo.model.Player;
import com.formindev.xo.model.exceptions.InvalidPointException;
import com.formindev.xo.view.ConsoleView;

public class XOConsoleGame {

    public static void main(String[] args) throws InvalidPointException {

        final String gameName = "X vs O";
        final Player player1 = new Player("Sasha", Figure.X);
        final Player player2 = new Player("Misha", Figure.O);
        final Field field = new Field();

        final Game game = new Game(gameName, new Player[]{player1, player2}, field);

        final ConsoleView consoleView = new ConsoleView();
        consoleView.show(game);

        while (consoleView.move(game)) {
            consoleView.show(game);
        }
    }
}
