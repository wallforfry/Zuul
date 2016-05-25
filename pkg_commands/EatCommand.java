package pkg_commands;

import pkg_game.GameEngine;

import pkg_player.Player;
/**
 * EatCommand : Mange un Item
 */
public class EatCommand extends Command {

	public EatCommand() {
	}

	@Override
	public boolean execute(Player pPlayer) {

		if(!this.hasSecondWord()){
			GameEngine.aGui.println("Eat what ?");
		}
		else{
			String vFood = this.getSecondWord();

	    if(pPlayer.getItemList().containsKey(vFood)){
	        if(vFood.equals("Cookie")){
	            pPlayer.setMaxWeight(pPlayer.getMaxWeight()*2);
	            pPlayer.getItemList().removeItem("Cookie");
	            GameEngine.aGui.println("You have eaten now and you are not hungry any more.\nYour max weight is now "+pPlayer.getMaxWeight());
	        }
	        else{
	            GameEngine.aGui.println("This item can't be eaten");
	        }
	    }
	    else{
	        GameEngine.aGui.println("This item isn't in the inventory");
	    }
		}
		return false;
	}

}
