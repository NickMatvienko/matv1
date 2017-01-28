package figures_patterns;

import java.awt.*;

/**
 * Main interface for all shapes
 */
public interface Figure {

    void draw();

    String toString();

    void movePoint(int x, int y);

    void resizeFigure(double scale);
}
