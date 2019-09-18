package com.formindev.xo.view;

import com.formindev.xo.controller.CurrentMoveController;
import com.formindev.xo.controller.MoveController;
import com.formindev.xo.controller.WinnerController;
import com.formindev.xo.model.Field;
import com.formindev.xo.model.Figure;
import com.formindev.xo.model.Game;
import com.formindev.xo.model.exceptions.AlreadyOccupiedException;
import com.formindev.xo.model.exceptions.InvalidPointException;

import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleView {

    private final CurrentMoveController currentMoveController = new CurrentMoveController();

    private final WinnerController winnerController = new WinnerController();

    private final MoveController moveController = new MoveController();

    public void show(final Game game) throws InvalidPointException {
        final Field field = game.getField();
        final int fieldSize = field.getSize();
        for (int i = 0; i < fieldSize; i++) {
             printRow(field, i);
             System.out.print("\n");
             if (i != 2)
                System.out.print("-----\n");
        }
    }

    public boolean move(final Game game) throws InvalidPointException {
        final Field field = game.getField();
        final Figure winner = winnerController.getWinner(field);

        if (winner != null) {
            System.out.format("Winner is %s\n", winner);
            return false;
        }

        final Figure currentFigure = currentMoveController.currentMove(field);

        if (currentFigure == null) {
            System.out.println("No winner but no and looser");
            return false;
        }

        System.out.format("Please input coordinates for %s\n", currentFigure);
        final Point point = askPoint();
        try {
            moveController.applyFigure(point, field, currentFigure);
        } catch (InvalidPointException | AlreadyOccupiedException e) {
            System.out.println("Invalid coordinates");
            return true;
        }

        return true;
    }

    private Point askPoint() {
        return new Point(askCoordinate("X"), askCoordinate("Y"));
    }

    private int askCoordinate(final String coordinate) {
        System.out.format("Please input %s coordinate: ", coordinate);
        final Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextInt();
        } catch (final InputMismatchException e) {
            System.out.println("Not a coordinate");
            return askCoordinate(coordinate);
        }

    }

    private void printRow(final Field field, final int row) throws InvalidPointException {
        for (int j = 0; j < field.getSize(); j++) {
            final Figure figure = field.getFigure(new Point(row, j));
            if (figure == Figure.O)
                System.out.print("O");
            if (figure == Figure.X)
                System.out.print("X");
            if (figure == null)
                System.out.print(" ");

//
//            switch (figure) {
//                case O:
//                    System.out.print("O");
//                    break;
//                case X:
//                    System.out.print("X");
//                    break;
//                case null:
//                    System.out.print(" ");
//            }
            if (j != 2)
                System.out.print("|");
        }
    }
}
