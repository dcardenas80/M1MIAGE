package fr.edu.istic.m1.miage.miniediteur.command;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import fr.edu.istic.m1.miage.miniediteur.invoker.IHMImpl;
import fr.edu.istic.m1.miage.miniediteur.receiver.EditorMotorImpl;

/**
 * @author Diego Cardenas
 * @version 1.0
 * 
 *          Class charged with the logic implementation of the concrete command
 *          PasteText
 */
public class PasteText implements Command {
	
	private EditorMotorImpl editorMotorImpl;
    private IHMImpl ihmImpl;
	/**
	 * Execute method for the command PasteText
	 */
	@Override
	public void execute() {
		editorMotorImpl = EditorMotorImpl.getInstance();
		ihmImpl = IHMImpl.getInstance();

		try {
			editorMotorImpl.setCaret(ihmImpl.getCaretPosition());
			editorMotorImpl.pasteText();
		} catch (UnsupportedFlavorException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
