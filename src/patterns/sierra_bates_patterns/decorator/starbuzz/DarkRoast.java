package patterns.sierra_bates_patterns.decorator.starbuzz;

/**
 * Created by a on 14.02.17.
 */
public class DarkRoast extends Beverage {
    public DarkRoast() {
      description="Dark Roast";
    }

    @Override
    public double cost(){
        return .99;
    }
}
