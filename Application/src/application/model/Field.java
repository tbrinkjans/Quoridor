package application.model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import application.util.PointHelper;

public class Field {

    private final Point position;
    private final List<Field> neighbors;

    public Field(Point position) {
        this.position = position;
        this.neighbors = new ArrayList<>();
    }

    public void addNeighbor(Field field) {
        if (neighbors.contains(field) || neighbors.size() == 4) return;
        if (!PointHelper.areAdjacent(position, field.getPosition())) return;
        neighbors.add(field);
    }

    public void removeNeighbor(Field field) {
        if (!neighbors.contains(field)) return;
        neighbors.remove(field);
    }

    public List<Field> getNeighbors() {
        return neighbors;
    }

    public Point getPosition() {
        return position;
    }

}
