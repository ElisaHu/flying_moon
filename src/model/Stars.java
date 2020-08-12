package model;

import java.awt.Color;
import java.awt.Rectangle;

public class Stars {

    public static final int SIZE_X = 20;
    public static final int SIZE_Y = 20;

    public static final Color COLOR = new Color(241, 241, 27);

    public static final int DY = 1;

    private int x;
    private int y;

    // Constructs a STAR
    // effects: STAR is positioned at coordinates (x, y)
    public Stars(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void move() {
        y = y + DY;
    }

    // Determines if this star has collided with the character
    // modifies: none
    // effects:  returns true if this star has collided with character
    //           false otherwise
    public boolean collidedWith(Character m) {
        Rectangle starBound = new Rectangle(getX() - SIZE_X / 2, getY() - SIZE_Y / 2, SIZE_X, SIZE_Y);
        Rectangle characterBound = new Rectangle(m.getX() - Character.SIZE_X / 2, m.getY() - Character.SIZE_Y/ 2,
                Character.SIZE_X, Character.SIZE_Y);
        return starBound.intersects(characterBound);
    }


}
