package application.model;

import java.awt.Point;

import application.enumeration.Orientation;

public class Wall {

    private final Point position;
    private final Orientation orientation;

    public Wall(Point position, Orientation orientation) {
        this.position = position;
        this.orientation = orientation;
    }

    public Point getPosition() {
        return position;
    }

    public Orientation getOrientation() {
        return orientation;
    }

}
