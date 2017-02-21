package animated_bounce_ball;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * 19.02.2017
 */

public class BallComponent extends JPanel {
    private ArrayList<Ball> balls = new ArrayList<>();

    public void add(Ball b) {
        balls.add(b);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (Ball b : balls) {
            g2.fill(b.getShape());
        }
    }

}
