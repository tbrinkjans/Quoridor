package application.exception;

import application.model.Field;
import application.model.Pawn;

public class IllegalMoveException extends RuntimeException {

    private final Pawn pawn;
    private final Field destination;

    public IllegalMoveException(Pawn pawn, Field destination) {
        this.pawn = pawn;
        this.destination = destination;
    }

    public Pawn getPawn() {
        return pawn;
    }

    public Field getDestination() {
        return destination;
    }

}
