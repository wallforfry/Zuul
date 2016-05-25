package pkg_item;

import java.util.HashMap;
import java.util.Set;

/**
 * ItemList : décrit les listes Item/String
 *
 * @author Wallerand
 * @version 21/05/2016
 */
public class ItemList
{
    private HashMap<String, Item> aItems;

    public ItemList(){
        this.aItems = new HashMap<String, Item>();
    }

    /**
     * getPlayerItem() : Permet de récupérer un Item en fonction du nom avec lequel il est stocké dans la HashMap aPlayerItems
     * @param pName Nom auquel est associé l'item
     * @return Item correspondant à pName
     */
    public Item getItem(final String pName){
        return this.aItems.get(pName);
    }//getPlayerItem

     /**
         * getItemsString()
         * @return Renvoi les items présents formatées
         */
    public String getItemsString(){
        String result = "";
        Set<String> keys = this.aItems.keySet();
        for(String item : keys){
            result = result+item+" ";
        }
        return result;
    }//getItemsString

    /**
     * setItem() : Permet d'ajouter un item
     * @param pName Nom de l'item (key de la HashMap)
     * @param pItem Item correspondant (Value de la HashMap)
     */
    public void setItem(final String pName, final Item pItem){
        this.aItems.put(pName, pItem);
    }//setPlayerItem

     /**
         * removeItem()
         * @param pName
         *      Nom à retirer
         */
    public void removeItem(final String pName){
        this.aItems.remove(pName);
    }//removeItem

    /**
     * getTotalWeight() : Permet de récupérer le poids total actuellement porté par le joueur
     * @return Poids total des Items portés
     */
    public int getTotalWeight(){
        int vWeight = 0;
        Set<String> keys = this.aItems.keySet();
        for(String item : keys){
            vWeight = vWeight+aItems.get(item).getWeight();
        }

        return vWeight;
    }//getTotalWeight

    /**
     * containsKey() : Teste si l'item est dans la liste
     * @param pName Nom auquel est associé l'item
     * @return boolean true si l'item est dans la liste
     */
    public boolean containsKey(final String pName){
        return this.aItems.containsKey(pName);
    }

    /**
     * getItemList() : Permet de récupérer la liste complète
     * @return aItems : Liste complète
     */
    public HashMap<String, Item> getItemList(){
        return this.aItems;
    }//getItemList

}
