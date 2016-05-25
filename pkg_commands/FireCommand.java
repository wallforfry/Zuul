package pkg_commands;

import pkg_game.GameEngine;

import pkg_player.Player;
/**
 * FireCommand : Déclanche le Beamer
 */
public class FireCommand extends Command {

	public FireCommand() {
	}

	@Override
	public boolean execute(Player pPlayer) {

    GameEngine.aGui.println(pPlayer.fire(this.getSecondWord()));
		GameEngine.displayImage(pPlayer);
		return false;
	}

}
