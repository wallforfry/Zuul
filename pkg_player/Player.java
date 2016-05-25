package pkg_player;

import pkg_item.Beamer;
import pkg_item.ItemList;
import pkg_item.MovingCharacter;

import pkg_room.Room;

import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;
import java.util.Stack;

/**
 * Classe du joueur. Elle contient sa pièce courante, les pièces précédentes, les items portés, le poids maximum transportable.
 *
 * @author Wallerand
 * @version 24/05/2016
 */
public class Player
{
    private Room aCurrentRoom;
    private Stack<Room> aLastRoom;
    private int aMaxWeight;
    private ItemList aItemList;
    private int aTimeLimit;
    private ItemList aMovingCharacterList;

    /**
     * Constructeur : On initialise seulement la salle courante.
     * @param pCurrentRoom Salle d'où démarre le joueur
     */
    public Player(final Room pCurrentRoom)
    {
        this.aCurrentRoom = pCurrentRoom;
        this.aLastRoom = new Stack<Room>();
        this.aItemList = new ItemList();
        this.aMovingCharacterList = new ItemList();
        this.aMaxWeight = 4;
        this.aTimeLimit = 20;
    }//Player

    /**
     * getCurrentRoom() :
     * @return Renvoi la salle courante
     */
    public Room getCurrentRoom(){
        return this.aCurrentRoom;
    }//getCurrentRoom

    /**
     * setCurrentRoom() : Permet de modifier la pièce courante.
     */
    public void setCurrentRoom(final Room pCurrentRoom){
        this.aCurrentRoom = pCurrentRoom;
    }//setCurrentRoom

    /**
     * hasLastRoom()
     * @return Renvoi true si il y a une salle précédente
     */
    public boolean hasLastRoom(){
        return !this.aLastRoom.empty();
    }

    /**
     * getLastRoom() : Permet de récupérer la dernière Room
     * @return Renvoi la dernière Room
     */
    public Room getLastRoom(){
        return this.aLastRoom.pop();
    }//getLastRoom

    /**
     * peekLastRoom() : Permet de récupérer la dernière Room sans la supprimer
     * @return Renvoi la dernière Room
     */
    public Room peekLastRoom(){
        return this.aLastRoom.peek();
    }//getLastRoom


    /**
     * setLastRoom() : Ajoute une salle à la Stack des salles précédantes
     * @param pLastRoom Room à ajouter à la Stack
     */
    public void setLastRoom(final Room pLastRoom){
        this.aLastRoom.push(pLastRoom);
    }//setLastRoom

    /**
     * changeRoom()
     * @param pNextRoom nom de la Room où aller
     */
    public void changeRoom(final Room pNextRoom){
//        this.setLastRoom(this.aCurrentRoom);
        this.setCurrentRoom(pNextRoom);
        this.aTimeLimit--;
    }

    /**
     * getTimeLimit() : Permet de récupérer le temps restant
     * @return Renvoi le temps restant
     */
    public int getTimeLimit(){
        return this.aTimeLimit;
    }//getLastRoom

    /**
     * getMaxWeight() : Permet de récupérer le poids max
     * @return Le poids max
     */
    public int getMaxWeight(){
        return this.aMaxWeight;
    }//getMaxWeight

    /**
     * setMaxWeight() : Permet de régler le poids max
     * @param pMaxWeight nouveau poids max
     */
    public void setMaxWeight(final int pMaxWeight){
        this.aMaxWeight = pMaxWeight;
    }//getMaxWeight
//

//
    /**
     * pickUpItem() : Permet de récupérer un item dans une Room
     * @param pName Nom de l'item à récupérer
     * @param pRoom Room où se trouve actuellement l'objet
     * @return String qui dit si l'objet a été prit, est trop lourd, si l'élément n'est pas dans la salle.
     */
    public String pickUpItem(final String pName, final Room pRoom){
        if(pName != null){
            if(pRoom.getItemList().containsKey(pName)){
                if(this.aMaxWeight >= this.aItemList.getTotalWeight()+pRoom.getItemList().getItem(pName).getWeight()){
                    this.aItemList.setItem(pName,pRoom.getItemList().getItem(pName));
                    pRoom.getItemList().removeItem(pName);
                    return pName+" is now in your inventory";
                }
                else{
                    return "This item is too heavy";
                }
            }
            else{
                return pName+" is not in the room";
            }
        }
        else{
            return "Get what ?";
        }
    }//pickUpItem

    /**
     * dropItem() : Permet de poser un item dans une Room
     * @param pName Nom de l'item à déposer
     * @param pRoom Room où se trouve le joueur
     * @return String qui dit si l'objet à été déposé, ou si il n'est pas présent dans l'inventaire.
     */
    public String dropItem(final String pName, final Room pRoom){
        if(pName != null){
            if(this.aItemList.containsKey(pName)){
                pRoom.getItemList().setItem(pName, this.aItemList.getItem(pName));
                this.aItemList.removeItem(pName);
                return pName+" is now in the room";
            }
            else{
                return pName+" is not in your inventory";
            }
        }
        else{
            return "Remove what ?";
        }
    }//dropItem

    /**
     * getPlayerItem() : Permet de récupérer l'inventaire du joueur
     * @return String renvoi l'inventaire formaté
     */
    public String inventory(){
        return "Inventory : "+this.aItemList.getItemsString()+"\nTotal weight : "+this.aItemList.getTotalWeight()+" on "+this.aMaxWeight;
    }

    //PEUT-ÊTRE INUTILE
    /**
     * getItemList() : Permet de récupérer la liste d'item
     * @return ItemList retourne l'itemlist du joueur
     */
    public ItemList getItemList(){
        return this.aItemList;
    }

    /**
     * getMovingCharacters() : Permet de récupérer la liste des MovingCharacters
     * @return ItemList retourne l'itemlist des MovingCharacters
     */
    public ItemList getMovingCharacters(){
        return this.aMovingCharacterList;
    }

    /**
     * moveCharacters() : Déplace les MovingCharacters
     */
    public void moveCharacters(){
      Object[] vValues = this.aMovingCharacterList.getItemList().values().toArray();
      for(int i = 0; i < vValues.length; i++){
          MovingCharacter vCharacter = (MovingCharacter) vValues[i];
          vCharacter.move();
      }
    }

     /**
      * charge() : charge le beamer
      * @return une String qui dit que le beamer est chargé ou qu'il n'est pas disponible
      */
    public String charge(final String pBeamer){
        if(pBeamer != null){
            if(this.aItemList.containsKey(pBeamer)){
                if(this.aItemList.getItem(pBeamer) instanceof Beamer){
                    return ((Beamer)this.aItemList.getItem(pBeamer)).charge(this.aCurrentRoom);
                }
                else{
                    return "This is not a Beamer";
                }
            }
            else{
                return "You don't have a Beamer in your inventory";
            }
        }
        else{
            return "Charge what ?";
        }
    }//charge

    /**
      * fire() : décharge le beamer
      * @return une String qui dit que le beamer est déchargé ou qu'il n'est pas chargé
      */
    public String fire(final String pBeamer){
        if(pBeamer != null){
            if(this.aItemList.containsKey(pBeamer)){
                if(this.aItemList.getItem(pBeamer) instanceof Beamer){
                    Beamer vBeamer = (Beamer) this.aItemList.getItem(pBeamer);
                    if(vBeamer.isCharged()){
                        this.changeRoom(vBeamer.fire());
                        return "You were teleport in : "+this.getCurrentRoom().getLongDescription();
                    }
                    else{
                        return "The Beamer isn't charged";
                    }
                }
                else{
                    return "This is not a Beamer";
                }
            }
            else{
                return "You don't have a Beamer in your inventory";
            }
        }
        else{
            return "Fire what ?";
        }
    }//charge
}
