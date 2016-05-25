package pkg_commands;

import pkg_game.GameEngine;

import pkg_player.Player;
/**
 * ChargeCommand : Charge le Beamer
 */
public class ChargeCommand extends Command {

	public ChargeCommand() {
	}

	@Override
	public boolean execute(Player pPlayer) {

    GameEngine.aGui.println(pPlayer.charge(this.getSecondWord()));
		return false;
	}

}
