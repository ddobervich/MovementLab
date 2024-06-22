import processing.core.PApplet;

import java.util.Currency;

public class Ball {
    private static final int GREEN = 0xff00ff00;
    private static final int RIGHT = 0;
    private static final int UP = 1;
    private static final int DOWN = 2;
    private static final int LEFT = 3;

    private float x, y, width, height;
    private int color;
    private int[] actionPattern = {RIGHT, DOWN, LEFT, UP};
    private int currentAction = 0;
    private int timeToSwitch = 30;
    private int timer = 0;

    public Ball(float x, float y) {
        this.x = x;
        this.y = y;
        this.width = 20;
        this.height = 20;
        this.color = GREEN;
    }

    public Ball timeToSwitch(int newTime){
        this.timeToSwitch = newTime;
        return this;
    }

    public Ball color(int newColor) {
        this.color = newColor;
        return this;
    }

    public void setPosition(float newX, float newY) {
        this.x = newX;
        this.y = newY;
    }

    public void moveInDirection(float dx, float dy) {
        x += dx;
        y += dy;
    }

    public void move() {
        int currentDirection = actionPattern[currentAction];
        if (currentDirection == UP) {
            moveInDirection(0, -1);
        } else if (currentDirection == DOWN) {
            moveInDirection(0, 1);
        } else if (currentDirection == RIGHT) {
            moveInDirection(1, 0);
        } else if (currentDirection == LEFT) {
            moveInDirection(-1, 0);
        }

        timer--;
        if (timer <= 0) {
            timer = timeToSwitch;
            currentAction++;
            if (currentAction >= actionPattern.length) {
                currentAction = 0;
            }
        }
    }

    public void draw(PApplet window) {
        window.fill(this.color);
        window.ellipse(this.x, this.y, this.width, this.height);
    }

}
