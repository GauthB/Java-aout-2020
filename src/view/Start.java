package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import view.Clients;
public class Start extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start frame = new Start();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Start() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
		JButton btnDevis = new JButton("Devis");
		contentPane.add(btnDevis, BorderLayout.WEST);
		//btnDevis.addActionListener(this);
		btnDevis.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Clients clients = new view.Clients();
				clients.setVisible(true); 
				setVisible(false);
			}
		});
		
		JButton btnFacture = new JButton("Facture");
		contentPane.add(btnFacture, BorderLayout.EAST);
		
		btnDevis.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Clients clients = new view.Clients();
				clients.setVisible(true); 
				setVisible(false);
			}
		});
		
		JLabel lblVeuillezSelectionnerCe = new JLabel("Veuillez selectionner ce que vous voulez générer:");
		contentPane.add(lblVeuillezSelectionnerCe, BorderLayout.NORTH);
	}

}
