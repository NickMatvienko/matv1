package factory;

/**
 * Created by vertex0007 on 21.01.2017.
 */
public class B extends A implements  OopInterface{

    private int id;
    private String name;

    private B() {
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public static class Builder {
        B instance;

        public Builder() {
            instance = new B();
        }

        Builder setId(int id) {
            instance.id = id;
            return this;
        }

        Builder setName(String name) {
            instance.name = name;
            return this;
        }

        public B getInstance() {
            return instance;
        }
    }
}