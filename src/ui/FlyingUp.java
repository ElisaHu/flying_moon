package ui;

import model.Game;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.Timer;

/*
 * Represents the main window in which the game is played
 */
public class FlyingUp extends JFrame {

    private static final int INTERVAL = 20; //todo maybe change it?
    private Game game;
    private GamePanel gp;
    private ScoreCounter sc;

    // Constructs main window
    // effects: sets up window in which Space Invaders game will be played
    public FlyingUp() {
        super("Flying to the moon");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        game = new Game();
        gp = new GamePanel(game);
        sc = new ScoreCounter(game);
        add(gp);
        add(sc, BorderLayout.NORTH);
        // todo: mouse listener?
        //addKeyListener(new KeyHandler());
        pack();
        centreOnScreen();
        setVisible(true);
        addTimer();
    }

    // Set up timer
    // modifies: none
    // effects:  initializes a timer that updates game each
    //           INTERVAL milliseconds
    private void addTimer() {
        Timer t = new Timer(INTERVAL, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                game.update();
                gp.repaint();
                sc.update();
            }
        });

        t.start();
    }

    /*
     * A key handler to respond to key events
     */
    private class KeyHandler extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            game.keyPressed(e.getKeyCode());
        }
    }

    //todo ADD MOUSE MOVER? LISTENER

    // Centres frame on desktop
    // modifies: this
    // effects:  location of frame is set so frame is centred on desktop
    private void centreOnScreen() {
        Dimension scrn = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((scrn.width - getWidth()) / 2, (scrn.height - getHeight()) / 2);
    }

    public static void main(String[] args) {
        new FlyingUp();
    }
}
