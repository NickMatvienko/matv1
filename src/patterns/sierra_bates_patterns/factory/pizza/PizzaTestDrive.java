package patterns.sierra_bates_patterns.factory.pizza;

/**
 * Created by a on 15.02.17.
 */
public class PizzaTestDrive {
    public static void main(String[] args) {
        PizzaStore pizzaStore = new NYPizzaStore();
        Pizza pizza = pizzaStore.orderPizza("cheese");
    }
}
