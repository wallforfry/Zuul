package pkg_commands;

import pkg_game.GameEngine;

import pkg_player.Player;
/**
 * InventoryCommand : Lache un Item
 */
public class InventoryCommand extends Command {

	public InventoryCommand() {
	}

	@Override
	public boolean execute(Player pPlayer) {
		if(this.hasSecondWord()){
			GameEngine.aGui.println("Inventory what ?");
		}
		else{
    	GameEngine.aGui.println(pPlayer.inventory());
		}
		return false;
	}

}
