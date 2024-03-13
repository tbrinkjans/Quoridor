package application;

import java.awt.EventQueue;

import application.gui.GameGUI;
import application.model.Board;

public class Application {

    public static final String NAME = "Quoridor";
    public static final String VERSION = "0.1";

    public static String getTitle(String title) {
        return NAME + ": " + title + " (v." + VERSION + ")";
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Board board = new Board();
            new GameGUI(board).setVisible(true);
        });
    }

}
