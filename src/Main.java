import processing.core.PApplet;

import java.util.ArrayList;

public class Main extends PApplet {
    private ArrayList<Ball> ballList = new ArrayList<>();

    public void settings() {
        size(800,800);
    }

    public void setup() {
        ballList.add( new Ball(100, 100) );
        ballList.add( new Ball(500, 500) );
        ballList.add( new Ball(100, 500) );
        ballList.add( new Ball(500, 100) );
    }

    public void draw() {
        for (Ball b:ballList) {
            b.draw(this);
        }
    }

    public static void main(String[] args) {
        PApplet.main("Main");
    }
}
