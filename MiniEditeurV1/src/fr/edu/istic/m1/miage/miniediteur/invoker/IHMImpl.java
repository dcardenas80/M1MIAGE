package fr.edu.istic.m1.miage.miniediteur.invoker;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.CaretListener;

import fr.edu.istic.m1.miage.miniediteur.client.Client;
import fr.edu.istic.m1.miage.miniediteur.command.Coller;
import fr.edu.istic.m1.miage.miniediteur.command.Command;
import fr.edu.istic.m1.miage.miniediteur.command.Copier;
import fr.edu.istic.m1.miage.miniediteur.command.Couper;
import fr.edu.istic.m1.miage.miniediteur.command.InsText;
import fr.edu.istic.m1.miage.miniediteur.receiver.Selection;

/**
 * @author Diego Cardenas
 * @version 1.0
 * 
 */

public class IHMImpl implements IHM {

	/**
	 * Definition of Singleton Pattern to control the number of instances of the
	 * class IHMImpl
	 */
	private static IHMImpl IHMImplInstance;
	private static Client client;

	private int selectionOrigin;
	private int selectionSize;
	private String text;
	private char lastChart;
	private Couper couperSelection;
	private Coller collerSelection;
	private InsText insertText;
	private Selection texteSelection;
	private Copier copierSelection;
	private String textToInsert;
	private JFrame frmMiniEditeur;

	private IHMImpl(ActionListener actionListener, CaretListener caretListener, KeyListener keyListener) {
		initialize(actionListener, caretListener, keyListener);

	}

//	public void setText() {
//		Object[] options = { "Annuler", "Insérer" };
//
//		JPanel panel = new JPanel();
//		panel.add(new JLabel("Insérer Texte"));
//		JTextField textField = new JTextField(20);
//		panel.add(textField);
//
//		int result = JOptionPane.showOptionDialog(null, panel, "veuillez insérer votre texter",
//				JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
//
//		if (result == JOptionPane.YES_OPTION) {
//			this.setTextToInsert(textField.getText());
//		}
//	}

	private void initialize(ActionListener actionListener, CaretListener caretListener, KeyListener keyListener) {
		frmMiniEditeur = new JFrame();
		frmMiniEditeur.setTitle("Mini Editeur");
		frmMiniEditeur.setForeground(Color.GRAY);
		frmMiniEditeur.setBackground(Color.GRAY);
		frmMiniEditeur.setBounds(100, 100, 650, 500);
		frmMiniEditeur.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel pnlBorder = new JPanel();
		frmMiniEditeur.getContentPane().add(pnlBorder, BorderLayout.NORTH);
		pnlBorder.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

		JButton btnIns = new JButton("Ins\u00E9rer Texte");
		btnIns.setVerticalAlignment(SwingConstants.TOP);
		btnIns.addActionListener(actionListener);

		pnlBorder.add(btnIns);
		JTextArea pnlText = new JTextArea();
		pnlText.addCaretListener(caretListener);
		pnlText.addKeyListener(keyListener);
		pnlText.setBackground(Color.WHITE);
		frmMiniEditeur.getContentPane().add(pnlText, BorderLayout.CENTER);

	}

	public static IHMImpl getInstance() {
		if (IHMImplInstance == null) {
			client = Client.getInstance();
			IHMImplInstance = new IHMImpl(client,client,client);
			IHMImplInstance.frmMiniEditeur.setVisible(true);
		}
		return IHMImplInstance;
	}
	@Override
	public void setCommand(String key, Command command) {
		// TODO Auto-generated method stub
		if(key.contentEquals("textInsertion")) {
			insertText = (InsText) command;
			insertText.execute();
		}
		
	}

	/**
	 * Getters and Setters
	 */

	public int getSelectionOrigin() {
		return selectionOrigin;
	}

	public void setSelectionOrigin(int selectionOrigin) {
		this.selectionOrigin = selectionOrigin;
	}

	public int getSelectionSize() {
		return selectionSize;
	}

	public void setSelectionSize(int selectionSize) {
		this.selectionSize = selectionSize;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public char getLastChart() {
		return lastChart;
	}

	public void setLastChart(char lastChart) {
		this.lastChart = lastChart;
	}

	public String getTextToInsert() {
		return textToInsert;
	}

	public void setTextToInsert(String textToInsert) {
		this.textToInsert = textToInsert;
	}


}
