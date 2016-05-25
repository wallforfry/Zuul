package pkg_room;
/**
 * Classe qui décrit la TransporterRoom
 *
 * @author Wallerand
 * @version 23/05/2016
 */
public class TransporterRoom extends Room
{
    /**
     * Constructeur de la classe
     */
    public TransporterRoom(final String pDescription, final String pImage)
    {
        super(pDescription, pImage);
    }
    /**
     * getExits Overrited
     * @param pDirection
     *          Direction à interroger
     * @return Room Renvoi la Room où aller
     */
    @Override
    public Room getExits(final String pDirection){
        return findRandomRoom();
    }

    /**
     * findRandomRoom
     * @return Room Renvoi une Room au hasard
     */
    private Room findRandomRoom(){
        return RoomRandomizer.getRandomRoom(super.getAllExits());
    }

    /**
     * getLongDescription()
     * @return Renvoi la description de la Room + sorties + items présents
     */
    @Override
    public String getLongDescription(){
        return "You are in the "+super.getDescription()+"\nExits : Somewhere\nItems : "+super.getItemList().getItemsString();
    }//getLongDescription
}
