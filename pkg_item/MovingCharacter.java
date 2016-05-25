package pkg_item;

import pkg_room.Room;

import java.util.Stack;
/**
 * Classe qui décrit les MovingCharacters
 *
 * @author Wallerand
 * @version 25/05/2016
 */

 public class MovingCharacter extends Character {

   private Stack<Room> aWay;

   /**
    * Constructeur naturel
    * @param pName Nom du character
    * @param pSpeak Phrase que dit le character à l'arrivé
    * @param pDescription Description du character
    */
   public MovingCharacter(final String pName, final String pDescription, final String pSpeak) {
      super(pName, pDescription, pSpeak);
      this.setCurrentRoom(null);
      this.aWay = new Stack<Room>();
   }

   /**
    * addRoom() : Ajoute une Room à la stack à visiter
    * @param pRoom Room à ajouter
    */
    public void addRoom(final Room pRoom){
      this.aWay.push(pRoom);
    }

    /**
     * move() : Déplace le MovingCharacter d'une pièce à la suivante
     */
     public void move() {
        if(!this.aWay.isEmpty()) {
          super.getCurrentRoom().removeCharacter(this);
          Room vNextRoom = this.aWay.pop();
          vNextRoom.addCharacter(this);
        }
     }

     /**
      * wayIsEmpty() : Vérifie si il reste des Room à visiter
      * @return Vide ou non
      */
      public boolean wayIsEmpty() {
         return this.aWay.isEmpty();
      }
 }
