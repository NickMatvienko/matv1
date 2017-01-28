package figures_patterns;


/**
 * Class is for drawing specific quantity of figures needed for client.
 * This proxy-class helps artist to draw exact number, which is made for resource economy.
 * Proxy-pattern realisation.
 */
public class ArtistProxy implements Artist {
    private Artist proxyArtist;
    private int quantityOfFigures;

    /**
     *
      * @param quantityOfFigures
     */
    public ArtistProxy(int quantityOfFigures) {
        this.quantityOfFigures = quantityOfFigures;
    }


    @Override
    public void drawFigure() {

        proxyArtist = new ConcreteArtist(quantityOfFigures);
        proxyArtist.drawFigure();


    }
}
