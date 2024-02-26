package application.component;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;

import javax.swing.JComponent;

import application.model.Board;
import application.model.Field;

public class BoardComponent extends JComponent {

    private final Board board;

    public BoardComponent(Board board) {
        this.board = board;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = getGraphics2D(g);

        int width = getWidth();
        int height = getHeight();

        int boardMargin = (int) (Math.min(width, height) * 0.05);
        int boardSize = Math.min(width, height) - 2 * boardMargin;

        g2D.translate(
            (width > height ? (width - height) / 2 : 0) + boardMargin,
            (height > width ? (height - width) / 2 : 0) + boardMargin);

        drawBoard(boardSize, g2D);
    }

    private void drawBoard(int boardSize, Graphics2D g2D) {
        int boardArc = (int) (boardSize * 0.1);

        g2D.setColor(new Color(176, 160, 146));
        g2D.fillRoundRect(0, 0, boardSize, boardSize, boardArc, boardArc);

        int boardPadding = (int) (boardSize * 0.05);
        int boardSizeInner = boardSize - 2 * boardPadding;

        double wallSize = boardSizeInner * 0.025;
        double fieldSize = (boardSizeInner - 8 * wallSize) / 9;

        drawLabels(boardPadding, fieldSize, wallSize, g2D);
        g2D.translate(boardPadding, boardPadding);

        drawFields(fieldSize, wallSize, g2D);
    }

    private void drawLabels(int boardPadding, double fieldSize, double wallSize, Graphics2D g2D) {
        int fontSize = (int) (boardPadding * 0.5);

        Font font = new Font("Arial", Font.PLAIN, fontSize);
        g2D.setFont(font);

        FontMetrics fontMetrics = g2D.getFontMetrics();
        FontRenderContext fontRenderContext = new FontRenderContext(font.getTransform(), true, true);

        int lineHeight = font.createGlyphVector(fontRenderContext, "ABCDEFGHI")
            .getPixelBounds(fontRenderContext, 0, 0).height;

        g2D.setColor(new Color(83, 75, 68));
        for (int x = 0; x < 9; x++) {
            String label = String.valueOf((char) ('A' + x));
            int width = fontMetrics.stringWidth(label);

            int xBoard = (int) (boardPadding + (fieldSize + wallSize) * x + (fieldSize / 2) - (width / 2));
            int yBoardTop = (int) ((boardPadding / 2) + (lineHeight / 2));
            int yBoardBottom = (int) (boardPadding + fieldSize * 9 + wallSize * 8 + yBoardTop);

            g2D.drawString(label, xBoard, yBoardTop);
            g2D.drawString(label, xBoard, yBoardBottom);
        }

        for (int y = 0; y < 9; y++) {
            String label = String.valueOf((char) ('1' + y));
            int width = fontMetrics.stringWidth(label);
            int height = font.createGlyphVector(fontRenderContext, label)
                .getPixelBounds(fontRenderContext, 0, 0).height;

            int yBoard = (int) (boardPadding + (fieldSize + wallSize) * (8 - y) + (fieldSize / 2) + (height / 2));
            int xBoardLeft = (int) ((boardPadding / 2) - (width / 2));
            int xBoardRight = (int) (boardPadding + fieldSize * 9 + wallSize * 8 + xBoardLeft);

            g2D.drawString(label, xBoardLeft, yBoard);
            g2D.drawString(label, xBoardRight, yBoard);
        }
    }

    private void drawFields(double fieldSize, double wallSize, Graphics2D g2D) {
        int fieldArc = (int) (fieldSize * 0.2);

        g2D.setColor(new Color(161, 142, 128));
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                int xBoard = (int) ((fieldSize + wallSize) * x);
                int yBoard = (int) ((fieldSize + wallSize) * (8 - y));
                g2D.fillRoundRect(xBoard, yBoard, (int) fieldSize, (int) fieldSize, fieldArc, fieldArc);
            }
        }
    }

    private Graphics2D getGraphics2D(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        return g2D;
    }

}
