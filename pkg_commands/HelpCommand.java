package pkg_commands;

import pkg_game.GameEngine;

import pkg_player.Player;
/**
 * HelpCommand : Affiche un message d'aide
 */
public class HelpCommand extends Command {

	public HelpCommand() {
	}

	@Override
	public boolean execute(Player pPlayer) {

		if(this.hasSecondWord()){
			GameEngine.aGui.println("Help what ?");
		}
		else{
      String vResult = "You are lost. You are alone.\n\nYour command words are:\n";
      GameEngine.aGui.println(vResult+GameEngine.aParser.showCommands());
		}

		return false;
	}

}
