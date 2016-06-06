package pkg_item;

import pkg_room.Room;

import pkg_item.Item;
import pkg_item.ItemList;

/**
 * Classe qui décrit les ProfessorCharacter (Personnage à qui on donne les objets pour gagner)
 *
 * @author Wallerand
 * @version 25/05/2016
 */

 public class ProfessorCharacter extends Character {

   private ItemList aWinItemList;

   /**
    * Constructeur naturel
    * @param pName Nom du character
    * @param pSpeak Phrase que dit le character à l'arrivé
    * @param pDescription Description du character
    */
   public ProfessorCharacter(final String pName, final String pDescription, final String pSpeak) {
      super(pName, pDescription, pSpeak);
      this.aWinItemList = new ItemList();
   }

   /**
    * addWinItem() : Ajoute les items qui permettent de gagner
    * @param pName Nom de l'item
    * @param pItem Item
    */
   public void addWinItem(final Item pItem){
     this.aWinItemList.setItem(pItem.getDescription(), pItem);
   }

   /**
    * setItem() : Donne un item au character
    * @param pItem Item donné
    */
   @Override
   public void setItem(final Item pItem){
     String vName = pItem.getDescription();
     this.aWinItemList.removeItem(vName);
   }


  /**
   * setItem() : Donne un item au character
   * @param pName String de l'item donné
   */
   public void setItem(final String pName){
     this.aWinItemList.removeItem(pName);
   }

  /**
   * getRemainsItem() : Renvoi les items en String
   * return String Liste des items formatés
   */
   public String getRemainsItem(){
     if(this.aWinItemList.isEmpty()){
       return "You gave me all the objects ! You won !";
     }
     else{
       return "You must give me "+this.aWinItemList.getItemsString()+" to win";
     }
   }
  /**
   * hasNoMoreItem() : Permet de savoir si la liste est vide (donc si le joueur a gagné)
   * @return boolean true or false if empty or not
   */
   public boolean hasNoMoreItem(){
      return this.aWinItemList.isEmpty();
   }

 }
