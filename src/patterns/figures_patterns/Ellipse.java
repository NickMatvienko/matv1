package patterns.figures_patterns;

/**
 * Decorates Circle
 */
public class Ellipse extends FigureDecorator {


    public Ellipse(Figure figure) {
        super(figure);
    }

    @Override
    public void draw() {
        System.out.println("Ellipse:" + toString());
    }
}
