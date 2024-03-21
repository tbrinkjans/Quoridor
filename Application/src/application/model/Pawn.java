package application.model;

import java.awt.Color;
import java.util.List;
import java.util.stream.Collectors;

import application.exception.IllegalMoveException;

public class Pawn {

    private final Color color;

    private Field field;

    public Pawn(Color color, Field field) {
        this.color = color;

        this.field = field;
        this.field.setOccupier(this);
    }

    public void moveTo(Field destination) {
        if (!isValidMove(destination)) {
            throw new IllegalMoveException(this, destination);
        } else {
            field.setOccupier(null);
            destination.setOccupier(this);
            field = destination;
        }
    }

    public boolean isValidMove(Field destination) {
        return getValidMoves().contains(destination);
    }

    public boolean hasValidMove() {
        return !getValidMoves().isEmpty();
    }

    public List<Field> getValidMoves() {
        return field.getNeighbors().stream()
            .filter(neighbor -> !neighbor.isOccupied())
            .collect(Collectors.toList());
    }

    public Field getField() {
        return field;
    }

    public Color getColor() {
        return color;
    }

}
