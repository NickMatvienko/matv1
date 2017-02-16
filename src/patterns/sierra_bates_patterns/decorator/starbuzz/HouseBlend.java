package patterns.sierra_bates_patterns.decorator.starbuzz;

/**
 * Created by a on 14.02.17.
 */
public class HouseBlend extends Beverage {
    public HouseBlend () {
        description = "House Blend Coffee";
    }
    @Override
    public double cost() {
        return .89;
    }
}
