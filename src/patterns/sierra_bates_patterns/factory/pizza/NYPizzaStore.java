package patterns.sierra_bates_patterns.factory.pizza;

/**
 * Created by a on 15.02.17.
 */
public class NYPizzaStore extends PizzaStore{
   protected Pizza createPizza(String item) {
switch(item) {
    case "cheese":
        return new NYStyleCheesePizza();
    case "veggie":
        return new NYStylePizzaVeggie();
    case "clam":
        return new NYStylePizzaClam();
    case "pepperoni":
        return new NYStylePizzaPepperoni();
    default:
        throw new IllegalArgumentException("sosi");
}
    }
}
