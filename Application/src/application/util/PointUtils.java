package application.util;

import java.awt.Point;

public class PointUtils {

    public static boolean areAdjacent(Point a, Point b) {
        int diffX = Math.abs(a.x - b.x);
        int diffY = Math.abs(a.y - b.y);

        return (diffX == 1 && diffY == 0) || (diffX == 0 && diffY == 1);
    }

}
