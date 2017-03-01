package patterns.sierra_bates_patterns.iterator;

import java.util.Iterator;

/**
 * Created on 22.02.17.
 */
public interface Menu {
    Iterator<MenuItem> createIterator();
}
