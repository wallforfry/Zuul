package pkg_commands;

import pkg_game.GameEngine;

import pkg_player.Player;
/**
 * LookCommand : affiche le lieu et les sorties possibles ou la description de l'item si second mot
 */
public class LookCommand extends Command {

	public LookCommand() {
	}

	@Override
	public boolean execute(Player pPlayer) {

		if(this.hasSecondWord()){

			String vSecondWord = this.getSecondWord();
			if(pPlayer.getItemList().containsKey(vSecondWord)){		//Inventaire du joueur
				GameEngine.aGui.println(pPlayer.getItemList().getItem(vSecondWord).getDescription()+" weighs "+pPlayer.getItemList().getItem(vSecondWord).getWeight());
			}
			else if(pPlayer.getCurrentRoom().getItemList().containsKey(vSecondWord)){		//inventaire de la Room
				GameEngine.aGui.println(pPlayer.getCurrentRoom().getItemList().getItem(vSecondWord).getDescription()+" weighs "+pPlayer.getCurrentRoom().getItemList().getItem(vSecondWord).getWeight());
			}
			else{
				GameEngine.aGui.println("This item is not in your inventory or in this room");
			}

		}
		else{
        GameEngine.aGui.println(pPlayer.getCurrentRoom().getLongDescription());
        GameEngine.aGui.println(pPlayer.inventory());
				GameEngine.aGui.println("You can move "+pPlayer.getTimeLimit()+" time");
		}

		return false;
	}

}
