package fr.edu.istic.m1.miage.miniediteur;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

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
	private static MonAppli monAppli;
	private Couper couperSelection;
	private Coller collerSelection;
	private InsText insertText;
	private Selection texteSelection;
	private Copier copierSelection;
	private String textToInsert;

	private IHMImpl(ActionListener listener) {
		initialize(listener);

	}

	public void setText() {
		Object[] options = { "Annuler", "Insérer" };

		JPanel panel = new JPanel();
		panel.add(new JLabel("Insérer Texte"));
		JTextField textField = new JTextField(20);
		panel.add(textField);

		int result = JOptionPane.showOptionDialog(null, panel, "veuillez insérer votre texter",
				JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);

		if (result == JOptionPane.YES_OPTION) {
			this.setTextToInsert(textField.getText());
		}
	}
	
	public String getTextToInsert() {
		return textToInsert;
	}

	public void setTextToInsert(String textToInsert) {
		this.textToInsert = textToInsert;
	}
	public Couper getCouperSelection() {
		return couperSelection;
	}

	public void setCouperSelection(Couper couperSelection) {
		this.couperSelection = couperSelection;
	}

	public Coller getCollerSelection() {
		return collerSelection;
	}

	public void setCollerSelection(Coller collerSelection) {
		this.collerSelection = collerSelection;
	}

	public InsText getInsertText() {
		return insertText;
	}

	public void setInsertText(InsText insertText) {
		this.insertText = insertText;
	}

	public Selection getTexteSelection() {
		return texteSelection;
	}

	public void setTexteSelection(Selection texteSelection) {
		this.texteSelection = texteSelection;
	}

	public Copier getCopierSelection() {
		return copierSelection;
	}

	public void setCopierSelection(Copier copierSelection) {
		this.copierSelection = copierSelection;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private JFrame frmMiniEditeur;
	private JEditorPane edtText;

	private void initialize(ActionListener listener) {
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
		btnIns.addActionListener(listener);

		pnlBorder.add(btnIns);
		JPanel pnlText = new JPanel();
		pnlText.setBackground(Color.WHITE);
		frmMiniEditeur.getContentPane().add(pnlText, BorderLayout.CENTER);

		edtText = new JEditorPane();
		edtText.setBounds(0, 0, 434, 241);
		pnlText.add(edtText);

	}

	public static IHMImpl getInstance() {
		if (IHMImplInstance == null) {
			monAppli = MonAppli.getInstance();
			IHMImplInstance = new IHMImpl(monAppli);
			IHMImplInstance.frmMiniEditeur.setVisible(true);
		}
		return IHMImplInstance;
	}

}
