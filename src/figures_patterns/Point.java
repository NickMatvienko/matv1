package figures_patterns;

/**
 * Final class for creating immutable objects - points.
 */
public final class Point {

    private final int x;
    private final int y;


    public Point(int x, int y) {
        this.x = x;
        this.y = y;

    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public final Point move(int x, int y) {
        return new Point(this.x + x, this.y + y);
    }


}
