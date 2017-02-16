package patterns.sierra_bates_patterns.decorator.starbuzz;

/**
 * Created by a on 14.02.17.
 */
public abstract class Beverage {
   String description = "Unknown beverage";

    public String getDescription(){
        return description;
    }

    public abstract double cost();
}
