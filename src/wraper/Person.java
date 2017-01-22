package wraper;

/**
 * Created by vertex0007 on 21.01.2017.
 */
public class Person {


        private int id;
        private String name;

        private Person() {
        }

        public int getId() {
            return id;
        }


        public String getName() {
            return name;
        }


        public static class Builder {
            Person instance;

            public Builder() {
                instance = new Person();
            }

            Builder setId(int id) {
                instance.id = id;
                return this;
            }

            Builder setName(String name) {
                instance.name = name;
                return this;
            }

            public Person getInstance() {
                return instance;
            }
        }
    }

