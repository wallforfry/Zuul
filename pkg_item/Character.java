package pkg_item;

import pkg_room.Room;

import pkg_item.Item;
/**
 * Classe qui décrit les characters
 *
 * @author Wallerand
 * @version 25/05/2016
 */

 public class Character extends Item {

   private String aName;
   private String aSpeak;
   private Room aCurrentRoom;
   private Item aItem;

   /**
    * Constructeur naturel
    * @param pName Nom du character
    * @param pSpeak Phrase que dit le character à l'arrivé
    * @param pDescription Description du character
    */
   public Character(final String pName, final String pDescription, final String pSpeak) {
      super(10000, pDescription);
      this.aName = pName;
      this.aSpeak = pSpeak;
      this.aCurrentRoom = null;
   }

   /**
    * getName() : getter du nom
    * @return Nom du character
    */
    public String getName() {
      return this.aName;
    }

   /**
    * getSpeak() : getter de la phrase
    * @return Phrase du character
    */
   public String getSpeak() {
      return this.aSpeak;
   }

   /**
    * getCurrentRoom() : getter de la Room courante
    * @return Room courante
    */
   public Room getCurrentRoom() {
     return this.aCurrentRoom;
   }

   /**
    * setCurrentRoom() : Setter de la Room courante
    * @param pCurrentRoom Nouvelle Room
    */
   public void setCurrentRoom(final Room pCurrentRoom) {
     this.aCurrentRoom = pCurrentRoom;
   }

   /**
    * getItem() : getter de l'item'
    * @return Item du Character
    */
   public Item getItem() {
     return this.aItem;
   }

   /**
    * setItem() : Setter de l'item
    * @param pItem
    */
   public void setItem(final Item pItem) {
     this.aItem = pItem;
   }

   /**
    * checkGift() : Vérifie que le cadeau est le bon
    * @param pItem
    */
   /*public void setItem(final Room pItem) {
     this.aItem = pItem;
   }*/
 }
