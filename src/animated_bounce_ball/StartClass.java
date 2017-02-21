package animated_bounce_ball;

import javax.swing.*;
import java.awt.*;

/**
 * 19.02.2017
 */

public class StartClass {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new BounceFrame();
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
