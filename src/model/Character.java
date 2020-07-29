package model;

import java.awt.*;

public class Character {
    public static final int SIZE_X = 15;
    public static final int SIZE_Y = 8;
    public static final int DX = 2;
    public static final int Y_POS = Game.HEIGHT - 40;
    public static final Color COLOR = new Color(250, 128, 20);

    private int direction;
    private int x;
    private int y;

    // Construct a person.
    // effects: places character at position (x, Y_POS) moving right.
    public Character(int x, int y) {
        this.x = x;
        this.y = y;
        direction = 1;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // Faces tank to the right
    // modifies: this
    // effects: tank is facing right
    public void faceRight() {
        direction = 1;
    }

    // Faces tank to the left
    // modifies: this
    // effects: tank is facing left
    public void faceLeft() {
        direction = -1;
    }

    // Updates the character on clock tick
    // modifies: this
    // effects:  tank is moved DX units in whatever direction it is facing and is
    //           constrained to remain within vertical boundaries of game
    public void move() {
        x = x + direction * DX;
        y = y + direction * DX;

        handleBoundary();
    }

    // Constrains tank so that it doesn't travel of sides of screen
    // modifies: this
    // effects: tank is constrained to remain within vertical boundaries of game
    private void handleBoundary() {
        if (x < 0)
            x = 0;
        else if (x > Game.WIDTH)
            x = Game.WIDTH;
    }


}
