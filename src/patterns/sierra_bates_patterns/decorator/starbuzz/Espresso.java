package patterns.sierra_bates_patterns.decorator.starbuzz;

/**
 * Created by a on 14.02.17.
 */
public class Espresso extends Beverage {

public Espresso() {
    description = "Espresso";
}

    @Override
    public double cost() {
        return 1.99;
    }
}
