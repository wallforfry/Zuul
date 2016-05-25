package pkg_game;

import pkg_commands.Command;
import pkg_commands.CommandWord;
import pkg_commands.Parser;

import pkg_player.Player;

import pkg_item.Beamer;
import pkg_item.Item;
import pkg_item.Character;
import pkg_item.MovingCharacter;

import pkg_room.TransporterRoom;
import pkg_room.Room;

import java.util.Stack;

/**
 * Classe moteur du jeu
 *
 * @author Wallerand
 * @version 24/05/2016
 */
public class GameEngine
{
    private static boolean aDebug = true;

    private static Player aPlayer;
    public static Parser aParser;
    public static UserInterface aGui;

    /**
     * Constructeur par défaut de la classe
     */
    public GameEngine()
    {
        aParser = new Parser();
        this.createRooms();
    }
    /**
     * setGui() : Règle l'interface graphique et affiche le message de bienvenue
     */
    public void setGUI(UserInterface userInterface)
    {
        aGui = userInterface;
        printWelcome();
    }

    /**
     * getDebug() : Renvoi la valeur de Debug
     * @return Valeur de debug
     */
   public static boolean getDebug()
    {
        return aDebug;
    }

    /**
     * createRooms() : Crée les différentes Room, y associe les sorties possible. Crée également les items et les ajoutes à leurs Room respectives
     */
    private void createRooms()
    {
        Room vSalle, vIcampus, vInternet, vForum, vLivre, vUpstairs, vRandom;
        vSalle = new Room("Classroom", "images/salle_opt.jpg");
        vIcampus = new Room("Icampus","images/icampus_opt.png");
        vInternet = new Room("Internet","images/google_opt.png");
        vForum = new Room("Forum", "images/forum_opt.png");
        vLivre = new Room("Book", "images/livre_opt.jpg");
        vUpstairs = new Room("Level up Room", "images/upstairs_opt.png");
        vRandom = new TransporterRoom("TransporterRoom", "images/random_opt.jpg");

        Item vClavier, vCours, vCompilateur, vBluej, vMethode, vVariable, vCookie, vBeamer;
        vClavier = new Item(1,"Clavier");
        vCours = new Item(2, "Cours");
        vCompilateur = new Item(1, "Compilateur");
        vBluej = new Item(1, "Bluej");
        vMethode = new Item(1, "Méthode");
        vVariable = new Item(1, "Variable");
        vCookie = new Item(1, "Cookie");
        vBeamer = (Item) new Beamer(0, "Beamer");


        vSalle.setExits("Icampus", vIcampus);
        vSalle.setExits("Upstairs", vUpstairs);
        vSalle.setItem("Clavier", vClavier);
        vSalle.setItem("Beamer", vBeamer);
        vSalle.setExits("Random", vRandom);

        vIcampus.setExits("Internet", vInternet);
        vIcampus.setExits("Book", vLivre);
        vIcampus.setExits("Forum", vForum);
        vIcampus.setExits("Classroom", vSalle);
        vIcampus.setItem("Cours", vCours);
        vIcampus.setItem("Cookie", vCookie);

        vInternet.setExits("Icampus", vIcampus);
        vInternet.setExits("Forum", vForum);
        vInternet.setExits("Book", vLivre);
        vInternet.setItem("Bluej", vBluej);
        vInternet.setItem("Compilateur", vCompilateur);

        vForum.setExits("Book", vLivre);
        vForum.setExits("Icampus", null);
        vForum.setExits("Internet", vInternet);
        vForum.setItem("Variable", vVariable);

        vLivre.setExits("Forum", vForum);
        vLivre.setExits("Icampus", vIcampus);
        vLivre.setExits("Internet", vInternet);
        vLivre.setItem("Methode", vMethode);

        vUpstairs.setExits("Classroom", vSalle);

        vRandom.setExits("Icampus", vIcampus);
        vRandom.setExits("Forum", vForum);
        vRandom.setExits("Book", vLivre);
        vRandom.setExits("Classroom", vSalle);
        vRandom.setExits("Internet", vInternet);

        aPlayer = new Player(vSalle);


        Character vCharacter1;
        vCharacter1 = new Character("Quentin", "Un garçon", "Salut je suis Quentin");
        vCharacter1.setItem(vCookie);
        vSalle.addCharacter(vCharacter1);

        MovingCharacter vCharacter2;
        vCharacter2 = new MovingCharacter("Johana", "Une fille", "Salut, je suis Johana");
        vCharacter2.addRoom(vInternet);
        vCharacter2.addRoom(vIcampus);
        vSalle.addCharacter(vCharacter2);
        aPlayer.getMovingCharacters().setItem(vCharacter2.getName(), vCharacter2);

        MovingCharacter vCharacter3;
        vCharacter3 = new MovingCharacter("Alice", "Une autre fille", "Salut, je suis Alice");
        vCharacter3.addRoom(vIcampus);
        vInternet.addCharacter(vCharacter3);
        aPlayer.getMovingCharacters().setItem(vCharacter3.getName(), vCharacter3);
    }//createRooms

     /**
     * interpretCommand() : Interpret la commande en effectuant l'action en conséquence
     * @param commandLine String représentant la commande écrite
     */
    public static void interpretCommand(String commandLine)
    {
        Command command = aParser.getCommand(commandLine);
        aGui.println("\nCommand : "+commandLine);
        CommandWord commandWord = command.getCommandWord();

        if(aPlayer.getTimeLimit() <= 0){
            aGui.println("Vous avez perdu car vous avez effectué le maximum de déplacement possible");
            aGui.enable(false);
            return;
        }
        else{
            boolean test = command.execute(aPlayer);
        }

    }

     /**
      * printWelcome() : affiche un message de bienvenue
      */
    private void printWelcome()
    {
        String vWelcome = "Welcome to fillMyClass()!\nfillMyClass() is a new, incredibly boring adventure game\nwhere you must fill my blank Java's Class to level up.\nType 'help' if you need help.\n";
        aGui.println(vWelcome);
        aGui.println(this.aPlayer.getCurrentRoom().getLongDescription());
        aGui.println(this.aPlayer.inventory());
        displayImage(this.aPlayer);
    }//printWelcome

    /**
     * displayImage() : affiche l'image de la Room
     */
    public static void displayImage(final Player pPlayer){
        if(pPlayer.getCurrentRoom().getImageName() != null)
                aGui.showImage(pPlayer.getCurrentRoom().getImageName());
    }
}
