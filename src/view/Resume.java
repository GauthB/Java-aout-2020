package view;

import java.awt.BorderLayout;
import view.Start;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Color;
import model.Utils;
import javax.swing.JTextField;
public class Resume extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Resume frame = new Resume();
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
	public Resume() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{64, 116, 152, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblFacture = new JLabel("Facture");
		lblFacture.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		GridBagConstraints gbc_lblFacture = new GridBagConstraints();
		gbc_lblFacture.gridwidth = 2;
		gbc_lblFacture.insets = new Insets(0, 0, 5, 5);
		gbc_lblFacture.gridx = 1;
		gbc_lblFacture.gridy = 0;
		contentPane.add(lblFacture, gbc_lblFacture);
		
		Utils utils = new Utils();
		LocalDate today = Utils.GetDate();
		
		JLabel lblDate = new JLabel("Date: "+today);
		GridBagConstraints gbc_lblDate = new GridBagConstraints();
		gbc_lblDate.anchor = GridBagConstraints.WEST;
		gbc_lblDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblDate.gridx = 1;
		gbc_lblDate.gridy = 1;
		contentPane.add(lblDate, gbc_lblDate);
		
		JLabel lblNom = new JLabel("Nom");
		GridBagConstraints gbc_lblNom = new GridBagConstraints();
		gbc_lblNom.anchor = GridBagConstraints.WEST;
		gbc_lblNom.insets = new Insets(0, 0, 5, 5);
		gbc_lblNom.gridx = 1;
		gbc_lblNom.gridy = 2;
		contentPane.add(lblNom, gbc_lblNom);
		
		JLabel lblAdresse = new JLabel("Adresse");
		GridBagConstraints gbc_lblAdresse = new GridBagConstraints();
		gbc_lblAdresse.anchor = GridBagConstraints.WEST;
		gbc_lblAdresse.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdresse.gridx = 1;
		gbc_lblAdresse.gridy = 3;
		contentPane.add(lblAdresse, gbc_lblAdresse);
		
		JLabel lblNumroDeTva = new JLabel("Numéro de TVA");
		GridBagConstraints gbc_lblNumroDeTva = new GridBagConstraints();
		gbc_lblNumroDeTva.anchor = GridBagConstraints.WEST;
		gbc_lblNumroDeTva.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumroDeTva.gridx = 1;
		gbc_lblNumroDeTva.gridy = 4;
		contentPane.add(lblNumroDeTva, gbc_lblNumroDeTva);
		
		JLabel lblMail = new JLabel("Mail");
		GridBagConstraints gbc_lblMail = new GridBagConstraints();
		gbc_lblMail.anchor = GridBagConstraints.WEST;
		gbc_lblMail.insets = new Insets(0, 0, 5, 5);
		gbc_lblMail.gridx = 1;
		gbc_lblMail.gridy = 5;
		contentPane.add(lblMail, gbc_lblMail);
		
		JLabel lblTlphone = new JLabel("Téléphone");
		GridBagConstraints gbc_lblTlphone = new GridBagConstraints();
		gbc_lblTlphone.anchor = GridBagConstraints.WEST;
		gbc_lblTlphone.insets = new Insets(0, 0, 5, 5);
		gbc_lblTlphone.gridx = 1;
		gbc_lblTlphone.gridy = 6;
		contentPane.add(lblTlphone, gbc_lblTlphone);
		
		
		
		String[] columnNames = {"Quantite",
                "Description",
                "Prix hors TVA"};
		Object[][] data = {
			    {"1", "Hebergement",
			     "100"},
			    {"1", "Nom de domaine",
			     "15"},
			    {"6", "Création (€/h)",
			     "25"}
			};
		

		table = new JTable(data, columnNames);
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridwidth = 2;
		gbc_table.insets = new Insets(0, 0, 5, 5);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 1;
		gbc_table.gridy = 7;
		contentPane.add(table, gbc_table);
		
		JLabel lblTva = new JLabel("% TVA:");
		GridBagConstraints gbc_lblTva = new GridBagConstraints();
		gbc_lblTva.anchor = GridBagConstraints.EAST;
		gbc_lblTva.insets = new Insets(0, 0, 5, 5);
		gbc_lblTva.gridx = 0;
		gbc_lblTva.gridy = 8;
		contentPane.add(lblTva, gbc_lblTva);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 8;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JButton btnCalculerLeTotal = new JButton("Calculer le total");
		GridBagConstraints gbc_btnCalculerLeTotal = new GridBagConstraints();
		gbc_btnCalculerLeTotal.anchor = GridBagConstraints.WEST;
		gbc_btnCalculerLeTotal.insets = new Insets(0, 0, 5, 5);
		gbc_btnCalculerLeTotal.gridx = 2;
		gbc_btnCalculerLeTotal.gridy = 8;
		contentPane.add(btnCalculerLeTotal, gbc_btnCalculerLeTotal);
		
		btnCalculerLeTotal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
			}
		});
		
		
		JLabel lblTotal = new JLabel("Total HTVA:");
		GridBagConstraints gbc_lblTotal = new GridBagConstraints();
		gbc_lblTotal.anchor = GridBagConstraints.WEST;
		gbc_lblTotal.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotal.gridx = 1;
		gbc_lblTotal.gridy = 9;
		contentPane.add(lblTotal, gbc_lblTotal);
		
		JLabel lblTotalTva = new JLabel("Total TVA:");
		GridBagConstraints gbc_lblTotalTva = new GridBagConstraints();
		gbc_lblTotalTva.anchor = GridBagConstraints.WEST;
		gbc_lblTotalTva.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotalTva.gridx = 1;
		gbc_lblTotalTva.gridy = 10;
		contentPane.add(lblTotalTva, gbc_lblTotalTva);
		
		JLabel lblTotalTvac = new JLabel("Total TVAC:");
		GridBagConstraints gbc_lblTotalTvac = new GridBagConstraints();
		gbc_lblTotalTvac.anchor = GridBagConstraints.WEST;
		gbc_lblTotalTvac.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotalTvac.gridx = 1;
		gbc_lblTotalTvac.gridy = 11;
		contentPane.add(lblTotalTvac, gbc_lblTotalTvac);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setForeground(Color.RED);
		GridBagConstraints gbc_btnAnnuler = new GridBagConstraints();
		gbc_btnAnnuler.insets = new Insets(0, 0, 0, 5);
		gbc_btnAnnuler.gridx = 1;
		gbc_btnAnnuler.gridy = 12;
		contentPane.add(btnAnnuler, gbc_btnAnnuler);
		
		btnAnnuler.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Start start = new view.Start();
				start.setVisible(true); 
				setVisible(false);
			}
		});
		
		JButton btnGnrer = new JButton("Générer");
		btnGnrer.setForeground(Color.BLACK);
		GridBagConstraints gbc_btnGnrer = new GridBagConstraints();
		gbc_btnGnrer.insets = new Insets(0, 0, 0, 5);
		gbc_btnGnrer.gridx = 2;
		gbc_btnGnrer.gridy = 12;
		contentPane.add(btnGnrer, gbc_btnGnrer);
		
		btnGnrer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
			}
		});
	}

}
