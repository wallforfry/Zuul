package pkg_commands;

import pkg_game.GameEngine;

import pkg_player.Player;

/**
 * UnknownCommand : Commande Inconnue
 */
public class UnknownCommand extends Command {

	public UnknownCommand() {
	}

	@Override
	public boolean execute(Player pPlayer) {

    GameEngine.aGui.println("I don't know what you mean...");

		return false;
	}

}
