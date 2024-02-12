package application.models;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Field {

    private final Point position;
    private final List<Field> neighbors;

    public Field(Point position) {
        this.position = position;
        this.neighbors = new ArrayList<>();
    }

    public void addNeighbor(Field field) {
        if (neighbors.contains(field)) {
            return;
        }
        neighbors.add(field);
    }

    public void removeNeighbor(Field field) {
        if (!neighbors.contains(field)) {
            return;
        }
        neighbors.remove(field);
    }

    public List<Field> getNeighbors() {
        return neighbors;
    }

    public Point getPosition() {
        return position;
    }

}
