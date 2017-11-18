package fr.edu.istic.m1.miage.miniediteur.invoker;

import fr.edu.istic.m1.miage.miniediteur.command.Command;

/**
 * @author Diego Cardenas
 * @version 1.0
 */

public interface IHM {
	/**
	 * sets and executes the commands
	 * 
	 * @param key
	 *            key that identifies the concrete command
	 * @param command
	 *            concrete command to be set
	 */
	public void setCommand(Command command);

	/**
	 * this method is part of the Observer pattern, and is charged of the update of
	 * the observer when it is notified by the subject
	 */
	public void update();

}
