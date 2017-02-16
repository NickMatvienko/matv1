package patterns.sierra_bates_patterns.singleton;

/**
 * Created by a on 16.02.17.
 */
public class ChocolateBoiler {
    private boolean empty;
    private  boolean boiled;
    private static ChocolateBoiler instance;

    private ChocolateBoiler() {
        empty = true;
        boiled = false;
    }

    public static ChocolateBoiler getInstance() {
        if(instance==null){
            return new ChocolateBoiler();
        }
        return instance;
    }

    public void fill() {
        if(isEmpty()){
            empty=false;
            boiled =false;
        }
    }



    public void boil() {
        if(!isEmpty()&&!isBoiled()) {
            boiled =true;
        }
    }

    public void drain() {
        if (!isEmpty() && isBoiled()) {
            //drain the boiled milk and chocolate
            empty = true;
        }
    }

    public boolean isEmpty() {
        return empty;
    }

    public boolean isBoiled() {
        return boiled;
    }


}
