package com.formindev.xo.controller;

import com.formindev.xo.model.Field;
import com.formindev.xo.model.Figure;
import com.formindev.xo.model.exceptions.AlreadyOccupiedException;
import com.formindev.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class MoveController {

    public void applyFigure(final Point point,
                     final Field field,
                     final Figure figure) throws AlreadyOccupiedException,
                                                        InvalidPointException {

        if (field.getFigure(point) != null) {
           throw new AlreadyOccupiedException();
       }

        field.setFigure(point, figure);
    }

}
