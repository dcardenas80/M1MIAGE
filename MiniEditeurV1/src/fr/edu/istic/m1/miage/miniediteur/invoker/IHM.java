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
	 * @param command
	 *            concrete command to be set
	 */
	public void setCommand(Command command);

	/**
	 * this method is part of the Observer pattern, and is charged of the update of
	 * the observer when it is notified by the subject
	 */
	public void update();

	/**
	 * get the point where a selection begins
	 * 
	 * @return an integer with the value of the initial position
	 */
	public int getSelectionOrigin();

	/**
	 * sets the initial point of a selection on the IHM
	 * 
	 * @param selectionOrigin
	 *            - the initial point
	 */
	public void setSelectionOrigin(int selectionOrigin);

	/**
	 * This method gets the size of the selection
	 * 
	 * @return - the value with the size
	 */
	public int getSelectionSize();

	/**
	 * This method set the selection size on the IHM
	 * 
	 * @param selectionSize
	 *            - the integer value for the size
	 */
	public void setSelectionSize(int selectionSize);

	/**
	 * returns the last chart typed by the user
	 * 
	 * @return a char that contains the last typed char by the client
	 */
	public char getLastChart();

	/**
	 * sets the last char that the users has typed
	 * 
	 * @param lastChart
	 *            - the last char typed
	 */
	public void setLastChart(char lastChart);

	/**
	 * returns the caret position on the IHM
	 * 
	 * @return a integer with the actual caret position on the IHM
	 */
	public int getCaretPosition();

	/**
	 * This method set the caret Position
	 * 
	 * @param caretPosition
	 *            - integer with caret position
	 */
	public void setCaretPosition(int caretPosition);

	/**
	 * This method request the focus on the panel
	 */
	public void setFocusPanel();
}
