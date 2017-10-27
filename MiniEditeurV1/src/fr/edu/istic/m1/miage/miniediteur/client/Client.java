package fr.edu.istic.m1.miage.miniediteur.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.edu.istic.m1.miage.miniediteur.command.Command;
import fr.edu.istic.m1.miage.miniediteur.invoker.IHM;
import fr.edu.istic.m1.miage.miniediteur.invoker.IHMImpl;
import fr.edu.istic.m1.miage.miniediteur.receiver.MoteurEdition;
import fr.edu.istic.m1.miage.miniediteur.receiver.MoteurEditionImpl;

/**
 * @author Diego Cardenas
 * @version 1.0
 * 
 *          Class Main, this class plays the role of ActionListener of the events
 *          of the interface and is the client in one of the command patterns
 *          implemented.
 * 
 * 
 */

public class Client implements ActionListener {

	private static Client monAppli;
	private static IHM IHMImplInstance;
	private static MoteurEdition moteurEditionImplInstance;
	private Command command;

	/**
	 * this method registers all the action events inside the buttons in the
	 * interface
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String btnId = e.getActionCommand();
		if (btnId.contentEquals("Insérer Texte")) {
			

		}

	}

	/**
	 * This method allows the implementation of a lazy singleton pattern
	 * 
	 * @return MonAppli unique instance of the class
	 */
	public static Client getInstance() {
		if (monAppli == null) {
			monAppli = new Client();
		}
		return monAppli;
	}

	public static void main(String[] args) {
		monAppli = Client.getInstance();
		IHMImplInstance = IHMImpl.getInstance();
		moteurEditionImplInstance = MoteurEditionImpl.getInstance();

	}

}
