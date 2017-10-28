package fr.edu.istic.m1.miage.miniediteur.invoker;

import fr.edu.istic.m1.miage.miniediteur.command.Command;
import fr.edu.istic.m1.miage.miniediteur.receiver.EditorMotor;

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
	public void setCommand (String key, Command command);
	
	public void update();
	
}
