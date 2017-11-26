package fr.edu.istic.m1.miage.miniediteur.receiver;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

/**
 * @author Diego Cardenas
 * @version 1.0
 * 
 *          this class is a POJO and acts only to save a text when a copy or cut
 *          command has been executed
 */

public class ClipBoard {

	private Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

	/**
	 * returns the content of the clipboard
	 * 
	 * @return a String with the content of the ClipBoard
	 * @throws UnsupportedFlavorException
	 * @throws IOException
	 */
	public String getContent() throws UnsupportedFlavorException, IOException {
		return (String) clipboard.getData(DataFlavor.stringFlavor);
	}

	/**
	 * Sets the content of the ClipBoard
	 * 
	 * @param text - the content to be set
	 */
	public void setContent(String text) {
		StringSelection selection = new StringSelection(text);
		clipboard.setContents(selection, selection);
	}

}
