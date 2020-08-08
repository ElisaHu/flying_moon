package ui;

import model.Game;

import javax.swing.*;

public class ScoreCounter extends JPanel {
    private static final String STARS_TXT = "Stars collected: ";

    private static final int LBL_WIDTH = 200;
    private static final int LBL_HEIGHT = 30;
    private Game game;
    private JLabel invadersLbl;
    private JLabel missilesLbl;
}
