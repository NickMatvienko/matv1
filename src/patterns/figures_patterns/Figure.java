package patterns.figures_patterns;

/**
 * Main interface for all shapes
 */
public interface Figure {

    void draw();

    String toString();

    void movePoint(int x, int y);

    void resizeFigure(double scale);
}
