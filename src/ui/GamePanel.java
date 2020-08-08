package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JPanel;

import model.Game;
import model.Stars;
import model.Character;

/*
 * The panel in which the game is rendered.
 */
public class GamePanel extends JPanel{
    private static final String OVER = "Game Over!";
    private static final String REPLAY = "R to replay";
    private Game game;

    // Constructs a game panel
    // effects:  sets size and background colour of panel,
    //           updates this with the game to be displayed
    public GamePanel(Game g) {
        setPreferredSize(new Dimension(Game.WIDTH, Game.HEIGHT));
        setBackground(Color.DARK_GRAY); //todo: good pictures about space, link with picture
        this.game = g;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawGame(g);

//        if (game.isOver()) {
//            gameOver(g);
//        }
    }

    // Draws the game
    // modifies: g
    // effects:  draws the game onto g
    private void drawGame(Graphics g) {
        drawCharacter(g);
        drawstars(g);
    }

    // Draw the character
    // modifies: g
    // effects:  draws the character onto g
    // TODO: CHANGE FILL RECT
    private void drawCharacter(Graphics g) {
        Character c = game.getCharacter();
        Color savedCol = g.getColor();
        g.setColor(Character.COLOR);
        g.fillRect(c.getX() - Character.SIZE_X / 2, c.getY() - Character.SIZE_Y / 2, Character.SIZE_X, Character.SIZE_Y);
        g.setColor(savedCol);
    }

    // Draw the stars
    // modifies: g
    // effects:  draws the stars onto g
    private void drawstars(Graphics g) {
        for(Stars next : game.getStars()) {
            drawEachStars(g, next);
        }
    }

    // Draw an invader
    // modifies: g
    // effects:  draws the invader i onto g
    // TODO: CHANGE FILL OVAL
    private void drawEachStars(Graphics g, Stars i) {
        Color savedCol = g.getColor();
        g.setColor(Stars.COLOR);
        g.fillOval(i.getX() - Stars.SIZE_X / 2, i.getY() - Stars.SIZE_Y / 2, Stars.SIZE_X, Stars.SIZE_Y);
        g.setColor(savedCol);
    }

}
