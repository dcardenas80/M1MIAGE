package fr.edu.istic.m1.miage.miniediteur.command.mementoCommands;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import fr.edu.istic.m1.miage.miniediteur.command.PasteText;
import fr.edu.istic.m1.miage.miniediteur.invoker.IHM;
import fr.edu.istic.m1.miage.miniediteur.invoker.IHMImpl;
import fr.edu.istic.m1.miage.miniediteur.memento.Memento;
import fr.edu.istic.m1.miage.miniediteur.memento.Recorder;
import fr.edu.istic.m1.miage.miniediteur.memento.concretemementos.PasteTextMemento;
import fr.edu.istic.m1.miage.miniediteur.receiver.EditorMotor;
import fr.edu.istic.m1.miage.miniediteur.receiver.EditorMotorImpl;

/**
 * 
 * @author Diego Cardenas
 * @version 1.0
 * 
 * 
 *          Class that inherits Paste Text command and is charged with the
 *          execution of that concrete command and also of the set and get of
 *          the memento object
 *
 */
public class RecordablePasteText extends PasteText implements RecordCommand {
	private Recorder recorder;
	private PasteTextMemento pasteTextMemento;
	private EditorMotor editorMotorImpl;
	private IHM ihmImpl;
	private int caretAfterPaste;

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		super.execute();
		ihmImpl = IHMImpl.getInstance();
		caretAfterPaste = ihmImpl.getCaretPosition();
		recorder = Recorder.getInstance();
		recorder.recordCommands(this);
	}

	@Override
	public Memento getMemento() {
		// TODO Auto-generated method stub
		editorMotorImpl = EditorMotorImpl.getInstance();
		try {
			pasteTextMemento = new PasteTextMemento(editorMotorImpl.getSelectionOrigin(), editorMotorImpl.getSelectionSize(),
					editorMotorImpl.returnPasteContent(),caretAfterPaste);
		} catch (UnsupportedFlavorException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pasteTextMemento;
	}

	@Override
	public void setMemento(Memento memento) {
		// TODO Auto-generated method stub
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

	@Override
	public void reverseCommand(Memento memento) {
		// TODO Auto-generated method stub
		
		editorMotorImpl = EditorMotorImpl.getInstance();
		String pasteContent = ((PasteTextMemento)memento).getContent();
		int caretAfter = ((PasteTextMemento)memento).getCaretAfterPaste();
		int actualCaret = caretAfter-pasteContent.length();
		editorMotorImpl.setSelectionMacro(true);
		editorMotorImpl.setSelection(actualCaret, pasteContent.length());
		editorMotorImpl.setSelectionMacro(false);
		editorMotorImpl.cutText();
	}

}
