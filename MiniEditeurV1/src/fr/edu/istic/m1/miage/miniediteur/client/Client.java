package fr.edu.istic.m1.miage.miniediteur.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import fr.edu.istic.m1.miage.miniediteur.command.Command;
import fr.edu.istic.m1.miage.miniediteur.command.TextInsertion;
import fr.edu.istic.m1.miage.miniediteur.invoker.IHM;
import fr.edu.istic.m1.miage.miniediteur.invoker.IHMImpl;
import fr.edu.istic.m1.miage.miniediteur.receiver.EditorMotor;
import fr.edu.istic.m1.miage.miniediteur.receiver.EditorMotorImpl;

/**
 * @author Diego Cardenas
 * @version 1.0
 * 
 *          Class Main, this class plays the role of ActionListener of the
 *          events of the interface and is the client in one of the command
 *          patterns implemented.
 * 
 * 
 */

public class Client implements ActionListener, KeyListener, CaretListener {

	private static Client client;
	private static IHMImpl IHMImplInstance;
	private static EditorMotor moteurEditionImplInstance;
	private Command command;
	private static final String[] keys= {"textInsertion"};
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
		if (client == null) {
			client = new Client();
		}
		return client;
	}

	@Override
	public void caretUpdate(CaretEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		e.consume();
		char keyChar = e.getKeyChar();
		if (keyChar != '\b') /** if key typed is not a backspace */
		{
			IHMImplInstance.setLastChart(keyChar);
			command = new TextInsertion();
			moteurEditionImplInstance.attach(IHMImplInstance);
			IHMImplInstance.setCommand(keys[0], command);
			
		}

	}

	public static void main(String[] args) {
		client = Client.getInstance();
		IHMImplInstance = IHMImpl.getInstance();
		moteurEditionImplInstance = EditorMotorImpl.getInstance();

	}

}
