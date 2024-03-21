package application.model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import application.util.PointUtils;

public class Field {

    private final Point position;
    private final List<Field> neighbors;

    private Pawn occupier;

    public Field(Point position) {
        this.position = position;
        neighbors = new ArrayList<>();
    }

    public void setOccupier(Pawn pawn) {
        occupier = pawn;
    }

    public boolean isOccupied() {
        return occupier != null;
    }

    public Pawn getOccupier() {
        return occupier;
    }

    public void addNeighbor(Field field) {
        if (neighbors.contains(field) || neighbors.size() == 4) return;
        if (!PointUtils.areAdjacent(position, field.getPosition())) return;
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
