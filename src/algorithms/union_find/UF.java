package algorithms.union_find;


import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InputMismatchException;

/**
 * Created on 31.03.17.
 */
public class UF {

    private int[] parent; // parent[i] = parent of i;
    private byte[] rank; // rank [i] = rank of subtree rooted at i (never more than 31)
    private int count;    // number of components

    /**
     * Initialize an empty union-find data structure with n sites
     */
    public UF(int n) {
        if (n < 0) throw new IllegalArgumentException();
        count = n;
        parent = new int[n];
        rank = new byte[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    //validate that p is a valid index
    private void validate(int p) {
        int n = parent.length;
        if (p < 0 || p >= n) throw new IndexOutOfBoundsException("index " + p + " is not between 0 and n");
    }

    /**
     * Returns the component identifier for the component containing site p
     *
     * @param p the integer representing one site
     */
    public int find(int p) {
        validate(p);
        if (p != parent[p]) {
            parent[p] = parent[parent[p]]; // path compression by halving
            p = parent[p];
        }
        return p;
    }

    /**
     * Returns the number of components
     */
    public int count() {
        return count;
    }

    /**
     * Returns true if the two sites are in the same component
     */
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * Merges the component containing site p with
     * the component containing site q
     */
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);


        // make root of smaller rank point to root of larger rank
        if (rank[rootP] < rank[rootQ]) parent[rootP] = rootQ;
        else if (rank[rootP] > rank[rootQ]) parent[rootQ] = rootP;
        else {
            parent[rootQ] = rootP;
            rank[rootP]++;
        }
        count--;
    }

    /**
     * Reads an integer n and a sequence of pairs of integers between 0 and n-1
     * where each integer in the pair represents some site;
     * if the sites are in different components, merge the two components and print
     * the pair to standard output
     */
    public static void main(String[] args) {

     //     startInputManually();
       Path path = Paths.get("largeUF.txt");
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String currentLine;
            int n =  Integer.parseInt(reader.readLine());
            UF uf = new UF(n);
            while ((currentLine = reader.readLine()) != null) {
                String [] split = currentLine.split(" ");
                int p = Integer.parseInt(split[0]);
                int q = Integer.parseInt(split[1]);

                if (!uf.connected(p, q)) {
                    uf.union(p, q);
                }
            }
            StdOut.println(uf.count() + " components");
        }
catch (IOException ex) {
            ex.printStackTrace();
}
    }

    public static void startInputManually() {
        System.out.println("Initialize an empty union-find data structure with N sites.\nEnter N...");
        int n = StdIn.readInt();
        UF uf = new UF(n);
        System.out.println("Enter a sequence of pairs of integers between 0 and N-1 where each integer\nin the pair represents some site. If the sites are in different components,\nmerge the two components and print the pair to standard output.\n(to exit enter some non-integer character)");
        while (!StdIn.isEmpty()) {
            try {
                int p = StdIn.readInt();
                int q = StdIn.readInt();

                if (!uf.connected(p, q)) {
                    uf.union(p, q);
                    StdOut.println("Joined " + p + " and " + q);
                } else StdOut.println("is already connected");
            } catch (InputMismatchException e) {
                break;
            }
        }
        StdOut.println(uf.count() + " components");
    }


}
