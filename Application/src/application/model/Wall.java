package application.model;
import java.awt.Point;
public class Wall {
private final Point Coordinates;
private final Orientation Orientation;

private enum Orientation{
    Horizontal,
    Vertical
}
    public Wall(Point pCoordinates, Orientation pOrientation){
        Coordinates = pCoordinates;
        Orientation = pOrientation;
    }

    public Point getCoordinates(){
        return Coordinates;
    }

    public Orientation getOrientation(){
        return Orientation;
    }

}