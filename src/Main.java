import processing.core.PApplet;

import java.util.ArrayList;

public class Main extends PApplet {
    private ArrayList<Ball> ballList = new ArrayList<>();

    public void settings() {
        size(800,800);
    }

    public void setup() {
        ballList.add( new Ball(100, 100).timeToSwitch(20) );
        ballList.add( new Ball(500, 500).timeToSwitch(30) );
        ballList.add( new Ball(100, 500).timeToSwitch(40) );
        ballList.add( new Ball(500, 100).timeToSwitch(50) );
    }

    public void draw() {
        background(255);

        for (Ball b:ballList) {
            b.move();
            b.draw(this);
        }
    }

    public static void main(String[] args) {
        PApplet.main("Main");
    }
}
