package fr.edu.istic.m1.miage.miniediteur.receiver;

import fr.edu.istic.m1.miage.miniediteur.invoker.IHM;

/**
 * @author Diego Cardenas
 * @version 1.0
 */

public interface EditorMotor {
	void selection();

	void coller();

	void copier();

	void insTexte(char texte);

	/**
	 * Notify all the observer.
	 */
	public abstract void notifyObservers();

	/**
	 * Attach a new observer.
	 * 
	 * @param ihm
	 *            Observer to attach
	 * 
	 */
	public abstract void attach(IHM ihm);

	/**
	 * Detach an observer.
	 * 
	 * @param IHM
	 *            observer to remove if it's on the observers following the subject
	 */
	public abstract void detach(IHM ihm);

}
