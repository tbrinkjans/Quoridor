package application.model;

import java.awt.Point;

public class Board {

    private final Field[][] fields;

    public Board() {
        fields = new Field[9][9];
        createBoard();
    }

    public Field[][] getFields() {
        return fields;
    }

    // create board
    private void createBoard() {
        createFields();
        addNeighbors();
    }

    private void createFields() {
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                Point position = new Point(x, y);
                fields[x][y] = new Field(position);
            }
        }
    }

    private void addNeighbors() {
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                Field field = fields[x][y];
                if (y < 8) field.addNeighbor(fields[x][y + 1]);
                if (x < 8) field.addNeighbor(fields[x + 1][y]);
                if (y > 0) field.addNeighbor(fields[x][y - 1]);
                if (x > 0) field.addNeighbor(fields[x - 1][y]);
            }
        }
    }

}
