package pkg_item;

/**
 * Classe permettant de décrire un Item avec une description et un poids
 *
 * @author wallerand
 * @version 11/04/2016
 */
public class Item
{
    private int aWeight;
    private String aDescription;

    /**
     * Constructeur naturel
     * @param pWeight Poids de l'item
     * @param pDescription Description de l'item
     */
    public Item(final int pWeight, final String pDescription)
    {
        this.aWeight = pWeight;
        this.aDescription = pDescription;
    }

    /**
     * getWeight
     * @return Poids de l'item
     */
    public int getWeight(){
        return aWeight;
    }

    /**
     * getDescription
     * @return Description de l'item
     */
    public String getDescription(){
        return aDescription;
    }
}
