package pkg_commands;

import pkg_game.GameEngine;

import pkg_player.Player;
/**
 * LookCommand : affiche le lieu et les sorties possibles
 */
public class LookCommand extends Command {

	public LookCommand() {
	}

	@Override
	public boolean execute(Player pPlayer) {

		if(this.hasSecondWord()){
			GameEngine.aGui.println("Look what ?");
		}
		else{
        GameEngine.aGui.println(pPlayer.getCurrentRoom().getLongDescription());
        GameEngine.aGui.println(pPlayer.inventory());
		}

		return false;
	}

}
