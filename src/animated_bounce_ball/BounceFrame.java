package animated_bounce_ball;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * 19.02.2017
 */

public class BounceFrame extends JFrame {

    private BallComponent comp;
    public static final int DEFAULT_WIDTH = 450;
    public static final int DEFAULT_HIGHT = 350;

    public BounceFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HIGHT);
        setTitle("Bounce");
        comp = new BallComponent();
        JPanel buttonPanel = new JPanel();
        addButton(buttonPanel, "Start", e -> addBall());
        addButton(buttonPanel, "Close", e -> System.exit(0));
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void addButton(Container c, String title, ActionListener listener) {
        JButton button = new JButton(title);
        c.add(button);
        button.addActionListener(listener);
    }

    public void addBall() {
        Ball b = new Ball();
        comp.add(b);
        Runnable r = new BallRunnable(b,comp);
        Thread t = new Thread(r);
        t.start();
    }
}
