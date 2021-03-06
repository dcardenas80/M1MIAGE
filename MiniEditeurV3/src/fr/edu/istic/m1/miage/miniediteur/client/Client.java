
package fr.edu.istic.m1.miage.miniediteur.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import fr.edu.istic.m1.miage.miniediteur.command.Command;
import fr.edu.istic.m1.miage.miniediteur.command.RedoCommand;
import fr.edu.istic.m1.miage.miniediteur.command.StartRecording;
import fr.edu.istic.m1.miage.miniediteur.command.StopRecording;
import fr.edu.istic.m1.miage.miniediteur.command.UndoCommand;
import fr.edu.istic.m1.miage.miniediteur.command.mementoCommands.RecordableCopyText;
import fr.edu.istic.m1.miage.miniediteur.command.mementoCommands.RecordableCutText;
import fr.edu.istic.m1.miage.miniediteur.command.mementoCommands.RecordableDeleteText;
import fr.edu.istic.m1.miage.miniediteur.command.mementoCommands.RecordableInsertText;
import fr.edu.istic.m1.miage.miniediteur.command.mementoCommands.RecordablePasteText;
import fr.edu.istic.m1.miage.miniediteur.command.mementoCommands.RecordablePlayRecording;
import fr.edu.istic.m1.miage.miniediteur.command.mementoCommands.RecordableSelectText;
import fr.edu.istic.m1.miage.miniediteur.invoker.IHM;
import fr.edu.istic.m1.miage.miniediteur.invoker.IHMImpl;
import fr.edu.istic.m1.miage.miniediteur.receiver.EditorMotor;
import fr.edu.istic.m1.miage.miniediteur.receiver.EditorMotorImpl;

/**
 * @author Diego Cardenas
 * @version 2.0
 * 
 *          Class Main, this class plays the role of ActionListener of the
 *          events of the interface and is the client in one of the command
 *          patterns implemented.
 * 
 * 
 */

public class Client implements ActionListener, KeyListener, CaretListener {

	private static Client client;
	private static IHM IHMImplInstance;
	private static EditorMotor editorMotorImpl;
	private Command command;
	private static final String[] buttonsKeys = { "Copier Texte", "Coller Texte", "Couper Texte", "Enregistrer",
			"Arrêter Enregistrement", "Rejouer", "Defaire", "Refaire" };
	private boolean notRegister = true;
	/**
	 * this method registers all the action events inside the buttons in the
	 * interface
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		String btnId = e.getActionCommand();
		if (btnId.contentEquals(buttonsKeys[0])) {
			command = new RecordableCopyText();
			IHMImplInstance.setCommand(command);
			IHMImplInstance.setFocusPanel();
		} else if (btnId.contentEquals(buttonsKeys[1])) {
			command = new RecordablePasteText();
			IHMImplInstance.setCommand(command);
			IHMImplInstance.setFocusPanel();
		} else if (btnId.contentEquals(buttonsKeys[2])) {
			command = new RecordableCutText();
			IHMImplInstance.setCommand(command);
			IHMImplInstance.setFocusPanel();
		} else if (btnId.contentEquals(buttonsKeys[3])) {
			command = new StartRecording();
			IHMImplInstance.setCommand(command);
			IHMImplInstance.changeButtonsProperties();
		} else if (btnId.contentEquals(buttonsKeys[4])) {
			command = new StopRecording();
			IHMImplInstance.setCommand(command);
			IHMImplInstance.changeButtonsProperties();
		} else if (btnId.contentEquals(buttonsKeys[5])) {
			command = new RecordablePlayRecording();
			IHMImplInstance.setCommand(command);
			IHMImplInstance.setFocusPanel();
		} else if (btnId.contentEquals(buttonsKeys[6])) {
			command = new UndoCommand();
			IHMImplInstance.setCommand(command);
			IHMImplInstance.setFocusPanel();
		} else if (btnId.contentEquals(buttonsKeys[7])) {
			command = new RedoCommand();
			IHMImplInstance.setCommand(command);
			IHMImplInstance.setFocusPanel();
		}

	}

	/**
	 * private constructor of the Client class
	 */
	private Client() {

	}

	/**
	 * This method allows the implementation of a lazy singleton pattern
	 * 
	 * @return an instance of the Client class
	 */
	public static Client getInstance() {
		if (client == null) {
			client = new Client();
		}
		return client;
	}

	/**
	 * this method listen all the updates on the caret and if the update is a
	 * selection demands the execution of the selectText command by the invoker
	 */
	@Override
	public void caretUpdate(CaretEvent e) {
		// TODO Auto-generated method stub

		int selectionOrigin = Math.min(e.getDot(), e.getMark());
		int selectionEnd = Math.max(e.getDot(), e.getMark());
		int selectionSize = selectionEnd - selectionOrigin;
		if (selectionSize != 0) {
			if (selectionOrigin != IHMImplInstance.getSelectionOrigin()
					|| selectionSize != IHMImplInstance.getSelectionSize()) {

				IHMImplInstance.setSelectionOrigin(selectionOrigin);
				IHMImplInstance.setSelectionSize(selectionSize);
				command = new RecordableSelectText();
				IHMImplInstance.setCommand(command);
			}

		}
	}

	/**
	 * this method is only used to capture the control + commands
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		e.consume();
		if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_C) {
			command = new RecordableCopyText();
			IHMImplInstance.setCommand(command);
		} else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_X) {
			command = new RecordableCutText();
			IHMImplInstance.setCommand(command);
		} else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_V) {
			command = new RecordablePasteText();
			IHMImplInstance.setCommand(command);
		} else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_Z) {
			command = new UndoCommand();
			IHMImplInstance.setCommand(command);
		} else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_Y) {
			command = new RedoCommand();
			IHMImplInstance.setCommand(command);
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			int caretPosition = IHMImplInstance.getCaretPosition() - 1;
			IHMImplInstance.setCaretPosition(caretPosition);
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			int caretPosition = IHMImplInstance.getCaretPosition() + 1;
			IHMImplInstance.setCaretPosition(caretPosition);
		}else if (e.getKeyCode() == KeyEvent.VK_DELETE) {
			notRegister = false;
		}

	}

	/**
	 * this method is not implemented
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * this method verifies if a key is typed and if it is a letter or a backspace
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		e.consume();
		int modifier = e.getModifiersEx();
		char keyChar = e.getKeyChar();

		if (modifier != KeyEvent.VK_DEAD_GRAVE) {

			if (keyChar != '\b') /** if key typed is not a backspace */
			{
				if (notRegister) {
					IHMImplInstance.setLastChart(keyChar);
					command = new RecordableInsertText();
					IHMImplInstance.setCommand(command);
				}
				notRegister = true;
			} else if (keyChar == '\b') {
				command = new RecordableDeleteText();
				IHMImplInstance.setCommand(command);
			}
		}
	}

	/**
	 * this is the main method of the program
	 * 
	 * @param args
	 *            - array of arguments void in this case
	 */
	public static void main(String[] args) {
		client = Client.getInstance();
		IHMImplInstance = IHMImpl.getInstance();
		editorMotorImpl = EditorMotorImpl.getInstance();
		editorMotorImpl.attach(IHMImplInstance);
	}

}
