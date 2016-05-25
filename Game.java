 import pkg_game.UserInterface;
 import pkg_game.GameEngine;


/**
 * Classe Game qui lie l'interface et le moteur du jeu
 *
 * @author Wallerand
 * @version 11/04/2016
 */
public class Game
{
    private UserInterface aGui;
    private GameEngine aEngine;

    /**
     * Construteur par défaut, créé le moteur, l'interface GUI et l'assigne au moteur.
     */
    public Game()
    {
        aEngine = new GameEngine();
        aGui = new UserInterface(aEngine);
        aEngine.setGUI(aGui);
    }//Game default


} // Game
