package application.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import application.Application;
import application.component.BoardComponent;
import application.model.Board;

public class GameGUI extends JFrame {

    private final Board board;

    private BoardComponent boardComponent;

    public GameGUI(Board board) {
        super(Application.getTitle("Spielbrett"));
        this.board = board;
        createFrame();
        initComponents();
    }

    private void createFrame() {
        setSize(new Dimension(900, 600));
        setMinimumSize(new Dimension(400, 400));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setIconImage(new ImageIcon("res\\icon.png").getImage());
        getContentPane().setBackground(new Color(245, 243, 232));

        addKeyListener(new GameKeyListener());
    }

    private void initComponents() {
        boardComponent = new BoardComponent(board);
        getContentPane().add(boardComponent);
    }

    private class GameKeyListener extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent evt) {
            if (evt.getKeyCode() == KeyEvent.VK_F12)
                boardComponent.toggleDebug();
        }

    }

}
