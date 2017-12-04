package fr.edu.istic.m1.miage.miniediteur.invoker;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.event.CaretListener;

import fr.edu.istic.m1.miage.miniediteur.client.Client;
import fr.edu.istic.m1.miage.miniediteur.command.Command;
import fr.edu.istic.m1.miage.miniediteur.receiver.EditorMotor;
import fr.edu.istic.m1.miage.miniediteur.receiver.EditorMotorImpl;

/**
 * @author Diego Cardenas
 * @version 2.0
 * 
 */

public class IHMImpl implements IHM {

	private static IHMImpl IHMImplInstance;
	private static Client client;
	private static EditorMotor editorMotorImpl;
	private int selectionOrigin;
	private int selectionSize;
	private char lastChart;
	private Command command;
	private JFrame frmTextProcessor;
	private JTextArea pnlText;
	private static final int textAreaRows = 30;
	private static final int textAreaCols = 80;
	private JButton btnCut;
	private JButton btnCopy;
	private JButton btnPaste;
	private JButton btnRecording;
	private JButton btnReplay;
	private JButton btnUndo;
	private JButton btnRedo;

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
		pnlBorder.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		btnCopy = new JButton("Copier Texte");
		btnCopy.addActionListener(actionListener);
		btnCopy.setIcon(new ImageIcon(("icons/copyIcon.png")));
		btnPaste = new JButton("Coller Texte");
		btnPaste.addActionListener(actionListener);
		btnPaste.setIcon(new ImageIcon(("icons/pasteIcon.png")));
		btnCut = new JButton("Couper Texte");
		btnCut.addActionListener(actionListener);
		btnCut.setIcon(new ImageIcon(("icons/cutIcon.png")));
		btnRecording = new JButton("Enregistrer");
		btnRecording.addActionListener(actionListener);
		btnRecording.setIcon(new ImageIcon("icons/recordIcon.png"));
		btnReplay = new JButton("Rejouer");
		btnReplay.setVerticalAlignment(SwingConstants.TOP);
		btnReplay.addActionListener(actionListener);
		btnReplay.setIcon(new ImageIcon("icons/playIcon.png"));
		btnReplay.setEnabled(false);
		btnUndo = new JButton("Defaire");
		btnUndo.setVerticalAlignment(SwingConstants.TOP);
		btnUndo.addActionListener(actionListener);
		btnUndo.setIcon(new ImageIcon("icons/undoIcon.png"));
		btnRedo = new JButton("Refaire");
		btnRedo.setVerticalAlignment(SwingConstants.TOP);
		btnRedo.addActionListener(actionListener);
		btnRedo.setIcon(new ImageIcon("icons/redoIcon.png"));
		pnlBorder.add(btnCopy);
		pnlBorder.add(btnPaste);
		pnlBorder.add(btnCut);
		pnlBorder.add(btnRecording);
		pnlBorder.add(btnReplay);
		pnlBorder.add(btnUndo);
		pnlBorder.add(btnRedo);
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
			pnlText.setText(editorMotorImpl.getBuffer());
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

	/**
	 * this method changes the button text and it's icon it will be used for the
	 * register button when clicked
	 */
	public void changeButtonsProperties() {
		if (btnRecording.getText().contentEquals("Enregistrer")) {
			btnRecording.setText("Arrêter Enregistrement");
			btnRecording.setIcon(new ImageIcon("icons/stopIcon.png"));
			if (btnReplay.isEnabled()) {
				btnReplay.setEnabled(false);
			}
		} else if (btnRecording.getText().contentEquals("Arrêter Enregistrement")) {
			btnRecording.setText("Enregistrer");
			btnRecording.setIcon(new ImageIcon("icons/recordIcon.png"));
			if (!btnReplay.isEnabled()) {
				btnReplay.setEnabled(true);
			}
		}
		pnlText.requestFocusInWindow();
	}

	@Override
	public void setWarningMessage(String message) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(pnlText, message, "Attention", JOptionPane.WARNING_MESSAGE);
	}

	@Override
	public void setCaretPosition(int caretPosition) {
		int textLenght = pnlText.getText().length();
		if (caretPosition > -1 && caretPosition <= textLenght) {
			pnlText.setCaretPosition(caretPosition);
		}

	}

	@Override
	public void setFocusPanel() {
		// TODO Auto-generated method stub
		pnlText.requestFocusInWindow();
	}

}
