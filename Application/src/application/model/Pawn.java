package application.model;

import java.awt.*;
import java.util.List;

public class Pawn {

    private final Color color;
    private Field location;
    public Pawn(Color color, Field location){
        this.color = color;
        this.location = location;
    }

    public Color getColor(){
        return color;
    }

    public boolean isValidMove(Field destination){

        return getValidMoves().contains(destination);
    }

    public List<Field> getValidMoves(){

        return location.getNeighbors().stream().filter(field -> field.getPawn() == null).toList();
    }

    public void moveTo(Field destination){
        if(isValidMove(destination)){
            location.setPawn(null);
            destination.setPawn(this);
            location = destination;
        }
    }

}
