package pkg_room;

import pkg_item.ItemList;
import pkg_item.Item;
import pkg_item.Character;

import java.util.HashMap ;
import java.util.Set;
import java.util.Iterator;

/**
 * Classe Room : Salle du jeu avec sa description, ses sorties, les items qu'elle possède.
 *
 * @author Wallerand
 * @version 11/04/2016
 */
public class Room
{
    private String aDescription;
    private HashMap<String, Room> exits;
    private String aImageName;
    private ItemList aItemList;
    private ItemList aCharactersList;

    /**
         * Constructeur
         * @param pDescription
         *      Description de la salle
         * @param pImage Image de la salle
         * Renvoi une salle nouvellement créée sans sorties
         */
    public Room(final String pDescription, String pImage){
        this.aDescription = pDescription;
        this.exits = new HashMap<String, Room>();
        this.aItemList = new ItemList();
        this.aCharactersList = new ItemList();
        this.aImageName = pImage;
    }//room natural


    /**
         * getDescription() : Renvoi la description de la salle
         * @return description de la salle
         */
    public String getDescription(){
        return this.aDescription;
    }//getDescription

    /**
         * setExits() :
         * @param pDirection
         *      Direction à ajouter
         * @param pNeighbor
         *      Nom de la salle voisine à ajouter
         */
    public void setExits(final String pDirection, final Room pNeighbor){
        exits.put(pDirection, pNeighbor);

    }//setExits

    /**
         * getExits
         * @param pDirection
         *      Direction à interroger
         * @return Renvoi le nom de la salle qui correspond à la direction
         */
    public Room getExits(final String pDirection){

        return exits.get(pDirection);
    }//getExits

    /**
         * getAllExits
         * @return Renvoi la HashMap des exits
         */
    public HashMap<String, Room> getAllExits(){

        return this.exits;
    }//getExits

    /**
         * getExitsString ()
         * @return Renvoi les directions possibles formatées
         */
    public String getExitsString(){
        String result = "Exits: ";
        Set<String> keys = exits.keySet();
        for(String exit : keys){
            result = result+exit+" ";
        }
        return result;
    }

    public ItemList getItemList(){
        return this.aItemList;
    }

    public void setItem(final String pName, final Item pItem){
        this.aItemList.setItem(pName, pItem);
    }

    /**
     * getLongDescription()
     * @return Renvoi la description de la Room + sorties + items présents
     */
    public String getLongDescription(){
        return "You are in the "+aDescription+"\n"+getExitsString()+"\nItems : "+this.aItemList.getItemsString()+"\nCharacters : "+this.aCharactersList.getItemsString();
    }//getLongDescription

    /**
     * getImageName()
     * @return : Renvoi la valeur de aImageName
     */
	    public String getImageName()
	    {
		      return this.aImageName;
	    }

      /**
       * addCharacter : Ajoute un Character à la pièce
       * @param pCharacter Personnage à ajouter dans la pièce
       */
      public void addCharacter(final Character pCharacter) {
          pCharacter.setCurrentRoom(this);
          this.aCharactersList.setItem(pCharacter.getName(), pCharacter);
      }

      /**
       * removeCharacter : Retire un Character à la pièce
       * @param pCharacter Personnage à retirer de la pièce
       */
      public void removeCharacter(final Character pCharacter) {
          this.aCharactersList.removeItem(pCharacter.getName());
      }

      /**
       * getCharacter : Renvoi le Character choisi de la pièce
       * @param pName Nom du character
       * @return Character sous forme d'Item
       */
      public Item getCharacter(final String pName) {
          return this.aCharactersList.getItem(pName);
      }

      /**
       * hasCharacter : Renvoi true/false si Character présent ou pas
       * @param pName Nom du Character
       * @return présent ou pas
       */
      public boolean hasCharacter(final String pName) {
          return this.aCharactersList.containsKey(pName);
      }
} // Room
