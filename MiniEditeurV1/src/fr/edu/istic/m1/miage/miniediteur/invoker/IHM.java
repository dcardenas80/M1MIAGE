package fr.edu.istic.m1.miage.miniediteur.invoker;

import fr.edu.istic.m1.miage.miniediteur.command.Command;

/**
 * @author Diego Cardenas
 * @version 1.0
 */

public interface IHM
{
	/**
	 *  sets and executes the commands
	 * @param key  key that identifies the concrete command
	 * @param command concrete command to be set
	 */
	public void setCommand (Command command);
	
	public void update();
	
}
