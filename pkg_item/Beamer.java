package pkg_item;

import pkg_room.Room;

/**
 * Classe qui décrit le téléporteur
 *
 * @author Wallerand
 * @version 21/05/2016
 */
public class Beamer extends Item
{
    private Room aTargetRoom;

    /**
     * Constructeur du beamer
     */
    public Beamer(final int pWeight, final String pDescription)
    {
        super(pWeight, pDescription);
        this.aTargetRoom = null;
    }

    public String charge(final Room pTargetRoom){
        this.aTargetRoom = pTargetRoom;
        return "The beamer is now charged";
    }

    public Room fire(){
        Room vTarget = this.aTargetRoom;
        this.charge(null);
        return vTarget;
    }

    public boolean isCharged(){
        if(this.aTargetRoom == null)
            return false;
        else
            return true;
    }
}
