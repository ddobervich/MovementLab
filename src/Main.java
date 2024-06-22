import processing.core.PApplet;

import java.util.ArrayList;

public class Main extends PApplet {
    private ArrayList<Ball> ballList = new ArrayList<>();

    public void settings() {
        size(800, 800);
    }

    public void setup() {
        Movement[] pattern1 = new Movement[]{new Movement(1, 0), new Movement(-1, 0)};
        Movement[] pattern2 = new Movement[]{new Movement(0, -1), new Movement(0, 1)};
        Movement[] pattern3 = new Movement[]{new Movement(-1, 0), new Movement(0, -1),
                new Movement(0, 1), new Movement(1, 0)};
        Movement[] pattern4 = new Movement[] {new Movement(1, 1), new Movement(-1, -1)};

        ballList.add(new Ball(100, 100).setPattern(pattern1));
        ballList.add(new Ball(500, 500).setPattern(pattern2));
        ballList.add(new Ball(100, 500).setPattern(pattern3));
        ballList.add(new Ball(500, 100).setPattern(pattern4).timeToSwitch(50));
    }

    public void draw() {
        background(255);

        for (Ball b : ballList) {
            b.move();
            b.draw(this);
        }
    }

    public static void main(String[] args) {
        PApplet.main("Main");
    }
}
