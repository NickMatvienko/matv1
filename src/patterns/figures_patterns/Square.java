package patterns.figures_patterns;

import java.util.Random;

/**
 * Created by a on 25.01.17.
 */
public class Square implements Figure {

    private double side;


    public void setSide(double side) {
        this.side = side;
    }


    public void setPoint(Point point) {
        this.point = point;
    }

    private Point point;

    private Square() {
    }


    @Override
    public String toString() {
        return "{" +
                "side=" + side +
                ", point=" + point +
                '}';
    }

    @Override
    public void draw() {
        System.out.println("Square:" + toString());
    }

    @Override
    public void movePoint(int x, int y) {
        this.point = point.move(x, y);

    }

    @Override
    public void resizeFigure(double scale) {
        side *= scale;
    }

    /**
     *  Builder-pattern realisation
     */
    public static class Builder {


        Square square;

        public Builder() {
            square = new Square();
        }


        Builder initRandom() {
            Random r = new Random();
            square.setSide(r.nextDouble() * 100);
            square.setPoint(new Point(r.nextInt(100), r.nextInt(100)));
            return this;
        }


        public Square build() {
            return square;
        }

    }
}
