package pkg_room;

import pkg_game.GameEngine;

import java.util.HashMap;
import java.util.Random;
/**
 * Classe qui renvoi une Room au hasard
 *
 * @author Wallerand
 * @version 23/05/2016
 */
public class RoomRandomizer
{
    private static String aAleaRoom = "";

    /**
     * Constructeur de la classe
     */
    public RoomRandomizer()
    {
    }

    /**
     * Setter de aAleaRoom
     * @param pAleaRoom Room a utiliser comme Room aléatoire
     */
    public static String setAleaRoom(final String pAleaRoom){
        if(GameEngine.getDebug()){
            if(pAleaRoom == null){
                aAleaRoom = "";
                return "Random is real";
            }
            else{
                aAleaRoom = pAleaRoom;
                return "Random set on "+aAleaRoom;
            }
        }
        else{
            return "The game isn't in Debug Mod";
        }
    }

    /**
     * getRandomRoom Renvoi une Room random
     * @return A Random Room
     */
    public static Room getRandomRoom(final HashMap<String, Room> pRoomList){
        if(GameEngine.getDebug() && aAleaRoom != ""){
            return pRoomList.get(aAleaRoom);
        }
        else{
            Random generator = new Random();
            Object[] values = pRoomList.values().toArray();
            Room randomValue = (Room) values[generator.nextInt(values.length)];
            return randomValue;
        }
    }
}
