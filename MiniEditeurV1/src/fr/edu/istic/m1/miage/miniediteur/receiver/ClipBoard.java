package fr.edu.istic.m1.miage.miniediteur.receiver;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

/**
 * @author Diego Cardenas
 * @version 1.0
 */

public class ClipBoard {
	/**
	 * this class is a POJO and acts only to save a text when a copy or cut command
	 * has been executed
	 */
	private Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	

	public String getContent() throws UnsupportedFlavorException, IOException {
		return (String) clipboard.getData(DataFlavor.stringFlavor);
	}

	public void setContent(String text) {
		StringSelection selection = new StringSelection(text);
		clipboard.setContents(selection, selection);
	}

}
