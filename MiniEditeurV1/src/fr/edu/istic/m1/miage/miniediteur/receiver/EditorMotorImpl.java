package fr.edu.istic.m1.miage.miniediteur.receiver;

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
	private static EditorMotorImpl moteurEditionImplInstance;
	private Buffer textMoteur;
	private Selection selection;
	private Collection<IHM> ihmObservers;
	private ClipBoard clipBoard;
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
		if (moteurEditionImplInstance == null) {

			moteurEditionImplInstance = new EditorMotorImpl();
		}
		return moteurEditionImplInstance;
	}

	@Override
	public void setSelection(int selectionOrigin, int selectionEnd) {
		// TODO Auto-generated method stub
		selection.setSelectionOrigin(selectionOrigin);
		selection.setSelectionSize(selectionEnd);
		selection.setSelection(true);

		notifyObservers();

	}

	@Override
	public void insertText(char text) {
		selection.setSelection(false);
		textMoteur.append(text);

		notifyObservers();
	}

	@Override
	public void deleteText() {
		// TODO Auto-generated method stub
		selection.setSelection(false);
	    textMoteur.deleteText();
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

	public StringBuffer getBuffer() {

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
	public void pasteText() {
		// TODO Auto-generated method stub
		selection.setSelection(false);
		textMoteur.append(clipBoard.getContent());

		notifyObservers();
	}

	@Override
	public void copyText(int selectionOrigin,  int selectionSize) {
		// TODO Auto-generated method stub
		selection.setSelection(false);
		if (selectionSize>0) {
			String textClipBoard= textMoteur.copyText(selectionOrigin,selectionSize);
			clipBoard.setContent(textClipBoard);
			
		}
	
		notifyObservers();
	}

	@Override
	public void cutText(int selectionOrigin, int selectionSize) {
		// TODO Auto-generated method stub
		selection.setSelection(false);
		if (selectionSize>0) {
			String textClipBoard= textMoteur.cutText(selectionOrigin,selectionSize);
			clipBoard.setContent(textClipBoard);
			
		}
	
		notifyObservers();
	}

}
