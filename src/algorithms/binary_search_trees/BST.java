package algorithms.binary_search_trees;


import java.util.ArrayDeque;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Scanner;

public class BST<Key extends Comparable<Key>, Value> {
    private Node root; // root of BST

    private class Node {
        private Key key;  // sorted by key
        private Value val; // associated data
        private Node left, right; // left and right subtrees
        private int size; // number of nodes in subtree

        public Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

    /**
     * Initializes an empty symbol table
     */
    public BST() {
    }


    /**
     * Returns if this symbol table is empty.
     *
     * @return {@code true} if this symbol table is empty;
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns the number of key-value pairs in this symbol table.
     */
    public int size() {
        return size(root);
    }

    //return number of key-value pairs in BST rooted at x
    private int size(Node x) {
        if (x == null) return 0;
        else return x.size;
    }

    /**
     * Does this symbol table contains the given key?
     */
    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument is null");
        return get(key) != null;
    }

    /**
     * Returns the value associated with the given key.
     */
    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (key == null) throw new IllegalArgumentException("called get() with a nul key");
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else return x.val;

    }

    /**
     * Inserts the specified key-value pair into the symbol table, overwriting the old
     * value with the new value if the symbol table already contains the specified key.
     * Deletes the specified key (and its associated value) from this symbol table
     * if the specified value is {@code null}.
     */
    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("called put() with a nul key");
        if (val == null) {
            delete(key);
            return;
        }
        root = put(root, key, val);
        assert check();
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else x.val = val;
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    /**
     * Removes the smallest key and associated value from the symbol table
     */
    public void deleteMin() {
        if (isEmpty()) throw new NoSuchElementException("symbol table underflow ");
        root = deleteMin(root);
        assert check();
    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    /**
     * Removes the largest key and associated value from the symbol table
     */
    public void deleteMax() {
        if (isEmpty()) throw new NoSuchElementException("Symbol table underflow");
        root = deleteMax(root);
        assert check();
    }

    private Node deleteMax(Node x) {
        if (x.right == null) return x.left;
        x.right = deleteMax(x.right);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    /**
     * Removes the specified key and its associated value from this symbol table
     */
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("delete() with a null key");

        root = delete(root, key);
        assert check();
    }

    private Node delete(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = delete(x.left, key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else {
            if (x.right == null) return x.left;
            if (x.left == null) return x.right;
            Node t = x;

            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    /**
     * Returns the smallest key in the symbol table.
     */
    public Key min() {
        if (isEmpty()) throw new IllegalArgumentException("called min() with empty s.t.");
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left == null) return x;
        else return min(x.left);

    }

    public Key max() {
        if (isEmpty()) throw new NoSuchElementException("called max() with empty s.t.");
        return max(root).key;
    }

    private Node max(Node x) {
        if (x.right == null) return x;
        else return max(x.right);
    }

    public Key floor(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to floor is null ");
        if (isEmpty()) throw new NoSuchElementException("called floor() with empty s.t.");
        Node x = floor(root, key);
        if (x == null) return null;
        else return x.key;
    }

    private Node floor(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) return floor(x.left, key);
        Node t = floor(x.right, key);
        if (t != null) return t;
        else return x;
    }

    public Key ceiling(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to ceiling() is null)");
        if (isEmpty()) throw new NoSuchElementException("called ceiling() with empty s.t.");
        Node x = ceiling(root, key);
        if (x == null) return null;
        else return x.key;
    }

    private Node ceiling(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) {
            Node t = ceiling(x.left, key);
            if (t != null) return t;
            else return x;
        }
        return ceiling(x.right, key);
    }

    /**
     * Returns the k-th smallest key in the symbol table
     */
    public Key select(int k) {
        if (k < 0 || k >= size()) {
            throw new IllegalArgumentException("called select() with invalid argument: " + k);
        }
        Node x = select(root, k);
        return x.key;
    }

    //Return key of rank k
    private Node select(Node x, int k) {
        if (x == null) return null;
        int t = size(x.left);
        if (t > k) return select(x.left, k);
        else if (t < k) return select(x.right, k - t - 1);
        else return x;
    }

    /**
     * Return the number of keys in the symbol table strictly less than  key
     **/
    public int rank(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to rank() is null");
        return rank(key, root);
    }

    //Number of keys in the subtree less than key
    private int rank(Key key, Node x) {
        if (x == null) return 0;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return rank(key, x.left);
        else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right);
        else return size(x.left);
    }

    /**
     * Returns all keys in the symbol table as an Iterable
     * To iterate over all of the keys i the symbol table named st
     * use the foreach notation (Key key : st.keys())
     */
public Iterable<Key> keys() {
return keys(min(), max());
}

    /**
     * Returns all keys in the symbol table in the given range, as an Iterable
     */
public Iterable<Key> keys(Key lo, Key hi) {
    if (lo == null) throw new IllegalArgumentException("first argument to keys() is null");
    if (hi == null) throw new IllegalArgumentException("second argument to keys() is null");
    Queue<Key> queue = new ArrayDeque<>();
    keys(root, queue, lo, hi);
    return queue;
}

private void keys (Node x, Queue<Key> queue, Key lo, Key hi) {
    if(x==null) return ;
    int cmplo = lo.compareTo(x.key);
    int cmphi = hi.compareTo(x.key);
    if(cmplo<0) keys(x.left, queue,lo,hi);
    if(cmplo<=0 && cmphi>=0) queue.add(x.key);
    if(cmphi>0) keys(x.right, queue, lo, hi) ;
}

/**
 * Returns the number of keys in the symbol table in the given range
 */
public int size (Key lo, Key hi) {
    if (lo == null) throw new IllegalArgumentException("first argument to size() is null");
    if (hi == null) throw new IllegalArgumentException("second argument to size() is null");
if (lo.compareTo(hi)>0) return 0;
if(contains(hi)) return rank(hi) - rank(lo) +1;
else return rank (hi) - rank(lo);

}

/**
 * Returns the height of the BST (for debugging)
 */
public int height () {
    return height (root);
}

private int height (Node x) {
    if (x==null) return -1;
    return 1 + Math.max(height(x.left), height(x.right));
}

/**
 * Returns the keys in the BST in the level order (for debugging)
 */
public Iterable<Key> levelOrder() {
    algorithms.binary_search_trees.Queue<Key> keys = new algorithms.binary_search_trees.Queue<>();
    algorithms.binary_search_trees.Queue<Node> queue = new algorithms.binary_search_trees.Queue<>();
    queue.enqueue(root);
    while(!queue.isEmpty()) {
        Node x = queue.dequeue();
        if(x==null) continue;
        keys.enqueue(x.key);
        queue.enqueue(x.left);
        queue.enqueue(x.left);
    }
    return keys;
}

/**
 * Check integrity of BST data structure
 */
private boolean check() {
    if(!isBST()) System.out.println("Not in symmetric order");
    if(!isSizeConsistent()) System.out.println("Subtree counts not consistent");
    if(!isRankConsistent()) System.out.println("Ranks not consistent");
    return isBST() && isSizeConsistent() && isRankConsistent();
}

//does this binary tree satisfy symmetric order?
// Note: this test also ensures that data structure is a binary tree since order is strict
private  boolean isBST() {
    return isBST(root, null, null);
}

// is the tree rooted at x a BST with all keys strictly between min and max
// (if min or max is null, treat as empty constraint)
    private boolean isBST(Node x, Key min, Key max) {
    if(x==null) return true;
    if(min != null && x.key.compareTo(min)<=0) return false;
    if(max != null && x.key.compareTo(max)>=0) return false;
        return isBST(x.left, min, x.key) && isBST(x.right, x.key, max);
    }

//are the size fields correct?
    private boolean isSizeConsistent() {return isSizeConsistent(root);}
private boolean isSizeConsistent(Node x){
    if(x==null) return true;
    if(x.size!=size(x.left) + size(x.right)+1) return false;
    return isSizeConsistent(x.left) && isSizeConsistent(x.right);
}

// check that ranks are consistent
    private boolean isRankConsistent(){
    for(int i=0; i<size();i++){
        if(i!=rank(select(i))) return false;
    }
    for(Key key : keys()) {
        if(key.compareTo(select(rank(key))) != 0 ) return false;
    }
    return true;
    }

/**
 * Unit tests the BST data type
 */

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    BST<String, Integer> st = new BST<>();
    for(int i=0;  !sc.hasNext(); i++ ){
        String key = sc.next();
        st.put(key,i);
    }

    for(String s : st.levelOrder())
        System.out.println(s+" "+st.get(s));

    for(String s : st.keys() )
        System.out.println(s+ " " +st.get(s));
}










}






















































