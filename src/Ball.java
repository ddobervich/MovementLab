import processing.core.PApplet;

public class Ball {
    private static final int GREEN = 0xff00ff00;
    private static final Movement RIGHT = new Movement(1, 0);
    private static final Movement UP = new Movement(0, -1);
    private static final Movement DOWN = new Movement(0, 1);
    private static final Movement LEFT = new Movement(-1, 0);

    private float x, y, width, height;
    private int color;
    private Movement[] actionPattern = {RIGHT, DOWN, RIGHT, UP, LEFT, UP, LEFT, DOWN};
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

    public Ball setPattern(Movement[] pattern) {
        this.actionPattern = pattern;
        return this;
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
        Movement currentDirection = actionPattern[currentAction];
        moveInDirection(currentDirection.getDx(), currentDirection.getDy());

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
