package pkg_commands;

import pkg_game.GameEngine;

import pkg_player.Player;
/**
 * GetCommand : Récupère un Item
 */
public class GetCommand extends Command {

	public GetCommand() {
	}

	@Override
	public boolean execute(Player pPlayer) {

      GameEngine.aGui.println(pPlayer.pickUpItem(this.getSecondWord(), pPlayer.getCurrentRoom()));

		return false;
	}

}
