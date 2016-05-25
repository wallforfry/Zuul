package pkg_commands;

import pkg_game.GameEngine;

import pkg_player.Player;
/**
 * QuitCommand : Quitte le jeu
 */
public class QuitCommand extends Command {

	public QuitCommand() {
	}

	@Override
	public boolean execute(Player pPlayer) {

			if(this.hasSecondWord()){
				GameEngine.aGui.println("Quit what ?");
			}
			else{
				GameEngine.aGui.println("\nThank you for playing.  Good bye.");
				GameEngine.aGui.quit();
			}

		return false;
	}

}
