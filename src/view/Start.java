package view;

import java.awt.BorderLayout;
import model.Document;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Utils;

import javax.swing.JButton;
import javax.swing.JLabel;
import view.ClientsView;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
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
		Utils utils = new Utils();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{173, 171, 0};
		gbl_contentPane.rowHeights = new int[]{16, 102, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblVeuillezSelectionnerCe = new JLabel("Veuillez selectionner ce que vous voulez générer:");
		lblVeuillezSelectionnerCe.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		GridBagConstraints gbc_lblVeuillezSelectionnerCe = new GridBagConstraints();
		gbc_lblVeuillezSelectionnerCe.anchor = GridBagConstraints.NORTH;
		gbc_lblVeuillezSelectionnerCe.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblVeuillezSelectionnerCe.insets = new Insets(0, 0, 5, 0);
		gbc_lblVeuillezSelectionnerCe.gridwidth = 2;
		gbc_lblVeuillezSelectionnerCe.gridx = 0;
		gbc_lblVeuillezSelectionnerCe.gridy = 0;
		contentPane.add(lblVeuillezSelectionnerCe, gbc_lblVeuillezSelectionnerCe);
		
		
		JButton btnDevis = new JButton("Devis");
		GridBagConstraints gbc_btnDevis = new GridBagConstraints();
		gbc_btnDevis.fill = GridBagConstraints.VERTICAL;
		gbc_btnDevis.insets = new Insets(0, 0, 5, 5);
		gbc_btnDevis.gridx = 0;
		gbc_btnDevis.gridy = 1;
		contentPane.add(btnDevis, gbc_btnDevis);
		//btnDevis.addActionListener(this);
		
		btnDevis.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
				Document document = new Document("Devis");
				
				ClientsView clientsView = new view.ClientsView(document);
				clientsView.setVisible(true); 
				setVisible(false);
			}
		});
		
		
		JButton btnFacture = new JButton("Facture");
		GridBagConstraints gbc_btnFacture = new GridBagConstraints();
		gbc_btnFacture.insets = new Insets(0, 0, 5, 0);
		gbc_btnFacture.fill = GridBagConstraints.VERTICAL;
		gbc_btnFacture.gridx = 1;
		gbc_btnFacture.gridy = 1;
		contentPane.add(btnFacture, gbc_btnFacture);
		
		JButton btnExcelClient = new JButton("Générer listing clients");
		GridBagConstraints gbc_btnExcelClient = new GridBagConstraints();
		gbc_btnExcelClient.gridwidth = 2;
		gbc_btnExcelClient.insets = new Insets(0, 0, 0, 5);
		gbc_btnExcelClient.gridx = 0;
		gbc_btnExcelClient.gridy = 2;
		contentPane.add(btnExcelClient, gbc_btnExcelClient);
		
		btnFacture.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				Document document = new Document("Facture");
				ClientsView clientsView = new view.ClientsView(document);
				clientsView.setVisible(true); 
				setVisible(false);
			}
		});
	}

}
