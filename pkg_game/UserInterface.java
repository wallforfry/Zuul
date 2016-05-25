package pkg_game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.awt.image.*;

/**
 * Cette classe implémente une interface graphique simpliste comportant des boutons, une image, un entryField et une zone d'affichage.
 *
 * @author Michael Kolling
 * @version 1.0 (Jan 2003)
 */
public class UserInterface implements ActionListener
{
    private GameEngine aEngine;
    private JFrame myFrame;
    private JTextField aEntryField;
    private JTextArea aLog;
    private JLabel aImage;

    /**
     * Construct a UserInterface. As a parameter, a Game Engine
     * (an object processing and executing the game commands) is
     * needed.
     *
     * @param pGameEngine  The GameEngine object implementing the game logic.
     */
    public UserInterface(GameEngine pGameEngine)
    {
        aEngine = pGameEngine;
        createGUI();
    }

    /**
     * Print out some text into the text area.
     */
    public void print(String pText)
    {
        aLog.append(pText);
        aLog.setCaretPosition(aLog.getDocument().getLength());
    }

    /**
     * Print out some text into the text area, followed by a line break.
     */
    public void println(String pText)
    {
        aLog.append(pText + "\n");
        aLog.setCaretPosition(aLog.getDocument().getLength());
    }

    /**
     * Show an image file in the interface.
     */
    public void showImage(String pImageName)
    {
        URL vImageURL = this.getClass().getClassLoader().getResource(pImageName);
        if(vImageURL == null)
            println("image not found");
        else {
            ImageIcon vIcon = new ImageIcon(vImageURL);
            aImage.setIcon(vIcon);
            myFrame.pack();
        }
    }

    /**
     * Enable or disable input in the input field.
     */
    public void enable(boolean pOn)
    {
        aEntryField.setEditable(pOn);
     //   if(!pOn)
//            aEntryField.getCaret().setBlinkRate(0);
    }

    /**
     * Quit the game
     */
    public void quit()
    {
        aEntryField.setEditable(false);
        aEntryField.getCaret().setBlinkRate(0);
        myFrame.dispatchEvent(new WindowEvent(myFrame, WindowEvent.WINDOW_CLOSING));    //close the window
    }

    /**
     * Set up graphical user interface.
     */
    private void createGUI()
    {
        myFrame = new JFrame("fillMyClass()");
        aEntryField = new JTextField(34);

        aLog = new JTextArea();
        aLog.setEditable(false);
        JScrollPane vListScroller = new JScrollPane(aLog);
        vListScroller.setPreferredSize(new Dimension(200, 200));
        vListScroller.setMinimumSize(new Dimension(100,100));

        JPanel vPanel = new JPanel();
        vPanel.setPreferredSize(new Dimension(450,600)); //force la taille de la fenêtre
        aImage = new JLabel();
        JButton vButtonHelp, vButtonLook, vButtonInventory, vButtonQuit, vButtonBack;
        vButtonHelp = new JButton("help");
        vButtonLook = new JButton("look");
        //vButtonEat = new JButton("eat");
        vButtonInventory = new JButton("inventory");
        vButtonQuit = new JButton("quit");
        vButtonBack = new JButton("back");

        vPanel.setLayout(new BorderLayout());
        vPanel.add(aImage, BorderLayout.NORTH);
        vPanel.add(vListScroller, BorderLayout.CENTER);
        vPanel.add(aEntryField, BorderLayout.SOUTH);

        JPanel vPanelRight = new JPanel();
        vPanelRight.setLayout(new GridLayout(6,1));
        vPanelRight.add(vButtonHelp);
        vPanelRight.add(vButtonBack);
        vPanelRight.add(vButtonLook);
        //vPanelRight.add(vButtonEat);
        vPanelRight.add(vButtonInventory);
        vPanelRight.add(vButtonQuit);
        vPanel.add(vPanelRight, BorderLayout.EAST);

        myFrame.getContentPane().add(vPanel, BorderLayout.CENTER);

        // add some event listeners to some components
        myFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {System.exit(0);}
        });

        aEntryField.addActionListener(this);
        vButtonHelp.addActionListener(this);
        vButtonBack.addActionListener(this);
        vButtonLook.addActionListener(this);
        //vButtonEat.addActionListener(this);
        vButtonInventory.addActionListener(this);
        vButtonQuit.addActionListener(this);

        myFrame.pack();
        myFrame.setVisible(true);
        aEntryField.requestFocus();
    }

    /**
     * Actionlistener interface for entry textfield.
     */
    public void actionPerformed(ActionEvent pE)
    {
        // no need to check the type of action at the moment.
        // there is only one possible action: text entry
        if(aEntryField.isEditable()){
            if(pE.getSource() == aEntryField){
                processCommand();
            }
            else{
                aEngine.interpretCommand(pE.getActionCommand());
            }
        }
    }

    /**
     * A command has been entered. Read the command and do whatever is
     * necessary to process it.
     */
    private void processCommand()
    {
        boolean vFinished = false;
        String vInput = aEntryField.getText();
        aEntryField.setText("");

        aEngine.interpretCommand(vInput);
    }
}
