package pkg_commands;

import pkg_game.GameEngine;

import pkg_player.Player;

/**
 * BackCommand : Effectue un retour arrière
 */
public class BackCommand extends Command {

	public BackCommand() {
	}

	@Override
	public boolean execute(Player pPlayer) {

				String vReturn = "";

				if(!this.hasSecondWord()){
						if(pPlayer.hasLastRoom()){
								if(pPlayer.peekLastRoom() == null){
										vReturn = "You can't go back, it's a trapdoor !";
								}
								else{
										pPlayer.setCurrentRoom(pPlayer.getLastRoom());
										vReturn = "New Current Room : "+pPlayer.getCurrentRoom().getLongDescription();
										GameEngine.displayImage(pPlayer);
								}
						}
						else{
								vReturn = "There is no previous room";
						}
				}
				else{
					vReturn = "Back what ?";
				}

				GameEngine.aGui.println(vReturn);

		return false;
	}

}
