package fr.edu.istic.m1.miage.miniediteur.invoker;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class IHMP {

	private JFrame frmMiniEditeur;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IHMP window = new IHMP();
					window.frmMiniEditeur.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public IHMP() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMiniEditeur = new JFrame();
		frmMiniEditeur.setTitle("Mini Editeur");
		frmMiniEditeur.setForeground(Color.GRAY);
		frmMiniEditeur.setBackground(Color.GRAY);
		frmMiniEditeur.setBounds(100, 100, 450, 300);
		frmMiniEditeur.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel pnlBorder = new JPanel();
		frmMiniEditeur.getContentPane().add(pnlBorder, BorderLayout.NORTH);
		pnlBorder.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		
		JButton btnIns = new JButton("Ins\u00E9rer Texte");
		btnIns.setVerticalAlignment(SwingConstants.TOP);
		btnIns.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		pnlBorder.add(btnIns);
		
		JPanel pnlText = new JPanel();
		pnlText.setBackground(Color.WHITE);
		frmMiniEditeur.getContentPane().add(pnlText, BorderLayout.CENTER);
		pnlText.setLayout(null);
		
		JEditorPane edtText = new JEditorPane();
		edtText.setBounds(0, 0, 434, 241);
		pnlText.add(edtText);
	
	}
}
