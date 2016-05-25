package pkg_commands;

import pkg_player.Player;

import pkg_item.Character;

import pkg_game.GameEngine;

/**
 * TalkCommand : Commande qui permet au player de parler avec un Character
 */
public class TalkCommand extends Command {

	public TalkCommand() {
	}

	@Override
	public boolean execute(Player pPlayer) {

    if(pPlayer.getCurrentRoom().hasCharacter(this.getSecondWord())) {

        Character vCharacter = (Character) pPlayer.getCurrentRoom().getCharacter(this.getSecondWord());
		    GameEngine.aGui.println(vCharacter.getName()+" tell : "+vCharacter.getSpeak());
    }
    else {
        GameEngine.aGui.println(this.getSecondWord()+" isn't in "+pPlayer.getCurrentRoom().getDescription());
    }
		return false;
	}

}
