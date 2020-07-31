package model;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static final int MAX_STAR = 10000;
    public static final Random RND = new Random();

    private List<Stars> stars;
    private Character c;
    private boolean isGameOver;
    private int numStarsCollected;

    // Constructs a flying moon Game
    // effects:  creates empty lists of missiles and invaders, centres tank on screen
    public Game() {
        stars = new ArrayList<Stars>();
//        setUp();
    }




}
