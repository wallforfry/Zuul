package pkg_commands;

import pkg_commands.Command;
import pkg_commands.CommandWords;

import java.util.StringTokenizer;

/**
 * This class is part of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game.
 *
 * This parser reads user input and tries to interpret it as an "Adventure"
 * command. Every time it is called it reads a line from the terminal and
 * tries to interpret the line as a two word command. It returns the command
 * as an object of class Command.
 *
 * The parser has a set of known command words. It checks user input against
 * the known commands, and if the input is not one of the known commands, it
 * returns a command object that is marked as an unknown command.
 *
 * @author  Michael Kolling and David J. Barnes + D.Bureau
 * @version 2008.03.30 + 2013.09.15
 */
public class Parser
{
    private CommandWords aValidCommands;  // (voir la classe CommandWords)

    /**
     * Constructeur par defaut qui cree les 2 objets prevus pour les attributs
     */
    public Parser()
    {
        this.aValidCommands = new CommandWords();
    } // Parser()

    /**
     * @return The next command from the user.
     */
    public Command getCommand(String inputLine)
    {
        String vWord1 = null;
        String vWord2 = null;
        String vWord3 = null;

        StringTokenizer tokenizer = new StringTokenizer(inputLine);

        if(tokenizer.hasMoreTokens())
            vWord1 = tokenizer.nextToken();      // get first word
        else
            vWord1 = null;
        if(tokenizer.hasMoreTokens())
            vWord2 = tokenizer.nextToken();      // get second word
        else
            vWord2 = null;
        if(tokenizer.hasMoreTokens()) {
            vWord3 = tokenizer.nextToken();
            if(vWord3.equals("to") && tokenizer.hasMoreTokens())
                vWord3 = tokenizer.nextToken();
            else
                vWord3 = null;
        }
        else {
            vWord3 = null;
        }

        // note: we just ignore the rest of the input line.

        // Now check whether this word is known. If so, create a command
        // with it. If not, create a "UNKNOWN" command (for unknown command).
        Command vCommand = aValidCommands.getCommand(vWord1);
        if(vCommand != null) {
        	vCommand.setSecondWord(vWord2);
          vCommand.setThirdWord(vWord3);
        }
        return vCommand;
    } // getCommand()

    /**
     * showCommands() : Permet de récupérer les mots de commande déclarés dans CommandWords
     * @return Mots de commandes
     */
    public String showCommands(){
        return aValidCommands.showAll();
    }//showCommands
} // Parser
