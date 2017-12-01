package fr.edu.istic.m1.miage.miniediteur.receiver;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import fr.edu.istic.m1.miage.miniediteur.invoker.IHM;

/**
 * @author Diego Cardenas
 * @version 1.0
 * 
 */
public class EditorMotorImpl implements EditorMotor {

	/**
	 * Definition of Singleton Pattern to control the number of instances of the
	 * class MoteurEditionImpl
	 */
	private static EditorMotorImpl editorMotorImpl;
	private Buffer textMoteur;
	private Selection selection;
	private Collection<IHM> ihmObservers;
	private ClipBoard clipBoard;
	private boolean selectionMacro;
	/**
	 * Private constructor of the EditorMotorImpl class
	 */
	private EditorMotorImpl() {
		this.textMoteur = new Buffer();
		this.ihmObservers = new ArrayList<IHM>();
		this.selection = new Selection();
		this.clipBoard = new ClipBoard();
	}

	/**
	 * Lazy singleton pattern
	 * 
	 * @return new instance of the EditorMotor if there is not an instance already
	 *         created
	 */
	public static EditorMotorImpl getInstance() {
		if (editorMotorImpl == null) {

			editorMotorImpl = new EditorMotorImpl();
		}
		return editorMotorImpl;
	}

	@Override
	public void setSelection(int selectionOrigin, int selectionEnd) {
		// TODO Auto-generated method stub
		selection.setSelectionOrigin(selectionOrigin);
		selection.setSelectionSize(selectionEnd);
		selection.setSelection(true);
		if (!selectionMacro) {
			notifyObservers();
		}
	
	}

	@Override
	public void insertText(char text) {
		selection.setSelection(false);
		textMoteur.append(text);

		notifyObservers();
	}

	@Override
	public void deleteText() throws StringIndexOutOfBoundsException {
		// TODO Auto-generated method stub
		if (selection.isSelection()) {
			textMoteur.deleteTextByRange(getSelectionOrigin(), getSelectionSize());
		}else {
			textMoteur.deleteText();
		}
		selection.setSelection(false);
		
		notifyObservers();
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		Iterator<IHM> iterator = ihmObservers.iterator();
		while (iterator.hasNext()) {
			IHM ihm = iterator.next();
			ihm.update();

		}

	}

	@Override
	public void attach(IHM ihm) {
		// TODO Auto-generated method stub
		ihmObservers.add(ihm);

	}

	@Override
	public void detach(IHM ihm) {
		// TODO Auto-generated method stub
		ihmObservers.remove(ihm);
	}

	/**
	 * This method returns a String with the text of the Editor's buffer
	 * 
	 * @return a String with the text on the Editor's buffer
	 */
	@Override
	public String getBuffer() {

		return textMoteur.getMotorText();

	}

	public void setCaret(int caretPostion) {
		textMoteur.setCaretPosition(caretPostion);
	}

	@Override
	public int getCaret() {
		// TODO Auto-generated method stub
		return textMoteur.getCaretPosition();
	}

	/**
	 * This method verifies if the action to do is a selection
	 * 
	 * @return a boolean with true if is a selection false in the other case
	 */
	@Override
	public boolean isSelection() {
		return selection.isSelection();
	}

	@Override
	public int getSelectionSize() {
		// TODO Auto-generated method stub
		return selection.getSelectionSize();
	}

	@Override
	public int getSelectionOrigin() {
		// TODO Auto-generated method stub
		return selection.getSelectionOrigin();
	}

	@Override
	public void pasteText() throws UnsupportedFlavorException, IOException {
		// TODO Auto-generated method stub
		selection.setSelection(false);
		textMoteur.append(clipBoard.getContent());
		notifyObservers();
	}

	@Override
	public void copyText() throws StringIndexOutOfBoundsException {
		// TODO Auto-generated method stub
		selection.setSelection(false);
		if (getSelectionSize() > 0) {
			String textClipBoard = textMoteur.copyText(getSelectionOrigin(), getSelectionSize());
			clipBoard.setContent(textClipBoard);
			eraseSelection();
		}
		
			notifyObservers();
		
		
	}
	@Override
	public int getBufferLength() {
		return textMoteur.getLength();
	}

	@Override
	public void cutText() throws StringIndexOutOfBoundsException{
		// TODO Auto-generated method stub
		selection.setSelection(false);
		if (getSelectionSize() > 0) {
			String textClipBoard = textMoteur.cutText(getSelectionOrigin(), getSelectionSize());
			clipBoard.setContent(textClipBoard);
			eraseSelection();
		}
		notifyObservers();
	}

	@Override
	public void setCaretByCommand(int caretPosition) {
		// TODO Auto-generated method stub
		setCaret(caretPosition);
		notifyObservers();
	}
	@Override
	public boolean isSelectionMacro() {
		return selectionMacro;
	}
	@Override
	public void setSelectionMacro(boolean selectionMacro) {
		this.selectionMacro = selectionMacro;
	}
	/**
	 * This method erase a selection from the Editor's selection
	 */
	public void eraseSelection() {
		selection.setSelectionOrigin(getCaret());
		selection.setSelectionSize(getCaret());
	}
	@Override
	public String getContentClipboard() {
		try {
			return clipBoard.getContent();
		} catch (UnsupportedFlavorException | IOException e) {
			// TODO Auto-generated catch block
			return "";
		}
	}
	
	@Override
	public void setContentClipboard(String content) {
		clipBoard.setContent(content);
	}

}
