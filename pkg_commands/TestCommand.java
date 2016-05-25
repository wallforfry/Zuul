package pkg_commands;

import pkg_game.GameEngine;

import pkg_player.Player;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

/**
 * TestCommand : Commande de test pour le debug
 */
public class TestCommand extends Command {

	public TestCommand() {
	}

	@Override
	public boolean execute(Player pPlayer) {

		if(!this.hasSecondWord()){
			GameEngine.aGui.println("Need file name");
		}
		else{
	    String vFile = this.getSecondWord();
	    Scanner vScan = null;
	    try{
	       vScan = new Scanner( new File("./test/"+vFile+".txt"));
	       while(vScan.hasNextLine()){
	           GameEngine.interpretCommand(vScan.nextLine());
	       }
	    }
	    catch(FileNotFoundException e){
	        GameEngine.aGui.println("File not found");
	    }
		}
		return false;
	}

}
