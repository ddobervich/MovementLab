import processing.core.PApplet;

public class Ball {
    private static final int GREEN = 0xff00ff00;

    private float x, y, width, height;
    private int color;

    public Ball(float x, float y) {
        this.x = x;
        this.y = y;
        this.width = 20;
        this.height = 20;
        this.color = GREEN;
    }

    public void setColor(int newColor) {
        this.color = newColor;
        System.out.println(color);
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
        // implement your fixed action pattern here
    }

    public void draw(PApplet window) {
        window.fill(this.color);
        window.ellipse(this.x, this.y, this.width, this.height);
    }

}
