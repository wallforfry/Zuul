package pkg_commands;

import pkg_player.Player;

import pkg_item.Character;
import pkg_item.ProfessorCharacter;

import pkg_game.GameEngine;

/**
 * TalkCommand : Commande qui permet au player de parler avec un Character
 */
public class GiveCommand extends Command {

	public GiveCommand() {
	}

	@Override
	public boolean execute(Player pPlayer) {

    if(this.hasSecondWord()) {
      if(this.hasThirdWord()) {
          if(pPlayer.getCurrentRoom().hasCharacter(this.getThirdWord())) {

              Character vCharacter = (Character) pPlayer.getCurrentRoom().getCharacter(this.getThirdWord());

              if(pPlayer.getItemList().containsKey(this.getSecondWord())){

									if(vCharacter.hasItem()){
		                  pPlayer.getItemList().setItem(vCharacter.getItem().getDescription(), vCharacter.getItem());
		      		        GameEngine.aGui.println(vCharacter.getName()+" give "+vCharacter.getItem().getDescription()+" in exchange for "+this.getSecondWord());

		                  vCharacter.setItem(pPlayer.getItemList().getItem(this.getSecondWord()));
		                  pPlayer.getItemList().removeItem(this.getSecondWord());
									}
									else if(vCharacter instanceof ProfessorCharacter){
										ProfessorCharacter vProfessorCharacter = (ProfessorCharacter) pPlayer.getCurrentRoom().getCharacter(this.getThirdWord());
										vProfessorCharacter.setItem(this.getSecondWord());
										pPlayer.getItemList().removeItem(this.getSecondWord());
										GameEngine.aGui.println(vProfessorCharacter.getName()+" tell : Thank you, "+vProfessorCharacter.getRemainsItem());
										if(vProfessorCharacter.hasNoMoreItem()){
										GameEngine.aGui.enable(false);
										}
									}
									else{
										GameEngine.aGui.println(vCharacter.getName()+" hasn't got any item");
									}
              }
              else {
                GameEngine.aGui.println("You don't have "+this.getSecondWord()+" in your inventory");
              }

          }
          else {
              GameEngine.aGui.println(this.getThirdWord()+" isn't in "+pPlayer.getCurrentRoom().getDescription());
          }
      }
      else{
        GameEngine.aGui.println("Give "+this.getSecondWord()+" to who ?");
      }
    }
    else {
      GameEngine.aGui.println("Give what ?");
    }
		return false;
	}

}
