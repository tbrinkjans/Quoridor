package application.model;
import java.awt.Point;
public class Wand {
private Point Koordinaten;
private Orientierung Orientierung;

private enum Orientierung{
    Horizontal,
    Vertikal
};
    public Wand(Point pKoordinaten, Orientierung pOrientierung){
        Koordinaten = pKoordinaten;
        Orientierung = pOrientierung;
    }

    public Point gibKoordinaten(){
        return Koordinaten;
    }

    public Orientierung gibOrientierung(){
        return Orientierung;
    }

    public void setzeKoordinaten(Point pKoordinaten){
        Koordinaten = pKoordinaten;
    }

    public void setzeOrientierung(Orientierung pOrientierung){
        Orientierung = pOrientierung;
    }

}