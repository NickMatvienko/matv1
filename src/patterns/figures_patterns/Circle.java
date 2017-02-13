package patterns.figures_patterns;

import java.util.Random;


public class Circle implements Figure {

    private double radius;


    public void setRadius(double radius) {
        this.radius = radius;
    }


    public void setPoint(Point point) {
        this.point = point;
    }

    private Point point;

    private Circle() {
    }


    @Override
    public String toString() {
        return "{" +
                "radius=" + radius +
                ", point=" + point.toString() +
                '}';
    }

    @Override
    public void draw() {
        System.out.println("Circle" + toString());
    }

    @Override
    public void movePoint(int x, int y) {
        this.point = point.move(x, y);

    }

    @Override
    public void resizeFigure(double scale) {
        radius *= scale;
    }

    /**
     *  Builder-pattern realisation
     */
    public static class Builder {


        Circle circle;

        public Builder() {
            circle = new Circle();
        }


        Builder initRandom() {
            Random r = new Random();
            circle.setRadius(r.nextDouble() * 100);
            circle.setPoint(new Point(r.nextInt(100), r.nextInt(100)));
            return this;
        }


        public Circle build() {
            return circle;
        }

    }
}
