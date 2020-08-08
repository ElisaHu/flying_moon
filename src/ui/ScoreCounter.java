package ui;

import model.Game;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * Represents the panel in which the scoreboard is displayed.
 */
public class ScoreCounter extends JPanel {
    private static final String STARS_TXT = "Stars collected: ";

    private static final int LBL_WIDTH = 200;
    private static final int LBL_HEIGHT = 30;
    private Game game;
    private JLabel starsLbl;

    // Constructs a score panel
    // effects: sets the background colour and draws the initial labels;
    //          updates this with the game whose score is to be displayed
    public ScoreCounter(Game g) {
        game = g;
        setBackground(new Color(10, 180, 180));
        starsLbl = new JLabel(STARS_TXT + game.getNumStarsCollected());
        starsLbl.setPreferredSize(new Dimension(LBL_WIDTH, LBL_HEIGHT));
        add(starsLbl);
    }

    // Updates the score panel
    // modifies: this
    // effects:  updates number of stars collected to reflect current state of game
    public void update() {
        starsLbl.setText(STARS_TXT + game.getNumStarsCollected());
        repaint();   // redraw the label to the panel
    }
}
