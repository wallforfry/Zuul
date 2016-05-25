package pkg_commands;

import pkg_room.RoomRandomizer;

import pkg_player.Player;

import pkg_game.GameEngine;

/**
 * AleaCommand : Commande de debug qui permet de forcer l'aléatoire de la TransporterRoom
 */
public class AleaCommand extends Command {

	public AleaCommand() {
	}

	@Override
	public boolean execute(Player pPlayer) {

		GameEngine.aGui.println(RoomRandomizer.setAleaRoom(this.getSecondWord()));
		return false;
	}

}
