package pkg_commands;
/**
 * CommandWord Mots de commandes
 *
 * @author Wallerand
 * @version 21/05/2016
 */
public enum CommandWord
{
    // Valeur des mots de commande
    GO("go", new GoCommand()),
    QUIT("quit", new QuitCommand()),
    HELP("help", new HelpCommand()),
    LOOK("look", new LookCommand()),
    EAT("eat", new EatCommand()),
    BACK("back", new BackCommand()),
    TEST("test", new TestCommand()),
    GET("get", new GetCommand()),
    REMOVE("drop", new DropCommand()),
    INVENTORY("inventory", new InventoryCommand()),
    UNKNOWN("?", new UnknownCommand()),
    CHARGE("charge", new ChargeCommand()),
    FIRE("fire", new FireCommand()),
    ALEA("alea", new AleaCommand()),
    TALK("talk", new TalkCommand()),
    GIVE("give", new GiveCommand());

    private String aCommandString;
    private Command aCommand;
    /**
     * Init avec le commandWord correspondant
     * @param pCommandString String de commande
     */
    CommandWord(String pCommandString, Command pCommand)
    {
        this.aCommandString = pCommandString;
        this.aCommand = pCommand;
    }

    /**
     * @return le commandWord en String
     */
    public String toString()
    {
        return aCommandString;
    }

    /**
     * @return La Command
     */
    public Command getCommand()
    {
       return this.aCommand;
    }
}
