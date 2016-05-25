package pkg_commands;

import pkg_room.Room;

import pkg_player.Player;

import pkg_game.GameEngine;

/**
 * GoCommand : Commande permettant de changer de pièce
 */
public class GoCommand extends Command {

	public GoCommand() {
	}

	@Override
	public boolean execute(Player pPlayer) {

    String vDirection = this.getSecondWord();
    Room vNextRoom = null;

    if(vDirection != null){
        vNextRoom = pPlayer.getCurrentRoom().getExits(vDirection);
    }
    else{
        GameEngine.aGui.println("Go where ?");
    }

    if(vNextRoom == null)
    {
        GameEngine.aGui.println("There is no door !");
    }//if
    else{
        if(vNextRoom.getExits(pPlayer.getCurrentRoom().getDescription()) != null){
         pPlayer.setLastRoom(pPlayer.getCurrentRoom());
        }
        else{ //cas d'une trapdoor
            pPlayer.setLastRoom(null);
        }
        pPlayer.changeRoom(vNextRoom);
				pPlayer.moveCharacters();
        GameEngine.aGui.println("New Current Room : "+pPlayer.getCurrentRoom().getLongDescription());
        GameEngine.aGui.println(pPlayer.inventory());
        GameEngine.displayImage(pPlayer);
    }//else

		return false;
	}

}
