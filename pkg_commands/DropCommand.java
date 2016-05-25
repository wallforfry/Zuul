package pkg_commands;

import pkg_game.GameEngine;

import pkg_player.Player;
/**
 * GetCommand : Lache un Item
 */
public class DropCommand extends Command {

	public DropCommand() {
	}

	@Override
	public boolean execute(Player pPlayer) {

      GameEngine.aGui.println(pPlayer.dropItem(this.getSecondWord(), pPlayer.getCurrentRoom()));

		return false;
	}

}
