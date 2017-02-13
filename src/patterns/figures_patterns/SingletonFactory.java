package patterns.figures_patterns;

/**
 *   Produces instances "under the key" calling Builder for instantiation.
 */
public class SingletonFactory {

    private static SingletonFactory factory;

    private SingletonFactory() {
    }


    public static SingletonFactory getInstance() {
        if (factory == null) {
            synchronized (SingletonFactory.class) {
                if (factory == null) {

                    factory = new SingletonFactory();
                }
            }
        }

        return factory;
    }


    public Figure getFigure(FigureName shape) {
        switch (shape) {
            case CIRCLE:

                return new Circle.Builder().initRandom().build();

            case OVAL:

                return new Ellipse(new Circle.Builder().initRandom().build());

            case SQUARE:

                return new Square.Builder().initRandom().build();

            case RECTANGULAR:

                return new Rectangle(new Square.Builder().initRandom().build());
        }

        throw new IllegalArgumentException("There is no such figure");
    }


    enum FigureName {
        CIRCLE, OVAL, SQUARE, RECTANGULAR
    }
}
