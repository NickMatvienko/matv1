package patterns.sierra_bates_patterns.factory.pizza;

/**
 * Created by a on 15.02.17.
 */
public abstract class PizzaStore {

        public Pizza orderPizza(String type) {
            Pizza pizza;
            pizza=createPizza(type);
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
            return pizza;
    }
   protected abstract Pizza createPizza(String type);
}
