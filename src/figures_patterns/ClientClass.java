package figures_patterns;

import java.util.Scanner;

/**
 * Entry point. Have fun
 */
public class ClientClass {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("How many figures would you like to draw?");
        int numberOfFigures = in.nextInt();
        Artist artistProxy = new ArtistProxy(numberOfFigures);
        artistProxy.drawFigure();

    }


}
