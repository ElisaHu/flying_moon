package model;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game  {
//    extends Frame implements MouseMotionListener
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static final int MAX_STAR = 10000;
    public static final Random RND = new Random();
    private static final int STARS_GENERATING_PERIOD = 250;

    private List<Stars> stars;
    private Character c;
    private boolean isGameOver;
    private int numStarsCollected;

//    public void mouseDragged(MouseEvent e)
//    {
//    }
//
//    // invoked when the cursor is moved from
//    // one point to another within the component
//    public void mouseMoved(MouseEvent e)
//    {
//    }

    // Constructs a flying moon Game
    // effects:  creates empty lists of missiles and invaders, centres tank on screen
    public Game() {
        stars = new ArrayList<Stars>();
        initializing();
    }
    private void initializing() {
        stars.clear();
        c = new Character(WIDTH / 2, HEIGHT/2);
        isGameOver = false;
        numStarsCollected = 0;
    }

    public int getNumStarsCollected() {
        return numStarsCollected;
    }

    public List<Stars> getStars() {
        return stars;
    }

    public Character getCharacter() {return c;}

    public boolean isOver() {
        return isGameOver;
    }

    // Is game over? (Has the character did not reach the star and fall?)
    // modifies: this
    // effects:  if the character fall out of screen, game is marked as
    //           over and lists of stars cleared
    private void checkGameOver() {
        if (c.getY() > HEIGHT) {
            isGameOver = true;
        }
        if (isGameOver) {
            stars.clear();
        }
    }

    // updates the stars
    // modifies: this
    // effects: moves the stars
    private void moveStars() {
        for (Stars next : stars) {
            next.move();
        }
    }

    private void generateStars() {
        if (RND.nextInt(STARS_GENERATING_PERIOD) < 1) {
            Stars s = new Stars(RND.nextInt(Game.WIDTH), 0);
            stars.add(s);
        }
    }

    // Checks for collisions between the character and a star
    // modifies: this
    // effects:  removes any stars that has been reached by c
    //           and removes corresponding stars from play
    private void checkCollisions() {
        List<Stars> starsToRemove = new ArrayList<Stars>();

        for (Stars target : stars) {
            if (checkStarHit(target, c)) {
                starsToRemove.add(target);
            }
        }
        stars.removeAll(starsToRemove);
    }

    private boolean checkStarHit(Stars target, Character c) {
        if (target.collidedWith(c)) {
            numStarsCollected++;
            return true;
        }
        return false;
    }

    // Updates the game on clock tick
    // modifies: this
    // effects:  updates character and stars
    public void update() {
        moveStars();
        c.move();
        generateStars();
        checkCollisions();
        checkGameOver();
    }

    // Controls the character
    // modifies: this
    // effects: turns character in response to mouse code
    // TODO: CHECK IF THIS WORKS
    private void characterControl(MouseEvent e) {
        c.setX(e.getX());
    }

    // Responds to key press codes
    // modifies: this
    // effects:  turns tank, fires missiles and resets game in response to
    //           given key pressed code
    public void keyPressed(int keyCode) {
        if (keyCode == KeyEvent.VK_R && isGameOver)
            initializing();
        if (keyCode == KeyEvent.VK_X)
            System.exit(0);
    }

    public void mouseWork(MouseEvent e) {
        characterControl(e);
    }





}
