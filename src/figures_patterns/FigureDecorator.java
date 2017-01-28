package figures_patterns;

/**
 * Decorator-pattern realisation. Made for code reduce,
 * used by Ellipse and Rectangle classes
 */
public class FigureDecorator implements Figure {

    protected Figure figure;

    public FigureDecorator(Figure figure) {
        this.figure = figure;
    }

    @Override
    public void draw() {
        this.figure.draw();
    }

    @Override
    public String toString() {
        return this.figure.toString();
    }

    @Override
    public void movePoint(int x, int y) {
        this.figure.movePoint(x, y);
    }


    @Override
    public void resizeFigure(double scale) {
        this.figure.resizeFigure(scale);
    }
}
