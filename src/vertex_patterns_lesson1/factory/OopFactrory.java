package vertex_patterns_lesson1.factory;



/**
 * Created by vertex0007 on 21.01.2017.
 */
public class OopFactrory {
    public  static OopInterface getOopClass(String name) {
        if ("B".equalsIgnoreCase(name)) {
            return new B.Builder().getInstance() ;

        }
        else {
            if ("A".equalsIgnoreCase(name)) {
                return  new A();
            }
            else  {
                throw new IllegalArgumentException("Wrong");                }
            }
        }

}

