package pkg_commands;

 import java.util.HashMap;
 import java.util.Set;

/**
 * This class is part of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game.
 *
 * This class holds an enumeration table of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kolling and David J. Barnes + D.Bureau
 * @version 2008.03.30 + 2013.09.15
 */
public class CommandWords
{
    private HashMap <String, CommandWord> aValidCommands;

    /**
     * Constructeur par defaut
     */
    public CommandWords()
    {
        aValidCommands = new HashMap<String, CommandWord>();
        for(CommandWord command : CommandWord.values()) {
            if(command != CommandWord.UNKNOWN) {
                aValidCommands.put(command.toString(), command);
            }
        }
    } // CommandWords()

    /**
     * Verifie si une String fait partie des commandes valides.
     * @param pString la String a tester
     * true si pString est valide
     */
    public boolean isCommand( final String pString )
    {
        return this.aValidCommands.containsKey(pString);
    } // isCommand()

    /**
     * Find the CommandWord associated with a command word.
     * @param commandWord The word to look up.
     * @return The CommandWord correspondng to commandWord, or UNKNOWN
     *         if it is not a valid command word.
     */
    public CommandWord getCommandWord(String commandWord)
    {
        CommandWord command = aValidCommands.get(commandWord);
        if(command != null) {
            return command;
        }
        else {
            return CommandWord.UNKNOWN;
        }
    }

    /**
     * Gets the command.
     *
     * @param pCommandWord the command word
     * @return the command
     */
    public Command getCommand(String pCommandWord)
    {
        return this.getCommandWord(pCommandWord).getCommand();
    }

    /**
     * showAll() : Permet d'extraire les mots de commande valides
     * @return Mots de commande
     */
    public String showAll(){
        String vResult = "";

        for( String command : this.aValidCommands.keySet()){
            vResult = vResult + command + ' ';
        }
        return vResult;
    }//showAll

} // CommandWords
