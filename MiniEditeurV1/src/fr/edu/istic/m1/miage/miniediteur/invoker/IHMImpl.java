package fr.edu.istic.m1.miage.miniediteur.invoker;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.event.CaretListener;

import fr.edu.istic.m1.miage.miniediteur.client.Client;
import fr.edu.istic.m1.miage.miniediteur.command.Command;
import fr.edu.istic.m1.miage.miniediteur.receiver.EditorMotorImpl;

/**
 * @author Diego Cardenas
 * @version 2.0
 * 
 */

public class IHMImpl implements IHM {

	private static IHMImpl IHMImplInstance;
	private static Client client;
	private static EditorMotorImpl editorMotorImpl;
	private int selectionOrigin;
	private int selectionSize;
	private char lastChart;
	private Command command;

	private JFrame frmTextProcessor;
	private JTextArea pnlText;
	private static final int textAreaRows = 20;
	private static final int textAreaCols = 60;

	/**
	 * private Constructor of the IHMImpl Class it receives three listeners charged
	 * of the events on the GUI
	 * 
	 * @param actionListener
	 *            - an action listener for the actions on the buttons
	 * @param caretListener
	 *            - the caret listener charge of the updates on the caret for the
	 *            panel text
	 * @param keyListener
	 *            - a listener for the keyboard actions
	 */
	private IHMImpl(ActionListener actionListener, CaretListener caretListener, KeyListener keyListener) {
		initialize(actionListener, caretListener, keyListener);
		frmTextProcessor.pack();
		frmTextProcessor.setLocationRelativeTo(null);
		pnlText.requestFocusInWindow();
	}

	/**
	 * initialize of the GUI sets components like buttons and text areas.
	 * 
	 * @param actionListener
	 *            - an action listener for the actions on the buttons
	 * @param caretListener
	 *            - the caret listener charge of the updates on the caret for the
	 *            panel text
	 * @param keyListener
	 *            - a listener for the keyboard actions
	 */
	private void initialize(ActionListener actionListener, CaretListener caretListener, KeyListener keyListener) {
		frmTextProcessor = new JFrame();
		frmTextProcessor.setTitle("Mini Editeur");
		frmTextProcessor.setForeground(Color.GRAY);
		frmTextProcessor.setBackground(Color.GRAY);
		frmTextProcessor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel pnlBorder = new JPanel();
		frmTextProcessor.getContentPane().add(pnlBorder, BorderLayout.NORTH);
		pnlBorder.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JButton btnCopy = new JButton("Copier Texte");
		btnCopy.setVerticalAlignment(SwingConstants.TOP);
		btnCopy.addActionListener(actionListener);
		btnCopy.setIcon(new ImageIcon(("icons/copyIcon.png")));
		JButton btnPaste = new JButton("Coller Texte");
		btnPaste.setVerticalAlignment(SwingConstants.TOP);
		btnPaste.addActionListener(actionListener);
		btnPaste.setIcon(new ImageIcon(("icons/pasteIcon.png")));
		JButton btnCut = new JButton("Couper Texte");
		btnCut.setVerticalAlignment(SwingConstants.TOP);
		btnCut.addActionListener(actionListener);
		btnCut.setIcon(new ImageIcon(("icons/cutIcon.png")));
		pnlBorder.add(btnCopy);
		pnlBorder.add(btnPaste);
		pnlBorder.add(btnCut);
		pnlText = new JTextArea();
		pnlText.addCaretListener(caretListener);
		pnlText.addKeyListener(keyListener);
		pnlText.setBackground(Color.WHITE);
		pnlText.setLineWrap(true);
		pnlText.setColumns(textAreaCols);
		pnlText.setRows(textAreaRows);

		JScrollPane scrollPane = new JScrollPane(pnlText);
		frmTextProcessor.getContentPane().add(scrollPane, BorderLayout.CENTER);

	}

	/**
	 * Lazy implementation of Singleton pattern
	 * 
	 * @return an instance of the IHMImpl class
	 */
	public static IHMImpl getInstance() {
		if (IHMImplInstance == null) {
			client = Client.getInstance();
			IHMImplInstance = new IHMImpl(client, client, client);
			IHMImplInstance.frmTextProcessor.setVisible(true);
		}
		return IHMImplInstance;
	}

	/**
	 * concrete implementation of setCommand method, receives a object of type
	 * command and calls its execute method
	 */
	@Override
	public void setCommand(Command command) {
		// TODO Auto-generated method stub
		this.command = command;
		this.command.execute();

	}

	/**
	 * get the point where a selection begins
	 * 
	 * @return an integer with the value of the initial position
	 */
	public int getSelectionOrigin() {
		return selectionOrigin;
	}

	/**
	 * sets the initial point of a selection on the IHM
	 * 
	 * @param selectionOrigin
	 *            - the initial point
	 */

	public void setSelectionOrigin(int selectionOrigin) {
		this.selectionOrigin = selectionOrigin;
	}

	public int getSelectionSize() {
		return selectionSize;
	}

	public void setSelectionSize(int selectionSize) {
		this.selectionSize = selectionSize;
	}

	/**
	 * returns the last chart typed by the user
	 * 
	 * @return a char that contains the last typed char by the client
	 */
	public char getLastChart() {
		return lastChart;
	}

	/**
	 * sets the last char that the users has typed
	 * 
	 * @param lastChart
	 *            - the last char typed
	 */
	public void setLastChart(char lastChart) {
		this.lastChart = lastChart;
	}

	/**
	 * Updates the text and caret position on the IHM
	 */
	@Override
	public void update() {
		// TODO Auto-generated method stub

		editorMotorImpl = EditorMotorImpl.getInstance();
		if (!editorMotorImpl.isSelection()) {

			int caretPosition = editorMotorImpl.getCaret();
			pnlText.setText(editorMotorImpl.getBuffer().toString());
			pnlText.setCaretPosition(caretPosition);

		} else {
			int selectionStart, selectionSize = 0;
			selectionStart = editorMotorImpl.getSelectionOrigin();
			selectionSize = editorMotorImpl.getSelectionSize();

			pnlText.setSelectionStart(selectionStart);
			pnlText.setSelectionEnd(selectionStart + selectionSize);

		}
		pnlText.requestFocusInWindow();
	}

	/**
	 * returns the caret position on the IHM
	 * 
	 * @return a integer with the actual caret position on the IHM
	 */
	public int getCaretPosition() {
		return pnlText.getCaretPosition();
	}
}
